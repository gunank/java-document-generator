package com.document.service;

import java.io.FileWriter;
import java.util.List;

public class CsvService {
    public void generateCsv(String filePath, String[] headers, List<String[]> data) throws Exception {
        System.out.println("Generating CSV file: " + filePath);
        try (FileWriter fw = new FileWriter(filePath)) {
            for (String header : headers) fw.write(header + ",");
            fw.write("\n");
            for (String[] row : data) {
                for (String cell : row) fw.write(cell + ",");
                fw.write("\n");
            }
        }
    }
}