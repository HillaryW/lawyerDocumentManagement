package Application;

import Database.DBFunctions;
import Docx.DocxParser;
import Pdf.PdfParser;
import StringMaper.StringMapper;

import java.awt.*;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by centhian on 3/4/17.
 */
public class BackEndDriver {
    static StringMapper mapper = new StringMapper();
    static DBFunctions dbFunctions = new DBFunctions();
    static PdfParser pdfParser = new PdfParser();
    static DocxParser docxParser = new DocxParser();

    public static void uploadDocument(String filePath) {
        String text = "";
        String[] filePathArray = filePath.split("/");
        String fileName = filePathArray[filePathArray.length-1];
        HashMap<String, Integer> parsedFileMap;
        if (filePath.endsWith("docx")){
            text = docxParser.getTextString(filePath);
        } else if (filePath.endsWith("pdf")){
            text = pdfParser.getTextString(filePath);
        }
        parsedFileMap = mapper.processString(text);
        dbFunctions.insertKeywordData(fileName,parsedFileMap);
    }

    public static HashMap<String, Integer> searchDocuments(String keyword){
        return dbFunctions.getFileNamesContainingKeyword(keyword);
    }

    public static ArrayList<String> getResults(HashMap<String, Integer> results){
        ArrayList<String> fileNames = new ArrayList<>();
        int i = 0;
        for (String fileName : results.keySet()) {
            fileNames.add(fileName);
            i++;
        }
        return fileNames;
    }

}
