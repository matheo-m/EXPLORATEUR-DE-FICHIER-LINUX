package com.esiea.pootd2;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.interfaces.AbstractInterface;
import com.esiea.pootd2.interfaces.HttpInterface;
import com.esiea.pootd2.interfaces.TextInterface;

public class ExplorerApp {
    public static void main(String[] args) {
        ExplorerController controller = new ExplorerController();

        // System.out.println(controller.executeCommand("mkdir test"));
        // System.out.println(controller.executeCommand("cd test"));
        // System.out.println(controller.executeCommand("mkdir test"));
        // System.out.println(controller.executeCommand("cd test"));
        // System.out.println(controller.executeCommand("mkdir test"));
        // System.out.println(controller.executeCommand("cd test"));
        // System.out.println(controller.executeCommand("pwd"));

        AbstractInterface userInterface;
        if (args.length > 0 && "http".equalsIgnoreCase(args[0])) {
            userInterface = new HttpInterface(controller);
        } else {
            userInterface = new TextInterface(controller);
        }

        userInterface.run();
    }
}
