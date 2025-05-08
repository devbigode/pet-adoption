package com.devbigode.petadoption.model;

public enum Sex {
    MALE("Macho"),
    FEMALE("Fêmea");

    private String name;

    Sex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
