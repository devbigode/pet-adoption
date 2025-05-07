package com.devbigode.petadoption.app;

import com.devbigode.petadoption.util.*;
import java.util.Scanner;

public class Main {

    public static final Scanner input = new Scanner(System.in);

    public static void runApplication(){
        Menu.printOptions();
        Menu.selectedOption(Menu.validateChoice());
    }

    public static void main(String[] args) {
        runApplication();
    }
}
