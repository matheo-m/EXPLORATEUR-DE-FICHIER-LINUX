package com.esiea.pootd2.models;

import java.util.ArrayList;

public class FolderInode extends Inode {
    private int size;
    private ArrayList<Inode> children;

    public FolderInode(String name) {
        super(name);
        this.size = 0;
        this.children = new ArrayList<>();
    }

    public int getSize() {
        for (Inode child : children) {
            this.size += child.getSize();
        }

        return this.size;
    }

    public void setParent(Inode inode) {
        inode.parent = this;
    }

    public void addInode(Inode inode) {
        this.setParent(inode);
        this.children.add(inode);
    }

    public ArrayList<Inode> getChildren() {
        return this.children;
    }

}
