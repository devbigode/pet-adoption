package com.devbigode.petadoption.service;

import com.devbigode.petadoption.model.Address;
import com.devbigode.petadoption.model.Pet;
import com.devbigode.petadoption.model.Sex;
import com.devbigode.petadoption.model.Type;
import com.devbigode.petadoption.ui.PetConsoleUI;

import java.util.List;

public class PetCreator {
    public static Pet createPet(List<String> questionsList) {
        if (questionsList == null) {
            throw new NullPointerException("A lista de perguntas é nula ou está vazia.");
        }

        Pet newPet = new Pet();

        for (String question : questionsList) {
            switch (question.trim().substring(0, 1)) {
                case "1" -> PetCreator.handleFullName(newPet, question);
                case "2" -> PetCreator.handleType(newPet, question);
                case "3" -> PetCreator.handleSex(newPet, question);
                case "4" -> PetCreator.handleAddress(newPet, question);
                case "5" -> PetCreator.handleAge(newPet, question);
                case "6" -> PetCreator.handleWeight(newPet, question);
                case "7" -> PetCreator.handleBreed(newPet, question);
                default -> System.out.println("Opção desconhecida: " + question);
            }
        }

        System.out.println("\nPet criado com sucesso!✅");
        return newPet;
    }

    /* Handles methods */

    public static void handleFullName(Pet newPet, String question) {
        System.out.println("\n" + question);

        String[] fullname = PetConsoleUI.askFullName();
        String name = fullname[0];
        String lastname = fullname[1];

        String[] validFullname = PetValidator.validateFullName(name, lastname);
        String validName = validFullname[0];
        String validLastname = validFullname[1];

        newPet.setName(validName);
        newPet.setLastname(validLastname);
    }

    public static void handleType(Pet newPet, String question) {
        System.out.println("\n" + question);
        String validType = PetValidator.validateType(PetConsoleUI.askType());

        if (validType.equalsIgnoreCase("Cachorro")) {
            newPet.setType(Type.DOG);
        } else {
            newPet.setType(Type.CAT);
        }
    }

    public static void handleSex(Pet newPet, String question) {
        System.out.println("\n" + question);
        String validSex = PetValidator.validateSex(PetConsoleUI.askSex());

        if (validSex.equalsIgnoreCase("Macho")){
            newPet.setSex(Sex.MALE);
        } else {
            newPet.setSex(Sex.FEMALE);
        }
    }

    public static void handleAddress(Pet newPet, String question) {
        System.out.println("\n" + question);

        String[] address = PetConsoleUI.askAddress();
        String number = address[0];
        String street = address[1];
        String city = address[2];

        String[] validAddress = PetValidator.validateAddress(number, street, city);

        Address newAddress = new Address();

        newAddress.setNumber(validAddress[0]);
        newAddress.setStreet(validAddress[1]);
        newAddress.setCity(validAddress[2]);

        newPet.setAddress(newAddress);
    }

    public static void handleAge(Pet newPet, String question) {
        System.out.println("\n" + question);
        double validAge = PetValidator.validateAge(PetConsoleUI.askAge());

        newPet.setAge(validAge);
    }

    public static void handleWeight(Pet newPet, String question) {
        System.out.println("\n" + question);
        double validWeight = PetValidator.validateWeight(PetConsoleUI.askWeight());

        newPet.setWeight(validWeight);
    }

    public static void handleBreed(Pet newPet, String question) {
        System.out.println("\n" + question);
        String validBreed = PetValidator.validateBreed(PetConsoleUI.askBreed());

        newPet.setBreed(validBreed);
    }
}
