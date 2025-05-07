package com.devbigode.petadoption.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

    public static void readFile(){
        try {
            List<String> questionsList = Files.readAllLines(Paths.get("formulario.txt"));
            questionsList.removeIf(String::isBlank);
            questionsList.forEach(System.out::println);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
