package com.epam.pos;

import com.epam.pos.com.epam.pos.comands.Command;
import com.epam.pos.com.epam.pos.comands.CommandFactory;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        final String SHUT_DOWN_COMMAND = "off";
        final String HELP_COMMAND = "h";
        BeverageMachine machine = new BeverageMachine();
        Command command = null;
        Scanner scanner = new Scanner(System.in);
        String givenCommand = null;
        System.out.println("Hello!");
        showHelp();
        do {
            givenCommand = scanner.next();
            if(HELP_COMMAND.equals(givenCommand)){
                showHelp();
            } else {
                command = CommandFactory.getCommand(givenCommand, machine);
                if(command != null){
                    command.doAction();
                } else {
                    System.out.println("This kind of operation doesn't exist!");
                }
            }
        } while(!SHUT_DOWN_COMMAND.equals(givenCommand));
    }

    private static void showHelp(){
        System.out.println("For choosing beverage - type : \"choose\"");
        System.out.println("For buying chosen beverages - type : \"buy\"");
        System.out.println("For canceling sale - type : \"buy\"");
        System.out.println("If you want ot shut down machine - type : \"off\"");
        System.out.println("If you want to see help - type : \"h\"");
    }

}
