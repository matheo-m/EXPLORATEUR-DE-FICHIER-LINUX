package com.esiea.pootd2.interfaces;

import java.util.Scanner;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.controllers.IExplorerController;

public class TextInterface implements IUserInterface {

    private IExplorerController controller;

    public TextInterface(IExplorerController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the file explorer. Type 'exit' to quit.");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if ("exit".equalsIgnoreCase(command.trim())) {
                System.out.println("Exiting the file explorer. Goodbye!");
                break;
            }

            String result = controller.executeCommand(command);
            System.out.println(result);
        }

        scanner.close();

    }

    
}
