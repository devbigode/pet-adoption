package com.devbigode.petadoption.service;

import java.util.regex.Pattern;

public class PetValidator {
    public static String[] validateFullName(String name, String lastname) {
        Pattern pattern = Pattern.compile("^[\\p{L} ]+$");

        if (name.isBlank() || lastname.isBlank()) {
            throw new IllegalArgumentException("Nome e sobrenome não podem estar vazios.");
        }

        if (!pattern.matcher(name).matches() || !pattern.matcher(lastname).matches()) {
            throw new IllegalArgumentException("Nome e sobrenome devem ter apenas letras.");
        }

        return new String[]{name, lastname};
    }

    public static String validateType(String type) {
        if (type.isBlank()) {
            throw new IllegalArgumentException("Tipo informado não pode estar vazio.");
        }

        if (!type.equalsIgnoreCase("Cachorro") && !type.equalsIgnoreCase("Gato")) {
            throw new IllegalArgumentException("Tipo informado não bate com opções 'Cachorro' e 'Gato'.");
        }

        return type;
    }

    public static String validateSex(String sex) {
        if (sex.isBlank()) {
            throw new IllegalArgumentException("Sexo informado não pode estar vazio.");
        }

        if (!sex.equalsIgnoreCase("Macho") && !sex.equalsIgnoreCase("Femea") && !sex.equalsIgnoreCase("Fêmea")) {
            throw new IllegalArgumentException("Sexo informado não bate com opções 'Macho' e 'Fêmea'.");
        }

        return sex;
    }

    public static String[] validateAddress(String number, String street, String city) {
        Pattern patternText = Pattern.compile("^[\\p{L} ]+$");

        boolean isNumber = Pattern.matches("^[0-9]+$", number);

        if (street.isBlank() || city.isBlank()) {
            throw new IllegalArgumentException("Rua e cidade não devem estar vazias.");
        }

        if (!patternText.matcher(street).matches()) {
            throw new IllegalArgumentException("Campo 'rua' só pode conter letras.");
        }

        if (!patternText.matcher(city).matches()) {
            throw new IllegalArgumentException("Campo 'cidade' só pode conter letras.");
        }

        if (!isNumber) {
            return new String[]{PetService.NAO_INFORMADO, street, city};
        }

        return new String[]{number, street, city};
    }

    public static double validateAge(double age) {
        double ageInMonths = age / 12;

        if (age < 1) {
            throw new IllegalArgumentException("Pet é muito novo.");
        }

        if (ageInMonths > 20) {
            throw new IllegalArgumentException("Pet é velho demais.");
        }

        return ageInMonths;
    }

    public static double validateWeight(double weight) {
        if (weight < 0.5 || weight > 60) {
            throw new IllegalArgumentException("Peso informado está fora do permitido (entre 0,5 a 60 quilos).");
        }

        return weight;
    }

    public static String validateBreed(String breed) {
        if (breed.isBlank()) {
            throw new IllegalArgumentException("Raça não pode estar vazia.");
        }

        if (!breed.trim().matches("^(\\p{L})+([- ])?(\\p{L})+$")) {
            throw new IllegalArgumentException("Não use caracteres especiais no campo raça.");
        }

        return breed;
    }

    public static String[] validateChoiceSearch(String choice) {
        if (choice.isBlank()) {
            throw new IllegalArgumentException("Critério não pode estar vazio.");
        }

        if (!(choice.matches("[1-6]") | choice.matches("[1-6] [eE] [1-6]"))) {
            throw new IllegalArgumentException("Número fora do limite (1 a 6) ou formato de busca inválido. Exemplos aceitos: 4 | 3 e 6");
        }

        if (choice.length() == 5) {
            String attrOne = choice.substring(0, 1);
            String attrTwo = choice.substring(4, 5);

            if (attrOne.equals(attrTwo)) {
                throw new IllegalArgumentException("Selecione critérios distintos.");
            }

            return new String[]{attrOne, attrTwo};
        }

        if (choice.length() == 1) return new String[]{choice};

        return null;
    }
}
