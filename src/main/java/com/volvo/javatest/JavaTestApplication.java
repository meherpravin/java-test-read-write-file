package com.volvo.javatest;

import com.volvo.javatest.util.CsvService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class JavaTestApplication {

    public static void main(String[] args) {

        CsvService csvService = new CsvService();

        String inputFileName = "test.txt";
        String outputFileName = "output.csv";

        //Read input
        File inputFile = csvService.readInputFile(inputFileName);

        //process
        String output = csvService.createCsv(inputFile);

        //Output
        csvService.writeFile(output, outputFileName);

    }

}
