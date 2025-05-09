package com.devbigode.petadoption.util;

import com.devbigode.petadoption.model.Pet;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
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

    public static Path createPath(Pet createdPet){
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        String pathName = year + "" + month + "" + day + "T"
                + hour + "" + minute + "-"
                + createdPet.getName().toUpperCase()
                + createdPet.getLastname().toUpperCase()
                + ".txt";
        try {
            return Files.createFile(Paths.get("petsCadastrados//" + pathName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeToFile(Pet createdPet, OutputStream outputStream){
        PrintWriter pr = new PrintWriter(outputStream);

        pr.println("1 - " + createdPet.getName() + " " + createdPet.getLastname());
        pr.println("2 - " + createdPet.getType().getName());
        pr.println("3 - " + createdPet.getSex().getName());
        pr.println("4 - " + createdPet.getAddress().getStreet() + ", "
                + createdPet.getAddress().getNumber() + ", "
                + createdPet.getAddress().getCity());
        pr.printf("5 - %.1f anos%n", createdPet.getAge());
        pr.printf("6 - %.2fkg%n", createdPet.getWeight());
        pr.println("7 - " + createdPet.getBreed());

        pr.close();
    }

    public static void petToFile(Pet createdPet){
        if (createdPet == null){
            throw new IllegalArgumentException("Pet informado não existe.");
        }

        Path pathName = createPath(createdPet);

        if (pathName == null){
            throw new RuntimeException("Falha ao criar nome do arquivo.");
        }

        try (OutputStream outputStream = Files.newOutputStream(pathName)){
            writeToFile(createdPet, outputStream);
            System.out.printf("%nTransferência dos dados realizada com êxito! %s ➡️ %s%n", createdPet.getName(), pathName);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
