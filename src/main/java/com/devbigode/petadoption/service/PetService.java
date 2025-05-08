package com.devbigode.petadoption.service;

import com.devbigode.petadoption.model.*;
import java.util.List;
import java.util.regex.Pattern;
import static com.devbigode.petadoption.app.Main.input;

public class PetService {

    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    public static void validateFullName(Pet pet, String name, String lastname) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+$");

        if (name.isBlank() || lastname.isBlank()){
            throw new IllegalArgumentException("Nome e sobrenome não podem estar vazios.");
        }

        if (!pattern.matcher(name).matches() || !pattern.matcher(lastname).matches()) {
            throw new IllegalArgumentException("Nome e sobrenome devem ter apenas letras.");
        }

        pet.setName(name);
        pet.setLastname(lastname);
    }

    public static void validateType(Pet pet, String type){
        if (type.isBlank()){
            throw new IllegalArgumentException("Tipo informado não pode estar vazio.");
        }

        if (!type.equalsIgnoreCase("Cachorro") && !type.equalsIgnoreCase("Gato")){
            throw new IllegalArgumentException("Tipo informado não bate com opções 'Cachorro' e 'Gato'.");
        }

        if (type.equalsIgnoreCase("Cachorro")){
            pet.setType(Type.DOG);
        } else {
            pet.setType(Type.CAT);
        }

    }

    public static void validateSex(Pet pet, String sex){
        if (sex.isBlank()){
            throw new IllegalArgumentException("Sexo informado não pode estar vazio.");
        }

        if (!sex.equalsIgnoreCase("Macho") && !sex.equalsIgnoreCase("Femea") && !sex.equalsIgnoreCase("Fêmea")){
            throw new IllegalArgumentException("Sexo informado não bate com opções 'Macho' e 'Fêmea'.");
        }

        if (sex.equalsIgnoreCase("Macho")){
            pet.setSex(Sex.MALE);
        } else {
            pet.setSex(Sex.FEMALE);
        }

    }

    public static void validateAddress(Address address, String number, String street, String city){
        Pattern patternText = Pattern.compile("[a-zA-Z\\- ]+$");

        boolean isNumber = Pattern.matches("[0-9]+$", number);

        if (!patternText.matcher(street).matches()){
            throw new IllegalArgumentException("Campo 'rua' só pode conter letras.");
        }

        if (!patternText.matcher(city).matches()){
            throw new IllegalArgumentException("Campo 'cidade' só pode conter letras.");
        }

        if (street.isBlank() || city.isBlank()){
            throw new IllegalArgumentException("Rua e cidade não devem estar vazias.");
        }

        if (!isNumber){
            address.setNumber(NAO_INFORMADO);
        } else {
            address.setNumber(number);
        }

        address.setStreet(street);
        address.setCity(city);
    }

    public static void createPet(List<String> questionsList) {
        Pet newPet = new Pet();

        if (questionsList == null){
            throw new RuntimeException("A lista de perguntas é nula ou está vazia.");
        }

        for (String question : questionsList) {
            if (question.startsWith("1")){
                System.out.println("\n" + question);

                System.out.print("Nome: ");
                System.out.flush();
                String name = input.nextLine();

                System.out.print("Sobrenome: ");
                System.out.flush();
                String lastname = input.nextLine();

                validateFullName(newPet, name, lastname);
                continue;
            }

            if (question.startsWith("2")){
                System.out.println("\n" + question);

                System.out.print("Tipo: ");
                String type = input.nextLine();

                validateType(newPet, type);
                continue;
            }

            if (question.startsWith("3")){
                System.out.println("\n" + question);

                System.out.print("Sexo: ");
                String sex = input.nextLine();

                validateSex(newPet, sex);
                continue;
            }

            if (question.startsWith("4")){
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
                continue;
            }

            if (question.startsWith("7")){
                System.out.println("Chegamos ao fim.");
                System.out.println(newPet);
            }
        }

    }
}
