package tinyteam;

import java.util.*;

public class NewWordMetrics {

    //used to access the list of common words
    private ReadCommon readCommon;
    //stores the keywords to be returned (after converting to array)
    private Vector<String> keywords;
    //total number of words
    private int wordCount;
    //stores all words in order
    private Vector<String> words;
    //stores all pairs of words in order
    private Vector<WordPair> wordPairs;
    //the frequency of each word
    private HashMap<String, Integer> wordFrequencies;
    //stores the frequencies of word pairs
    private HashMap<WordPair, Integer> pairFrequencies;

    public NewWordMetrics() throws java.io.FileNotFoundException {
        //instantiates everything
        readCommon = new ReadCommon();
        keywords = new Vector<String>();
        wordCount = 0;

        words = new Vector<String>(500);
    }

    //alows external access to the list of words
    public Vector<String> Words() {
        return words;
    }

    //determines and returns keywords
    public String[] RunAnalysis() {
        AllToLower();
        //calculations
        CountWords();
        CountPairs();

        for (int i = 50; keywords.size() <= 10; --i) {
            for (String key : wordFrequencies.keySet()) {
                if (!readCommon.commonWordCheck(key.toString()) && key.length() > 3 && wordFrequencies.get(key).intValue() == i) {
                    System.out.println("Adding " + key + " to keywords");
                    keywords.add(key);
                }
            }
        }

        String[] result = new String[keywords.size()];
        for (int i = 0; i < keywords.size(); i++) {
            result[i] = keywords.get(i);
        }

        return result;

    }

    //makes sure all words are in lower case
    private void AllToLower() {
        for (int i = 0; i < words.size(); i++) {
            words.set(i, words.get(i).toLowerCase());
        }
    }
    //count words (total and frequencies)

    private void CountWords() {
        wordFrequencies = new HashMap<String, Integer>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.elementAt(i);
            wordCount++;
            if (wordFrequencies.containsKey(word)) {
                wordFrequencies.put(word, wordFrequencies.get(word) + 1);
                System.out.println(wordFrequencies.get(word).intValue());
            } else {
                wordFrequencies.put(word, 1);
            }
        }
    }

    private void CountPairs() {
        wordPairs = new Vector<WordPair>();
        pairFrequencies = new HashMap<WordPair, Integer>();
        for (int i = 0; i < (words.size() - 1); i++) {
            WordPair pair = new WordPair(words.get(i), words.get(i + 1));
            wordPairs.add(pair);
            if (pairFrequencies.containsKey(pair)) {
                pairFrequencies.put(pair, wordFrequencies.get(pair) + 1);
            } else {
                pairFrequencies.put(pair, 1);
            }
        }
    }
}
