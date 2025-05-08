package com.devbigode.petadoption.model;

public enum Type {
    CAT("Gato"),
    DOG("Cachorro");

    private String name;

    Type(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
