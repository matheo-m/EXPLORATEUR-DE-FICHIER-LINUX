package com.esiea.pootd2;

import com.esiea.pootd2.models.FileInode;
import com.esiea.pootd2.models.FolderInode;

import com.esiea.pootd2.commands.*;
import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.interfaces.TextInterface;

public class ExplorerApp {

    public static void main(String[] args) {
        // FolderInode root = new FolderInode("/");
        // FolderInode folder1 = new FolderInode("POO");
        // FolderInode folder2 = new FolderInode("TD2");
        // root.addInode(folder1);
        // folder1.addInode(folder2);
        // FileInode file1 = new FileInode("TD1.pdf");
        // FileInode file2 = new FileInode("Main.java");
        // FileInode file3 = new FileInode("Main.class");
        // folder1.addInode(file1);
        // folder2.addInode(file2);
        // folder2.addInode(file3);

        ExplorerController controller = new ExplorerController();

        // System.out.println(controller.executeCommand("mkdir TestFolder"));
        // System.out.println(controller.executeCommand("touch file1.txt"));
        // System.out.println(controller.executeCommand("ls"));
        // System.out.println(controller.executeCommand("cd TestFolder"));
        // System.out.println(controller.executeCommand("ls"));

        TextInterface textInterface = new TextInterface(controller);

        textInterface.run();
    }
}
