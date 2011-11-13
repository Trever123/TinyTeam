package tinyteam;

public class WordPair{
	
	public String word1;
	public String word2;
	
	public WordPair(String word1, String word2){
		this.word1 = word1;
		this.word2 = word2;
	}
	
	public boolean Compare(WordPair pair){
		return ((this.word1.equals(pair.word1)) && (this.word2.equals(pair.word2)));
	}
	
}