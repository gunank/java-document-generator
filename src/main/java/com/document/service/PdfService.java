package com.document.service;

import java.io.FileOutputStream;

public class PdfService {
    public void generatePdf(String filePath, String title, String content) throws Exception {
        System.out.println("Generating PDF: " + title);
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(("PDF: " + title + "\n" + content).getBytes());
        }
    }

    public void generatePdfWithTable(String filePath, String title, String[] headers, String[][] data) throws Exception {
        System.out.println("Generating PDF with table: " + title);
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            StringBuilder sb = new StringBuilder();
            sb.append("PDF: ").append(title).append("\n");
            for (String header : headers)
                sb.append(header).append("\t");
            sb.append("\n");
            for (String[] row : data) {
                for (String cell : row)
                    sb.append(cell).append("\t");
                sb.append("\n");
            }
            fos.write(sb.toString().getBytes());
        }
    }
}