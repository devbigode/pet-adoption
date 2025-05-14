package com.devbigode.petadoption.service;

import com.devbigode.petadoption.model.*;
import com.devbigode.petadoption.util.FileUtils;
import com.devbigode.petadoption.ui.PetConsoleUI;

import java.util.List;
import java.util.ArrayList;

public class PetService {
    public static final List<Pet> petList = new ArrayList<>();

    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    public static void registerPet() {
        System.out.println("\n--- Tela de cadastro de animal de estimação ---");

        List<String> questionsList = FileUtils.readQuestions();
        Pet createdPet = PetCreator.createPet(questionsList);
        PetService.petToList(createdPet);
        FileUtils.petToFile(createdPet);
    }

    public static void searchPet() {
        System.out.println("\n--- Pesquisa de animal de estimação ---\n");

        System.out.println("Qual o tipo de animal deseja buscar (cachorro ou gato)?");
        String chosenType = PetValidator.validateType(PetConsoleUI.askType());

        String[] searchChoice = PetValidator.validateChoiceSearch(PetConsoleUI.pickCriteria());

        if (searchChoice == null) {
            throw new IllegalArgumentException("Erro ao validar escolha de critérios.");
        }

        if (searchChoice.length == 1) {
            switch (searchChoice[0]) {
                case "1" -> {
                    String[] fullname = PetConsoleUI.askFullName();

                    String[] validFullname = PetValidator.validateFullName(fullname[0], fullname[1]);

                    PetFilter.filterByFullName(chosenType, validFullname[0], validFullname[1]);
                }
                case "2" -> {
                    String validSex = PetValidator.validateSex(PetConsoleUI.askSex());
                    PetFilter.filterBySex(chosenType, validSex);
                }
                case "3" -> {
                    double validAge = PetValidator.validateAge(PetConsoleUI.askAge());
                    PetFilter.filterByAge(chosenType, validAge);
                }
                case "4" -> {
                    double validWeight = PetValidator.validateWeight(PetConsoleUI.askWeight());
                    PetFilter.filterByWeight(chosenType, validWeight);
                }
                case "5" -> {
                    String validBreed = PetValidator.validateBreed(PetConsoleUI.askBreed());
                    PetFilter.filterByBreed(chosenType, validBreed);
                }
                case "6" -> {
                    String[] address = PetConsoleUI.askAddress();

                    String[] validAdress = PetValidator.validateAddress(address[0], address[1], address[2]);

                    PetFilter.filterByAddress(chosenType, validAdress[0], validAdress[1], validAdress[2]);
                }
                default -> System.out.println("Opção desconhecida.");
            }
        }
    }

    public static void getAllPet() {
        if (petList.isEmpty()) {
            System.out.println("\nNenhum animal de estimação foi cadastrado.");
        } else {
            System.out.println("\n--- Lista de pets cadastrados ---\n");
            petList.forEach(PetConsoleUI::printPet);
        }
    }

    public static void petToList(Pet newPet) {
        petList.add(newPet);
        System.out.println("\nPet armazenado com sucesso!✅");
    }
}