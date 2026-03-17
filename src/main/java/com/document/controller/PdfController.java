package com.document.controller;
import org.springframework.web.bind.annotation.*;
import com.document.model.DocumentRequest;
import com.document.model.DocumentResponse;
import com.document.service.PdfService;
@RestController
@RequestMapping("/api/pdf")
public class PdfController {
    private PdfService pdfService = new PdfService();
    @PostMapping("/generate")
    public DocumentResponse generatePdf(@RequestBody DocumentRequest request) {
        try {
            String fileName = request.getFileName() != null ? request.getFileName() : "document.pdf";
            String filePath = "documents/" + fileName;
            pdfService.generatePdf(filePath, request.getTitle() != null ? request.getTitle() : "Document", request.getContent() != null ? request.getContent() : "");
            return new DocumentResponse(true, "PDF generated successfully", filePath, fileName);
        } catch (Exception e) {
            return new DocumentResponse(false, "Error: " + e.getMessage(), "", "");
        }
    }
    @GetMapping("/health")
    public String health() {
        return "PDF service is running";
    }
}