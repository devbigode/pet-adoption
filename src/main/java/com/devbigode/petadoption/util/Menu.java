package com.devbigode.petadoption.util;

import java.util.InputMismatchException;
import java.util.Scanner;

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

    public static void validateChoice(){
        try (Scanner input = new Scanner(System.in)){
            System.out.print("Escolha uma opção: ");
            int choice = 0;

            while ((choice < 1 || choice > 6)){
                choice = input.nextInt();

                if (choice < 1 || choice > 6){
                    printOptions();
                    System.out.print("Digite um número natural válido: ");
                }
            }

        } catch (InputMismatchException e){
            throw new InputMismatchException("Entrada inválida. Digite um número natural.");
        }
    }
}
