package com.document.controller;
import org.springframework.web.bind.annotation.*;
import com.document.model.DocumentRequest;
import com.document.model.DocumentResponse;
import com.document.service.CsvService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/csv")
public class CsvController {
    private CsvService csvService = new CsvService();
    @PostMapping("/generate")
    public DocumentResponse generateCsv(@RequestBody DocumentRequest request) {
        try {
            String fileName = request.getFileName() != null ? request.getFileName() : "document.csv";
            String filePath = "documents/" + fileName;
            String[] headers = request.getHeaders() != null ? request.getHeaders().toArray(new String[0]) : new String[]{"Column1"};
            List<String[]> csvData = new ArrayList<>();
            if (request.getData() != null) {
                for (Map<String, Object> row : request.getData()) {
                    String[] csvRow = new String[headers.length];
                    for (int i = 0; i < headers.length; i++) {
                        Object value = row.get(headers[i]);
                        csvRow[i] = value != null ? value.toString() : "";
                    }
                    csvData.add(csvRow);
                }
            }
            csvService.generateCsv(filePath, headers, csvData);
            return new DocumentResponse(true, "CSV file generated successfully", filePath, fileName);
        } catch (Exception e) {
            return new DocumentResponse(false, "Error: " + e.getMessage(), "", "");
        }
    }
    @GetMapping("/health")
    public String health() {
        return "CSV service is running";
    }
}