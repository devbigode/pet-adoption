package com.devbigode.petadoption.service;

import com.devbigode.petadoption.model.Pet;
import com.devbigode.petadoption.ui.PetConsoleUI;

import java.text.Normalizer;

public class PetFilter {
    public static String normalize(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();
    }

    public static void filterByFullName(String type, String name, String lastname) {
        String inputName = normalize(name);
        String inputLastname = normalize(lastname);

        for (Pet pet : PetService.petList) {
            String petName = normalize(pet.getName());
            String petLastname = normalize(pet.getName());

            if (pet.getType().getName().equalsIgnoreCase(type) && (petName.contains(inputName) || petLastname.contains(inputLastname))) {
                PetConsoleUI.printPet(pet);
            }
        }
    }

    public static void filterBySex(String type, String sex) {
        String inputSex = normalize(sex);

        for (Pet pet : PetService.petList) {

            String petSex = normalize(pet.getSex().getName());

            if (pet.getType().getName().equalsIgnoreCase(type) && petSex.equals(inputSex)) {
                PetConsoleUI.printPet(pet);
            }
        }
    }

    public static void filterByAge(String type, double age) {
        for (Pet pet : PetService.petList) {
            if (pet.getType().getName().equalsIgnoreCase(type) && pet.getAge() == age) {
                PetConsoleUI.printPet(pet);
            }
        }
    }

    public static void filterByWeight(String type, double weight) {
        for (Pet pet : PetService.petList) {
            if (pet.getType().getName().equalsIgnoreCase(type) && pet.getWeight() == weight) {
                PetConsoleUI.printPet(pet);
            }
        }
    }

    public static void filterByBreed(String type, String breed) {
        String inputBreed = normalize(breed);

        for (Pet pet : PetService.petList) {
            String petBreed = normalize(pet.getBreed());

            if (pet.getType().getName().equalsIgnoreCase(type) && petBreed.contains(inputBreed)) {
                PetConsoleUI.printPet(pet);
            }
        }
    }

    public static void filterByAddress(String type, String number, String street, String city) {
        String inputNumber = normalize(number);
        String inputStreet = normalize(street);
        String inputCity = normalize(city);

        for (Pet pet : PetService.petList) {
            String petNumber = normalize(pet.getAddress().getNumber());
            String petStreet = normalize(pet.getAddress().getStreet());
            String petCity = normalize(pet.getAddress().getCity());

            if (pet.getType().getName().equalsIgnoreCase(type) && (
                    petNumber.contains(inputNumber) ||
                    petStreet.contains(inputStreet) ||
                    petCity.contains(inputCity))) {
                PetConsoleUI.printPet(pet);
            }
        }
    }
}
