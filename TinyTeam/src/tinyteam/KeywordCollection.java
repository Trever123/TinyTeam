/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tinyteam;

/**
 *
 * @author
 */
import java.io.*;

public class KeywordCollection {

    public static String KeywordCol(String filename) throws FileNotFoundException, IOException {

        NewWordMetrics wordMetrics;
        String[] keywords;
        PDFTextParser fileReader;

        wordMetrics = new NewWordMetrics();

        fileReader = new PDFTextParser();

        String[] temp = fileReader.getAllText(filename);
        for (int i = 0; i < temp.length; i++) {
            wordMetrics.Words().add(temp[i]);
        }


        keywords = wordMetrics.RunAnalysis();

        System.out.println(keywords.length);

        return KeywordWriter.outputFile(keywords);
    }
}
