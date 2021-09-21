package com.volvo.javatest.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CsvService {

    public File readInputFile(String inputFileName) {
        ClassLoader classLoader = CsvService.class.getClassLoader();
        File inputFile = new File(classLoader.getResource(inputFileName).getFile());
        return inputFile;
    }

    public String createCsv(File inputFile) {
        StringBuffer output = new StringBuffer();
            try {
                Scanner reader = new Scanner(inputFile);
                while(reader.hasNextLine()){
                    String line = reader.nextLine();
                    String[] words =line.split(" ");
                    for (String text: words){
                        if(Character.isUpperCase(text.charAt(0))){
                            output.append(text).append(",");
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return output.toString();
    }

    public void writeFile(String output, String filename) {
        ClassLoader classLoader = CsvService.class.getClassLoader();
        FileWriter writer;
        try {
            writer = new FileWriter(classLoader.getResource(filename).getPath());
            writer.write(output);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
