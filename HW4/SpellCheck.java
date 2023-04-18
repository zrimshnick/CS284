import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;


// Zachary Rimshnick
// I pledge my honor that I have abided by the Stevens Honor System.

public class SpellCheck {
	
	int numberOfCollisions;
	
    int getNumberOfCollisions() {
        return numberOfCollisions;
    }
	
	public static ArrayList<String> checkQuery(ArrayList<String> wordList) {
			////////////////QUERY WORDS //////////////////
		QuadraticProbing qHashTable0 = new QuadraticProbing();
			try {
				File myObj0 = new File("src/wordsEn.txt"); // please use your own file path
				Scanner myReader0 = new Scanner(myObj0);
				while (myReader0.hasNextLine()) {
					String data0 = myReader0.nextLine();
					qHashTable0.insert(data0);
				}
				myReader0.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			ArrayList <String> allWords = new ArrayList<String>();
			System.out.println("QUERY WORDS: ");
			for (String str0: wordList) {
				if (qHashTable0.contains(str0)) {
					allWords.add(str0);
					System.out.println(str0 + " - Found - " + qHashTable0.findProbing(str0) + " probes used");
				} if (!qHashTable0.contains(str0)) {
					allWords.add(str0);
					System.out.println(str0 + " - Not Found - " + qHashTable0.getNumCollisions()  + " probes used");
				}
			} 
			return allWords;

	}
	
	public static ArrayList<String> checkSpelling(ArrayList<String> wordList) {
		
		//////////////// BIGGER DOCUMENT //////////////
		
		QuadraticProbing qHashTable = new QuadraticProbing();
		try {
            File myObj = new File("src/wordsEn.txt"); // please use your own file path
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                qHashTable.insert(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
		ArrayList <String> wrongWords = new ArrayList<String>();
		System.out.println("\nIncorrectly spelled words: ");
		for (String str: wordList) {
			if (!qHashTable.contains(str)) {
					wrongWords.add(str);
					System.out.println(str);
			} 
		} 
		//System.out.println(wrongWords);
		System.out.println("\nHere are some suggestions: ");
		/// Check case 1- adding one character in each possible position
		ArrayList <StringBuilder> wrongWordsCase1 = new ArrayList<StringBuilder>();
		char[] englishLetters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; 
		for (String str: wrongWords) {
			for (int i = 0; i<str.length(); i++) {
				for (char chr: englishLetters) {
					StringBuilder strTemp = new StringBuilder(str);
					strTemp.insert(i, chr);
					if (qHashTable.contains(strTemp.toString())) {
						wrongWordsCase1.add(strTemp);
						System.out.println(str + " -> " + strTemp + " (case 1)");
					} 
				}	
			}
		///////////// 
		/// Check case 2 - removing one character from the word
		ArrayList <StringBuilder> wrongWordsCase2 = new ArrayList<StringBuilder>();
		//for (String str: wrongWords) {
			for (int i = 0; i<str.length(); i++) {
				StringBuilder strTemp = new StringBuilder(str);
				strTemp.deleteCharAt(i);
				if (qHashTable.contains(strTemp.toString())) {
					wrongWordsCase2.add(strTemp);
					System.out.println(str + " -> " + strTemp + " (case 2)");
				} 
			}
		//} 
		/// Check case 3 - swapping adjacent characters in the word
		
		ArrayList <StringBuilder> wrongWordsCase3 = new ArrayList<StringBuilder>();
		//for (String str: wrongWords) {
			for (int i = 0; i<str.length()-1; i++) {
				StringBuilder strTemp = new StringBuilder(str);
				char leftLetter = strTemp.charAt(i);
				strTemp.deleteCharAt(i);
				strTemp.insert(i+1, leftLetter);
				if (qHashTable.contains(strTemp.toString())) {
					wrongWordsCase3.add(strTemp);
					System.out.println(str + " -> " + strTemp + " (case 3)");
					
				}	
			}
		} 
		return wrongWords;
	}
	
	//if (Quadratic)
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		/////////// QUERY WORDS //////////////////////
		FileReader f0 = new FileReader("src/query_words.txt");
		BufferedReader b0 = new BufferedReader(f0);
		ArrayList <String> words0 = new ArrayList<String> ();
		String line0, maxword0="";
		while ((line0 = b0.readLine()) != null) {
			String s0[] = line0.split(" ");
			for(String t0:s0) {
				int len = t0.length();
			      for (int i0 = 0; i0 < len; i0++) {
			         // checks whether the character is not a letter
			         // if it is not a letter ,it will return false
			         if ((Character.isLetter(t0.charAt(i0)) == false)) {
			            t0 = "";
			            len = 0;
			        	//t = t.replace("-", " ");
			        	//t = t.replace(".", "");
			        	//t = t.replace(",", "");
			        	//t = t.replace("'", "");
			        	//t = t.replace("--", "");
			        	//len = 0;
			         }
			      }
			    if (!t0.equals("") && !t0.equals("\n") && !t0.equals(" ") && !t0.equals("  ") && !t0.equals("I")) {
			    	words0.add(t0.toLowerCase());
			    	//if ()
			    	//System.out.println(t + ": " + Character.getType(t));
			    	//System.out.println(t);
			    }
				//words.add(t);
				}
		}
		
		/////////// BIGGER DOCUMENT //////////////////
		
		FileReader f = new FileReader("src/document1_short.txt");
		BufferedReader b = new BufferedReader(f);
		ArrayList <String> words = new ArrayList<String> ();
		String line, maxword="";
		while ((line = b.readLine()) != null) {
			String s[] = line.split(" ");
			for(String t:s) {
				int len = t.length();
			      for (int i = 0; i < len; i++) {
			         // checks whether the character is not a letter
			         // if it is not a letter ,it will return false
			         if ((Character.isLetter(t.charAt(i)) == false)) {
			            t = "";
			            len = 0;
			        	//t = t.replace("-", " ");
			        	//t = t.replace(".", "");
			        	//t = t.replace(",", "");
			        	//t = t.replace("'", "");
			        	//t = t.replace("--", "");
			        	//len = 0;
			         }
			      }
			    if (!t.equals("") && !t.equals("\n") && !t.equals(" ") && !t.equals("  ") && !t.equals("I")) {
			    	words.add(t.toLowerCase());
			    	//if ()
			    	//System.out.println(t + ": " + Character.getType(t));
			    	//System.out.println(t);
			    }
				//words.add(t);
				}
		}
		checkQuery(words0);
		checkSpelling(words);	    
	}
}
	