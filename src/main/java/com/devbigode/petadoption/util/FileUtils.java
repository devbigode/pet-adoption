package com.devbigode.petadoption.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

    public static List<String> readQuestions(){
        try {
            List<String> questionsList = Files.readAllLines(Paths.get("formulario.txt"));
            questionsList.removeIf(String::isBlank);

            if (!questionsList.isEmpty()){
                return questionsList;
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
}
