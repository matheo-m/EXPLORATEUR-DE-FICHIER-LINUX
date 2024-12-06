package com.esiea.pootd2.controllers;

import com.esiea.pootd2.commands.ChangeDirectoryCommand;
import com.esiea.pootd2.commands.Command;
import com.esiea.pootd2.commands.ErrorCommand;
import com.esiea.pootd2.commands.ListCommand;
import com.esiea.pootd2.commands.MakeDirectoryCommand;
import com.esiea.pootd2.commands.TouchCommand;
import com.esiea.pootd2.commands.parsers.UnixLikeCommandParser;
import com.esiea.pootd2.models.FileInode;
import com.esiea.pootd2.models.FolderInode;

public class ExplorerController implements IExplorerController {

    private FolderInode currentDirectory;

    public ExplorerController() {
        this.currentDirectory = new FolderInode("/"); // Dossier racine
    }

    @Override
    public String executeCommand(String commandStr) {
        UnixLikeCommandParser parser = new UnixLikeCommandParser();
        Command command = parser.parse(commandStr);
        return doCommand(command);
    }

    private String doCommand(Command command) {
        if (command instanceof ListCommand) {
            return doListCommand();
        } else if (command instanceof ChangeDirectoryCommand) {
            return doChangeDirectoryCommand((ChangeDirectoryCommand) command);
        } else if (command instanceof MakeDirectoryCommand) {
            return doMakeDirectoryCommand((MakeDirectoryCommand) command);
        } else if (command instanceof TouchCommand) {
            return doTouchCommand((TouchCommand) command);
        } else if (command instanceof ErrorCommand) {
            return ((ErrorCommand) command).getErrorMessage();
        } else {
            return "Unknown command type.";
        }
    }

    private String doListCommand() {
        String output = "";
        for (var inode : currentDirectory.getChildren()) {
            output += inode.getName() + "\t\t" + inode.getSize() + "\n";
        }
        return output.trim();
    }

    private String doChangeDirectoryCommand(ChangeDirectoryCommand command) {
        String path = command.getPath();
        FolderInode target = findFolderByPath(path);
        if (target == null) {
            return "Directory not found: " + path;
        }
        this.currentDirectory = target;
        return "Changed directory to " + path;
    }

    private String doMakeDirectoryCommand(MakeDirectoryCommand command) {
        String dirName = command.getDirectoryName();
        FolderInode newDir = new FolderInode(dirName);
        currentDirectory.addInode(newDir);
        return "Directory created: " + dirName;
    }

    private String doTouchCommand(TouchCommand command) {
        String fileName = command.getFileName();
        FileInode newFile = new FileInode(fileName);
        currentDirectory.addInode(newFile);
        return "File created: " + fileName;
    }

    private FolderInode findFolderByPath(String path) {
        if (path == null || path.isEmpty()) {
            return null;
        }

        FolderInode current = path.startsWith("/") ? getRoot() : currentDirectory; // Si le chemin est absolu, commencer
                                                                                   // à la racine

        String[] parts = path.split("/"); // Découper le chemin en parties

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {// Partie vide ou "." signifie rester au même dossier
                continue;
            } else if (part.equals("..")) {// ".." signifie remonter d'un niveau
                if (current.getParent() != null) {
                    current = current.getParent();
                } else {
                    return null;
                }
            } else { // 
                boolean found = false;
                for (var inode : current.getChildren()) {
                    if (inode instanceof FolderInode && inode.getName().equals(part)) {
                        current = (FolderInode) inode;
                        found = true;
                        break;
                    }

                }
                if (!found) {
                    return null; // Dossier introuvable
                }

            }
        }

        return current;
    }

    private FolderInode getRoot() { // Récupère la racine du système de fichiers

        FolderInode current = currentDirectory;

        while (current.getParent() != null) { // Tant qu'il y a un dossier parent, remonte d'un niveau
            current = current.getParent();
        }
        return current;
    }

}
