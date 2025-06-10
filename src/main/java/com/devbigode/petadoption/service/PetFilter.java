package com.devbigode.petadoption.service;

import com.devbigode.petadoption.model.Pet;

import java.text.Normalizer;
import java.util.List;

public class PetFilter {
    public static String normalize(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();
    }

    public static List<Pet> filterByFullName(String type, String name, String lastname) {
        String inputName = PetFilter.normalize(name);
        String inputLastname = PetFilter.normalize(lastname);

        return PetService.petList.stream()
                .filter(pet -> pet.getType().getName().equalsIgnoreCase(type) &&
                        (normalize(pet.getName()).contains(inputName) ||
                                normalize(pet.getLastname()).contains(inputLastname))).toList();
    }

    public static List<Pet> filterBySex(String type, String sex) {
        String inputSex = normalize(sex);

        return PetService.petList.stream()
                .filter(pet -> pet.getType().getName().equalsIgnoreCase(type) &&
                        normalize(pet.getSex().getName()).equalsIgnoreCase(inputSex)).toList();
    }

    public static List<Pet> filterByAge(String type, double age) {
        return PetService.petList.stream()
                .filter(pet -> pet.getType().getName().equalsIgnoreCase(type) &&
                        pet.getAge() == age).toList();
    }

    public static List<Pet> filterByWeight(String type, double weight) {
        return PetService.petList.stream()
                .filter(pet -> pet.getType().getName().equalsIgnoreCase(type) &&
                        pet.getWeight() == weight).toList();
    }

    public static List<Pet> filterByBreed(String type, String breed) {
        String inputBreed = normalize(breed);

        return PetService.petList.stream()
                .filter(pet -> pet.getType().getName().equalsIgnoreCase(type) &&
                        normalize(pet.getBreed()).contains(inputBreed)).toList();
    }

    public static List<Pet> filterByAddress(String type, String number, String street, String city) {
        String inputStreet = normalize(street);
        String inputCity = normalize(city);

        return PetService.petList.stream()
                .filter(pet -> pet.getType().getName().equalsIgnoreCase(type) &&
                        (normalize(pet.getAddress().getNumber()).equals(number) ||
                                normalize(pet.getAddress().getStreet()).contains(inputStreet) ||
                                normalize(pet.getAddress().getCity()).contains(inputCity))).toList();
    }
}
