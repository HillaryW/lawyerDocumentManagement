package Pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * Created by centhian on 3/4/17.
 */
public class PdfParser {

    private String getText(File pdfFile) throws IOException {
        PDDocument doc = PDDocument.load(pdfFile);
        return new PDFTextStripper().getText(doc);
    }

    public String getTextString(String filePath) {
        String text;
        try {
            text = getText(new File(filePath));
        } catch (IOException e) {
            text = "Error parsing PDF file: " + e.getMessage();
            e.printStackTrace();
        }
        return text;
    }



}
