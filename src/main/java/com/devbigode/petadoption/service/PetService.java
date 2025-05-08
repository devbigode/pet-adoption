package com.devbigode.petadoption.service;

import com.devbigode.petadoption.model.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Pattern;

import static com.devbigode.petadoption.app.Main.input;

public class PetService {

    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    public static void handleFullName(Pet newPet, String question){
        System.out.println("\n" + question);

        System.out.print("Nome: ");
        System.out.flush();
        String name = input.nextLine();

        System.out.print("Sobrenome: ");
        System.out.flush();
        String lastname = input.nextLine();

        validateFullName(newPet, name, lastname);
    }

    public static void validateFullName(Pet pet, String name, String lastname) {
        Pattern pattern = Pattern.compile("^[\\p{L} ]+$");

        if (name.isBlank() || lastname.isBlank()) {
            throw new IllegalArgumentException("Nome e sobrenome não podem estar vazios.");
        }

        if (!pattern.matcher(name).matches() || !pattern.matcher(lastname).matches()) {
            throw new IllegalArgumentException("Nome e sobrenome devem ter apenas letras.");
        }

        pet.setName(name.trim());
        pet.setLastname(lastname.trim());
    }

    public static void handleType(Pet newPet, String question){
        System.out.println("\n" + question);

        System.out.print("Tipo: ");
        String type = input.nextLine();

        validateType(newPet, type);
    }

    public static void validateType(Pet pet, String type) {
        if (type.isBlank()) {
            throw new IllegalArgumentException("Tipo informado não pode estar vazio.");
        }

        if (!type.equalsIgnoreCase("Cachorro") && !type.equalsIgnoreCase("Gato")) {
            throw new IllegalArgumentException("Tipo informado não bate com opções 'Cachorro' e 'Gato'.");
        }

        if (type.equalsIgnoreCase("Cachorro")) {
            pet.setType(Type.DOG);
        } else {
            pet.setType(Type.CAT);
        }

    }

    public static void handleSex(Pet newPet, String question){
        System.out.println("\n" + question);

        System.out.print("Sexo: ");
        String sex = input.nextLine();

        validateSex(newPet, sex);
    }

    public static void validateSex(Pet pet, String sex) {
        if (sex.isBlank()) {
            throw new IllegalArgumentException("Sexo informado não pode estar vazio.");
        }

        if (!sex.equalsIgnoreCase("Macho") && !sex.equalsIgnoreCase("Femea") && !sex.equalsIgnoreCase("Fêmea")) {
            throw new IllegalArgumentException("Sexo informado não bate com opções 'Macho' e 'Fêmea'.");
        }

        if (sex.equalsIgnoreCase("Macho")) {
            pet.setSex(Sex.MALE);
        } else {
            pet.setSex(Sex.FEMALE);
        }

    }

    public static void handleAddress(Pet newPet, String question){
        System.out.println("\n" + question);

        System.out.print("Número da casa: ");
        System.out.flush();
        String number = input.nextLine();

        System.out.print("Rua: ");
        System.out.flush();
        String street = input.nextLine();

        System.out.print("Cidade: ");
        System.out.flush();
        String city = input.nextLine();

        Address newAddress = new Address();
        validateAddress(newAddress, number, street, city);
        newPet.setAddress(newAddress);
    }

    public static void validateAddress(Address address, String number, String street, String city) {
        Pattern patternText = Pattern.compile("^[\\p{L} ]+$");

        boolean isNumber = Pattern.matches("^[0-9]+$", number);

        if (!patternText.matcher(street).matches()) {
            throw new IllegalArgumentException("Campo 'rua' só pode conter letras.");
        }

        if (!patternText.matcher(city).matches()) {
            throw new IllegalArgumentException("Campo 'cidade' só pode conter letras.");
        }

        if (street.isBlank() || city.isBlank()) {
            throw new IllegalArgumentException("Rua e cidade não devem estar vazias.");
        }

        if (!isNumber) {
            address.setNumber(NAO_INFORMADO);
        } else {
            address.setNumber(number);
        }

        address.setStreet(street);
        address.setCity(city);
    }

    public static void handleAge(Pet newPet, String question){
        System.out.println("\n" + question);

        double age = 0;
        while (age == 0) {
            System.out.print("Idade (em meses): ");
            System.out.flush();
            try {
                age = input.nextDouble();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida! Digite apenas números.");
                input.nextLine();
            }
        }

        validateAge(newPet, age);
    }

    public static void validateAge(Pet pet, double age) {
        double ageInMonths = age / 12;

        if (age < 1) {
            throw new IllegalArgumentException("Pet é muito novo.");
        }

        if (ageInMonths > 20) {
            throw new IllegalArgumentException("Pet é velho demais.");
        }

        pet.setAge(ageInMonths);
    }

    public static void handleWeight(Pet newPet, String question){
        System.out.println("\n" + question);

        double weight = 0;
        while (weight == 0) {
            System.out.print("Peso: ");
            System.out.flush();
            try {
                weight = input.nextDouble();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida! Digite apenas números.");
                input.nextLine();
            }
        }

        validateWeight(newPet, weight);
    }

    public static void validateWeight(Pet pet, double weight) {
        if (weight < 0.5 || weight > 60) {
            throw new IllegalArgumentException("Peso informado está fora do permitido (entre 0,5 a 60 quilos).");
        }

        pet.setWeight(weight);
    }

    public static void handleBreed(Pet newPet, String question){
        System.out.println("\n" + question);

        System.out.print("Raça: ");
        System.out.flush();
        String breed = input.nextLine();

        validateBreed(newPet, breed);
    }

    public static void validateBreed(Pet pet, String breed){
        if (breed.isBlank()){
            throw new IllegalArgumentException("Raça não pode estar vazia.");
        }

        if (!breed.matches("^[\\p{L} ]+$")){
            throw new IllegalArgumentException("Raça apenas deve conter letras.");
        }

        pet.setBreed(breed);
    }

    public static void createPet(List<String> questionsList) {
        if (questionsList == null) {
            throw new NullPointerException("A lista de perguntas é nula ou está vazia.");
        }

        Pet newPet = new Pet();

        for (String question : questionsList) {
            switch (question.trim().substring(0, 1)){
                case "1" -> handleFullName(newPet, question);
                case "2" -> handleType(newPet, question);
                case "3" -> handleSex(newPet, question);
                case "4" -> handleAddress(newPet, question);
                case "5" -> handleAge(newPet, question);
                case "6" -> handleWeight(newPet, question);
                case "7" -> handleBreed(newPet, question);
                default -> System.out.println("Opção desconhecida: " + question);
            }
        }

        System.out.println(newPet);
    }
}
