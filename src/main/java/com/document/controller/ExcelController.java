package com.document.controller;

import org.springframework.web.bind.annotation.*;
import com.document.model.DocumentRequest;
import com.document.model.DocumentResponse;
import com.document.service.ExcelService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    private ExcelService excelService = new ExcelService();

    @PostMapping("/generate")
    public DocumentResponse generateExcel(@RequestBody DocumentRequest request) {
        try {
            String fileName = request.getFileName() != null ? request.getFileName() : "document.xlsx";
            String filePath = "documents/" + fileName;
            String sheetName = request.getSheetName() != null ? request.getSheetName() : "Sheet1";
            String[] headers = request.getHeaders() != null ? request.getHeaders().toArray(new String[0]) : new String[]{"Column1"};
            List<Map<String, Object>> data = request.getData() != null ? request.getData() : new ArrayList<>();
            excelService.generateExcel(filePath, sheetName, headers, data);
            return new DocumentResponse(true, "Excel file generated successfully", filePath, fileName);
        } catch (Exception e) {
            return new DocumentResponse(false, "Error: " + e.getMessage(), "", "");
        }
    }

    @GetMapping("/health")
    public String health() {
        return "Excel service is running";
    }
}