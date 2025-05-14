package com.devbigode.petadoption.service;

import com.devbigode.petadoption.model.Pet;
import com.devbigode.petadoption.ui.PetConsoleUI;

public class PetFilter {
    public static void filterByFullName(String type, String name, String lastname) {
        for (Pet pet : PetService.petList) {
            if (pet.getType().getName().equalsIgnoreCase(type) & (pet.getName().contains(name) | pet.getLastname().contains(lastname))) {
                PetConsoleUI.printPet(pet);
            }
        }
    }

    public static void filterBySex(String type, String sex) {
        for (Pet pet : PetService.petList) {
            if (pet.getType().getName().equalsIgnoreCase(type) & pet.getSex().getName().equalsIgnoreCase(sex)) {
                PetConsoleUI.printPet(pet);
            }
        }
    }

    public static void filterByAge(String type, double age) {
        for (Pet pet : PetService.petList) {
            if (pet.getType().getName().equalsIgnoreCase(type) & pet.getAge() == age) {
                PetConsoleUI.printPet(pet);
            }
        }
    }

    public static void filterByWeight(String type, double weight) {
        for (Pet pet : PetService.petList) {
            if (pet.getType().getName().equalsIgnoreCase(type) & pet.getWeight() == weight) {
                PetConsoleUI.printPet(pet);
            }
        }
    }

    public static void filterByBreed(String type, String breed) {
        for (Pet pet : PetService.petList) {
            if (pet.getType().getName().equalsIgnoreCase(type) & pet.getBreed().equalsIgnoreCase(breed)) {
                PetConsoleUI.printPet(pet);
            }
        }
    }

    public static void filterByAddress(String type, String number, String street, String city) {
        for (Pet pet : PetService.petList) {
            if (pet.getType().getName().equalsIgnoreCase(type) & (
                    pet.getAddress().getNumber().equals(number) |
                            pet.getAddress().getStreet().equalsIgnoreCase(street) |
                            pet.getAddress().getCity().equalsIgnoreCase(city))) {
                PetConsoleUI.printPet(pet);
            }
        }
    }
}
