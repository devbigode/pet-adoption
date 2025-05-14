package com.devbigode.petadoption.ui;

import com.devbigode.petadoption.model.Pet;

import java.util.InputMismatchException;

import static com.devbigode.petadoption.app.Main.input;

public class PetConsoleUI {

    public static void printPet(Pet pet) {
        System.out.printf("%s %s - %s - %s - %s, %s - %s - %.1f anos - %.2fkg - %s%n",
                pet.getName(), pet.getLastname(),
                pet.getType().getName(),
                pet.getSex().getName(),
                pet.getAddress().getStreet(), pet.getAddress().getNumber(), pet.getAddress().getCity(),
                pet.getAge(),
                pet.getWeight(),
                pet.getBreed());
    }

    public static String pickCriteria(){
        System.out.println("\nEscolha de 1 a 2 critérios de busca (ex: 4 | 3 e 6):");
        System.out.println("""
                
                1. Nome ou sobrenome
                2. Sexo
                3. Idade
                4. Peso
                5. Raça
                6. Endereço              
                """);

        System.out.print("R: ");
        System.out.flush();
        String chosenAttr = input.nextLine();

        return chosenAttr.trim();
    }

    public static String[] askFullName() {
        System.out.print("Nome: ");
        System.out.flush();
        String name = input.nextLine();

        System.out.print("Sobrenome: ");
        System.out.flush();
        String lastname = input.nextLine();

        return new String[]{name.trim(), lastname.trim()};
    }

    public static String askType() {
        System.out.print("Tipo: ");
        String type = input.nextLine();

        return type.trim();
    }

    public static String askSex() {
        System.out.print("Sexo: ");
        String sex = input.nextLine();

        return sex.trim();
    }

    public static String[] askAddress() {
        System.out.print("Número da casa: ");
        System.out.flush();
        String number = input.nextLine();

        System.out.print("Rua: ");
        System.out.flush();
        String street = input.nextLine();

        System.out.print("Cidade: ");
        System.out.flush();
        String city = input.nextLine();

        return new String[]{number.trim(), street.trim(), city.trim()};
    }

    public static double askAge() {
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

        return age;
    }

    public static double askWeight() {
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

        return weight;
    }

    public static String askBreed() {
        System.out.print("Raça: ");
        System.out.flush();
        String breed = input.nextLine();

        return breed.trim();
    }
}
