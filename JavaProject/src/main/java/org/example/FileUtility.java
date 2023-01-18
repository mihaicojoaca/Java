package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtility {
    private static final String PATH_TO_FILE = "scr/main/resources/fisier.txt";

    public static void writeToFile() {
        File file = new File(PATH_TO_FILE);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        Person person1 = new Person("Bill", 25, false, Arrays.asList(4, 5, 6));
        Person person2 = new Person("Jack", 34, false, Arrays.asList(2, 6, 3));
        ArrayList<Person> objects = new ArrayList<>();
        objects.add(person2);
        objects.add(person1);
        try {
            writer.writeValue(file, objects);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static List<Person> readFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        Path path = Paths.get(PATH_TO_FILE);
        byte[] bytes = new byte[0];

        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = new String(bytes);


        //List<Person> persons = mapper.readValue(json, new TypeReference<List<Person>>() {});
        ArrayList<Person> persons = new ArrayList<>();
        Person person1 = new Person("Bill", 25, false, Arrays.asList(4, 5, 6));
        Person person2 = new Person("Jack", 34, false, Arrays.asList(2, 6, 3));
        persons.add(person2);
        persons.add(person1);
        return persons;
    }
}
