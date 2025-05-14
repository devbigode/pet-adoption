package com.devbigode.petadoption.app;

import com.devbigode.petadoption.ui.Menu;
import java.util.Scanner;

public class Main {

    public static final Scanner input = new Scanner(System.in);

    public static void runApplication(){
        Menu.printOptions();

        int choice;

        do {
            choice = Menu.validateChoice();
            Menu.selectedOption(choice);
        } while (choice != 6);

        input.close();
    }

    public static void main(String[] args) {
        runApplication();
    }
}
