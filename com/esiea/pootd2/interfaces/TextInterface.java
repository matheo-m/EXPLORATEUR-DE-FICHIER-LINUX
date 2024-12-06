package com.esiea.pootd2.interfaces;

public class TextInterface implements IUserInterface {

    @Override
    public void run() {
        String stdin = System.console().readLine();

        while (stdin != null && !stdin.equals("exit")){
            
            System.out.println("You said: " + stdin);
            stdin = System.console().readLine();
        
        }

    }

    
}
