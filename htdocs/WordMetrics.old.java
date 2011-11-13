/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tinyteam;

/**
 *
 * @author
 */
import java.util.*;

public class WordMetrics {

    private Vector<String> allWords;
    private int wordCount;
    private HashMap<String, Integer> wordFrequencies;
    private ReadCommon readCommon;
    private Vector<String> keywords;

    public WordMetrics() throws java.io.FileNotFoundException {
        allWords = new Vector<String>(500);
        wordCount = 0;
        wordFrequencies = new HashMap<String, Integer>(100);
        readCommon = new ReadCommon();
    }

    public Vector<String> AllWords() {
        return allWords;
    }

    public String[] RunAnalysis() {
        CountWords();
        keywords = new Vector<String>();
        for (String key : wordFrequencies.keySet()) {
            if (!readCommon.commonWordCheck(key)) {
                keywords.add(key);
            }
        }
        //System.out.println(keywords.size());

        String[] result = new String[keywords.size()];
        for (int i = 0; i < keywords.size(); i++) {
            result[i] = keywords.get(i);
        }
        return result;
    }

    //count words
    private void CountWords() {
        for (int i = 0; i < allWords.size(); i++) {
            String word = allWords.elementAt(i);
            if (word != ".") {
                wordCount++;
                if (wordFrequencies.containsKey(word)) {
                    wordFrequencies.put(word, wordFrequencies.get(word) + 1);
                } else {
                    wordFrequencies.put(word, 1);
                }
            }
        }
    }
}