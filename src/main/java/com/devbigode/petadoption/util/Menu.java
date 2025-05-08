package com.devbigode.petadoption.util;

import com.devbigode.petadoption.model.Pet;
import com.devbigode.petadoption.service.PetService;
import static com.devbigode.petadoption.app.Main.input;
import java.util.InputMismatchException;
import java.util.List;

public class Menu {

    public static void printOptions(){
        String options = "1. Cadastrar um novo pet\n" +
                "2. Alterar os dados do pet cadastrado\n" +
                "3. Deletar um pet cadastrado\n" +
                "4. Listar todos os pets cadastrados\n" +
                "5. Listar pets por algum critério (idade, nome, raça)\n" +
                "6. Sair\n";

        System.out.println(options);
    }

    public static int validateChoice(){
        int choice = 0;

        try {
            System.out.print("Escolha uma opção: ");

            while ((choice < 1 || choice > 6)){
                choice = input.nextInt();

                if (choice < 1 || choice > 6){
                    printOptions();
                    System.out.print("Digite um número natural válido: ");
                }
            }
            input.nextLine();
        } catch (InputMismatchException e){
            throw new InputMismatchException("Entrada inválida. Digite um número natural.");
        }

        return choice;
    }

    public static void selectedOption(int option){
        switch (option){
            case 1:
                System.out.println("--- Tela de cadastro de animal de estimação ---");
                List<String> questionsList = FileUtils.readQuestions();
                Pet createdPet = PetService.createPet(questionsList);
                FileUtils.petToFile(createdPet);
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            case 6:
                System.out.println("Sistema encerrando...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
