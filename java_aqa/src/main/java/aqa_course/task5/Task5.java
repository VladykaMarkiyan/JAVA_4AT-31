package aqa_course.task5;

// The general task for all:
// 1
//Serialization-Deserialization:
//a) Make some complex models using your variant.
//b) Make it serializable.
//c) Read JSON from “input.json”
//d) and deserialize it to POJO.
//e) Then change a few fields and save it to “output.json”.
//f) Do the same for XML.

// 2
// Stream:
//a) Generate 10 random objects using a class from a previous task
//b) Sort it using any two fields using stream.
//c) Filter it by any two fields custom filter.
//d) Collect it to List with *main field(s).

//3
// Write a maven command for executing one of your tasks with arguments (number of elements).


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.Scanner;

public class Task5 {

    private static final String INPUT_FILE_JSON_PATH = "C:\\Users\\marki\\java_at\\java_aqa\\src\\main\\resources\\input.json";
    private static final String OUTPUT_FILE_JSON_PATH = "C:\\Users\\marki\\java_at\\java_aqa\\src\\main\\resources\\output.json";
    private static final String INPUT_XML = "C:\\Users\\marki\\java_at\\java_aqa\\src\\main\\resources\\input.xml";
    private static final String OUTPUT_XML = "C:\\Users\\marki\\java_at\\java_aqa\\src\\main\\resources\\output.xml";

    public static void main(String[] args) {

        String inputJson = "";

        try {
            File file = new File("C:\\Users\\marki\\java_at\\java_aqa\\src\\main\\resources\\input.json").getAbsoluteFile();
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                inputJson += line;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        User user = null;

        try {
            user = objectMapper.readValue(inputJson, User.class);
            System.out.println("User: " + user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        
        try {
            user = objectMapper.readValue(new File(INPUT_FILE_JSON_PATH), User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        user.setName("testname");
        user.getHobbies().add("testhobbie");
        user.getHobbies().remove("hiking");



        XmlMapper xmlMapper = new XmlMapper();
        User userXml = null;
        try {
            userXml = xmlMapper.readValue(new File(INPUT_XML), User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        userXml.setName("TestName_XML");
        userXml.getHobbies().add("TestHobby_XML");
        userXml.getHobbies().remove("hiking");

        try {
            xmlMapper.writeValue(new File(OUTPUT_XML), userXml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("XML serialized and saved to " + OUTPUT_XML);
        System.out.println(userXml);


        try {
            objectMapper.writeValue(new File(OUTPUT_FILE_JSON_PATH), user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
