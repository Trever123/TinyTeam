package tinyteam;

/* Class FolderHandler
 *
 * Processes a list of folder names (passed as a string) by sending
 *  each file (except the file titled "GO") to the PDFParser. When
 *  completed, it outputs a file ("DONE") to the same directory.
 *
*/

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FolderHandler
{

	private ArrayList<String> folderPaths;
	private String[] outputStrings;
	private PDFTextParser parser;
	private final String uploadsPath = "/home/tinymap/public_html/uploads/";
	private final String processedPath = "/home/tinymap/public_html/processed/";

	public FolderHandler()
	{
		parser = new PDFTextParser();
	}

	public void checkPaths() throws FileNotFoundException, IOException
	{
		 folderPaths = FileList.dirList(uploadsPath);
		
                
		
			for (String path : folderPaths)
			{
				parseFolder(path);
			}
		
	}

	private void parseFolder(String folderPath) throws FileNotFoundException, IOException
	{

		File directory = new File(folderPath);
		File[] pdfs = directory.listFiles();
		int i = 0;
		String finalString = "";
		outputStrings = new String[pdfs.length];
		for (File pdf : pdfs)
		{
			if (pdf.getName().compareToIgnoreCase("GO") != 0)
			{
				outputStrings[i++] = KeywordCollection.KeywordCol(pdf.getPath());
			}
		}
		for (String str : outputStrings)
		{
			finalString += str;
		}
		writeDone(folderPath, finalString);

	}

	private void writeDone(String folderPath, String output)
	{
        FileWriter writer = null;
        try {
            File fold = new File(folderPath);
            String outName = processedPath + File.separator + fold.getName();
            writer = new FileWriter(outName);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(output);
            out.close();
            writer.close();
            writer = new FileWriter(uploadsPath + File.separator + fold.getName() + File.separator + "DONE");
            out = new BufferedWriter(writer);
            out.write("");
            writer.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(FolderHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(FolderHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	}


}
