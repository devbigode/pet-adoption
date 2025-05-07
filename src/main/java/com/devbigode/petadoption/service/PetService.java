package com.devbigode.petadoption.service;

import com.devbigode.petadoption.model.Pet;
import java.util.regex.Pattern;
import static com.devbigode.petadoption.app.Main.input;

public class PetService {

    public static void validateFullName(Pet pet) {
        System.out.print("Digite o nome: ");
        System.out.flush();
        String name = input.nextLine();

        System.out.print("Digite o sobrenome: ");
        System.out.flush();
        String lastname = input.nextLine();

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

    public static void createPet() {
        Pet newPet = new Pet();

        validateFullName(newPet);
    }
}
