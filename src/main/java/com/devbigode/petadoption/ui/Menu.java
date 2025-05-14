package com.devbigode.petadoption.ui;

import com.devbigode.petadoption.service.PetService;
import java.util.InputMismatchException;
import static com.devbigode.petadoption.app.Main.input;

public class Menu {
    public static void printOptions() {
        String options = """
                
                1. Cadastrar um novo pet
                2. Alterar os dados do pet cadastrado
                3. Deletar um pet cadastrado
                4. Listar todos os pets cadastrados
                5. Listar pets por algum critério (idade, nome, raça)
                6. Sair            
                """;

        System.out.println(options);
    }

    public static int validateChoice() {
        int choice = 0;

        try {
            System.out.print("Escolha uma opção: ");

            while ((choice < 1 || choice > 6)) {
                choice = input.nextInt();

                if (choice < 1 || choice > 6) {
                    printOptions();
                    System.out.print("Digite um número natural válido: ");
                }
            }
            input.nextLine();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Entrada inválida. Digite um número natural.");
        }

        return choice;
    }

    public static void selectedOption(int option) {
        switch (option) {
            case 1 -> {
                PetService.registerPet();
                printOptions();
            }
            case 2 -> {
                System.out.println("2");
            }
            case 3 -> {
                System.out.println("3");
            }
            case 4 -> {
                PetService.getAllPet();
                printOptions();
            }
            case 5 -> {
                PetService.searchPet();
                printOptions();
            }
            case 6 -> System.out.println("\nEncerrando...");
            default -> System.out.println("\nOpção inválida!");
        }
    }
}
