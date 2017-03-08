package Docx;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 * Created by centhian on 3/5/17.
 */
public class DocxParser {

    public String getTextString(String filePath) {
        StringBuilder builder = new StringBuilder();

        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document.getParagraphs();

            for (XWPFParagraph para : paragraphs) {
                int i = 0;
                builder.append(para.getRuns().get(i));
                i++;
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
