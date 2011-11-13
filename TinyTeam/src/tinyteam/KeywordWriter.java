package tinyteam;
import java.io.*;

public class KeywordWriter {

    public static String outputFile(String[] wordsInput) throws IOException //Method takes an array of strings and outputs a .txt file with the inputted words inside seperated with commas.
    {
        String textFileOutput = "";
        int loopCount = 0;
        while (loopCount < wordsInput.length) {
            textFileOutput = textFileOutput + "en.wikipedia.org/wiki/" + wordsInput[loopCount] + ",";
            loopCount++;
        }

        return textFileOutput;
    }
}
