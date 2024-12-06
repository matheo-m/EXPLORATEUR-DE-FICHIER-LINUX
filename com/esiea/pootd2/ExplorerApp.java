package com.esiea.pootd2;

import com.esiea.pootd2.models.FileInode;
import com.esiea.pootd2.models.FolderInode;

import com.esiea.pootd2.commands.*;

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
        
        Command c1 = new ListCommand();
        Command c2 = new ChangeDirectoryCommand("../home");
        Command c3 = new MakeDirectoryCommand("Documents");
        Command c4 = new TouchCommand("Photo_de_vacances.png");
        Command c5 = new ErrorCommand("Internal error");

        }
}
