/*
 * PDFTextParser.java
 *
 * Created on January 24, 2009, 11:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author prasanna, Robert 
 *
 */
package tinyteam;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.util.StringTokenizer;

public class PDFTextParser {

    PDFParser parser;
    String parsedText;
    PDFTextStripper pdfStripper;
    PDDocument pdDoc;
    COSDocument cosDoc;
    PDDocumentInformation pdDocInfo;

    // PDFTextParser Constructor
    public PDFTextParser() {
    }

    // Extract text from PDF Document
    String pdftoText(String fileName) {

        System.out.println("Parsing text from PDF file " + fileName + "....");
        File f = new File(fileName);

        if (!f.isFile()) {
            System.out.println("File " + fileName + " does not exist.");
            return null;
        }

        try {
            parser = new PDFParser(new FileInputStream(f));
        } catch (Exception e) {
            System.out.println("Unable to open PDF Parser.");
            return null;
        }

        try {
            parser.parse();
            cosDoc = parser.getDocument();
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            parsedText = pdfStripper.getText(pdDoc);
        } catch (Exception e) {
            System.out.println("An exception occured in parsing the PDF Document.");
            e.printStackTrace();
            try {
                   if (cosDoc != null) cosDoc.close();
                   if (pdDoc != null) pdDoc.close();
               } catch (Exception e1) {
               e.printStackTrace();
            }
            return null;
        }
        System.out.println("Done.");
        return parsedText;
    }
    
    //Extracts text from a PDF Document and writes it to a text file
    public String[] getAllText(String pathname) {

        PDFTextParser pdfTextParserObj = new PDFTextParser();
        String tempStr = pdfTextParserObj.pdftoText(pathname);

        StringTokenizer tokenizer = new StringTokenizer(tempStr,
                                        " _\t\n\r\f.,\"()[]{}-\\/:;!?");
        int tokenCount = tokenizer.countTokens();
        String[] arr = new String[tokenCount];
        for (int i = 0; i < tokenCount; ++i){
            arr[i] = tokenizer.nextToken();
        }

        return arr;
       //System.out.println("\nThe text parsed from the PDF Document....\n" + pdfToText);
       //pdfTextParserObj.writeTexttoFile(pdfToText,"");
    }
}