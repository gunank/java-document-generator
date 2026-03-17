package com.document.service;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

public class ExcelService {
    public void generateExcel(String filePath, String sheetName, String[] headers, List<Map<String, Object>> data) throws Exception {
        System.out.println("Generating Excel file: " + filePath);
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            StringBuilder sb = new StringBuilder();
            for (String header : headers) sb.append(header).append(",");
            sb.append("\n");
            for (Map<String, Object> row : data) {
                for (String header : headers) {
                    Object value = row.get(header);
                    sb.append(value != null ? value : "").append(",");
                }
                sb.append("\n");
            }
            fos.write(sb.toString().getBytes());
        }
    }
}