package com.esiea.pootd2.interfaces;

import com.esiea.pootd2.controllers.IExplorerController;

import java.util.Scanner;

public class TextInterface extends AbstractInterface implements IUserInterface {
    public TextInterface(IExplorerController controller) {
        super(controller);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans l'explorateur de fichiers. Tapez 'exit' pour quitter.");
        while (true) {
            String currentPath = controller.getCurrentPath();
            System.out.print(currentPath+"> ");
            String command = scanner.nextLine();

            if ("exit".equalsIgnoreCase(command.trim())) {
                System.out.println("Sortie de l'explorateur de fichiers. Au revoir!");
                break;
            }

            String result = controller.executeCommand(command);
            System.out.println(result);
        }

        scanner.close();
    }
}
