/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Fall 2021
 */


package assignment3;
import java.util.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
public class Main {
	
	// static variables and constants only here.
	public static HashMap<String, String> wordMap; //key = word, value = parent
	public static LinkedList<String> wordQueue; //for use in DFS - stores next nodes to be explored
	public static Set<String> discoveredDFS; //stores discovered words
	public static boolean foundDFS; //terminates recursion
	
	public static void main(String[] args) throws Exception {
		
		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file, for student testing and grading only
		// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default input from Stdin
			ps = System.out;			// default output to Stdout
		}
	initialize();
	}
	
	public static void initialize() {
		//initialize  static variables
		foundDFS = false;
		discoveredDFS = new HashSet<String>();
		wordQueue = new LinkedList<String>();
		wordMap = new HashMap();
	}
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of Strings containing start word and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		ArrayList<String> inputWords = new ArrayList<String>();
		String input;
		for (int i = 0; i < 2; i++) {
			input = keyboard.next();
			if (input.toLowerCase().equals("/quit")) {
				return inputWords; //just return empty array
			}
			
			else {
				inputWords.add(input);
			}
		}
		
		return inputWords;
	}
	
	//returns word ladder from start to end if able to find one using DFS
	//if cannot find a word ladder then returns list with just start and end
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		
		// Returned list should be ordered start to end.  Include start and end.
				// If ladder is empty, return list with just start and end.
				// TODO some code
				
		if (start.equals("/quit")) 
			return null;
		
		else {
			start = start.toLowerCase();
			end = end.toLowerCase();
			Set<String> words = makeDictionary();
			ArrayList<String> wordLadder = new ArrayList<String>();
			makeDFSTree(start, words, end, true);
			if (foundDFS) { //found word ladder, retrace the path
				wordLadder = tracepath(wordMap, end, start);
				return wordLadder;
			}
			
			else { //couldn't find word ladder
				wordLadder.add(start);
				wordLadder.add(end);
				return wordLadder;
			}
		}
	}
	
	//DFS implementation using recursion
	//if the path can be found, sets foundDFS to true and breaks the recursion
	//else recursion breaks if no more words to check
	public static void makeDFSTree(String currentWord, Set<String> words, String end, boolean firstCall) {
		if (firstCall) { //add start word to discovered, wordMap, and Queue
			wordMap.put(currentWord, null);
			wordQueue.addFirst(currentWord);
			discoveredDFS.add(currentWord);
			firstCall = false;
		}
		
		if (wordMap.containsKey(end)) { //base case - breaks recursion
			foundDFS = true;
			return;
		}
				
		findClosestNeighbors(currentWord, end, words); //optimization - checks words closest to end that are children of currentWord first
		while (!wordQueue.isEmpty()) {
			currentWord = wordQueue.removeFirst();
				
			if (currentWord.equals(end)) {
				foundDFS = true;
				return;
			}
			
			else { //get next deepest word but check the ones with more common letters first (closest to the end word)
				makeDFSTree(currentWord, words, end, firstCall);	
			}
		}				
		return;
	}
	
	//helper/optimization for DFS method
	//adds neighboring words to LinkedList in order of difference from end word
	public static void findClosestNeighbors(String currentWord, String end, Set<String> words) {
		ArrayList<LinkedList<String>> commonLetterWords = new ArrayList<>();
			
		for (int i = 0; i < 6; i++) {
			commonLetterWords.add(new LinkedList<String>());
		}	
	
		char[] endWordArr = end.toCharArray();
		char[] currWordArr = currentWord.toCharArray();
		for (int i = 0; i < 5; i++) {
			currWordArr = currentWord.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				currWordArr[i] = c;
				String temp = new String(currWordArr);
				if (words.contains(temp.toUpperCase()) && !temp.equals(currentWord)  && !discoveredDFS.contains(temp)) { //&&!wordMap.containsKey(temp)
					wordMap.put(temp, currentWord);
					discoveredDFS.add(temp);
	
					int numDifferentLetters = 0;
					for (int j = 0; j < 5; j++) {
						if (currWordArr[j] != endWordArr[j])
							numDifferentLetters++;
					}
					
					//get different letters between the new word and end word
					if (numDifferentLetters == 0) 
						commonLetterWords.get(5).add(temp);
					else if (numDifferentLetters == 1) 
						commonLetterWords.get(4).add(temp);
					else if (numDifferentLetters == 2) 
						commonLetterWords.get(3).add(temp);
					else if (numDifferentLetters == 3) 
						commonLetterWords.get(2).add(temp);
					else if (numDifferentLetters == 4) 
						commonLetterWords.get(1).add(temp);
					else if (numDifferentLetters == 5) 
						commonLetterWords.get(0).add(temp);
					
				}
			}
		}
		
		//add the neighboring words to the Queue in order of proximity to end word
		for (int i = 5; i >= 0; i--) {
			LinkedList<String> tempQueue = new LinkedList<>();
			int listSize = commonLetterWords.get(i).size();
			for (int j = 0; j < listSize; j++) {
				wordQueue.addFirst(commonLetterWords.get(i).removeFirst());
			}
			
			tempQueue.clear();
		}
		commonLetterWords.clear();
	}
	
	// USED TO GET THE WORD LADDER USING BFS
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		
		Set<String> words = makeDictionary();
		String start1 = start.toLowerCase();
		String end1 = end.toLowerCase();
		HashMap<String, String> parents = new HashMap<String, String>();
    	boolean a = pathexists(words,parents,start1,end1);
    	if(a== true)
    		return tracepath(parents,end.toLowerCase(),start.toLowerCase());
    	else
    	{
    	   ArrayList<String> d = new ArrayList<> ();
    	   d.add(start.toLowerCase());
    	   d.add(end.toLowerCase());
    	   return d;
    	}
	}
		
    //USED TO GET THE LADDER ITSELF
    public static ArrayList<String> tracepath(HashMap<String,String> parents,String end,String start)
    {    ArrayList<String> a = new ArrayList<>();
    	 ArrayList<String> b = new ArrayList<>();
    	 a.add(end);
    	 String word = end;
    	 while(!word.equals(start))
    	 {
    		a.add(parents.get(word));
    		word = parents.get(word);
    		
    	 }
    	 for(int i = a.size()-1; i>=0;i--)
    	 {
    		b.add(a.get(i)); 
    	 }
    	return b;
    }
    
    //CHECK IF THE WORD LADDER EXISTS
    public static boolean pathexists(Set<String> words, HashMap<String, String> parents, String start, String end)
    {
    	Queue<String> q = new LinkedList<>();
    	Set<String> discovered = new HashSet<String> ();
    	q.add(start);
    	discovered.add(start);
    	parents.put(null,start );
    	while(!q.isEmpty())
    	{
    		String temp = q.remove();
    		if(temp.equals(end))
    			return true;
    		else
    		{
    			ArrayList<String> neigh = getNeighbours(temp,words);
    			for(String neighbours : neigh)
    			{
    				if(!discovered.contains(neighbours))
    				{
    					discovered.add(neighbours);
    					q.add(neighbours);
    					parents.put(neighbours,temp);
    				}
    			}
    		}
    	}
    	return false;
    	
    }
    
    //SET UP THE GRAPH TO BE USED
    public static ArrayList<String> getNeighbours(String temp, Set<String> words)
    {
    	char[] temp1 = temp.toUpperCase().toCharArray();
    	ArrayList<String> ret = new ArrayList<>();
    	for(int j = 0; j<temp1.length;j++)
    	{
    		char orig = temp1[j];
    		for(char c = 'A'; c<='Z'; c++)
    		{
    			if(orig == c)
    				continue;
    			else
    			{
    				temp1[j] = c;
    				String new_word = String.valueOf(temp1);
    				if(words.contains(new_word))
    					ret.add(new_word.toLowerCase());
    			}
    		}
    		temp1[j]= orig;
    	}
    	return ret;
    }
    
    //prints word ladder
    //if a word ladder exists, prints the number of rungs and then the entire word ladder
    //if word ladder does not exists, prints that no word ladder could be found
	public static void printLadder(ArrayList<String> ladder) {
		if (ladder.size() == 2) 
			System.out.println("no word ladder can be found between " + ladder.get(0) + " and " + ladder.get(1) + ".");
		else {
			int numRungs = ladder.size() - 2;
			System.out.println("a " + numRungs + "-rung word ladder exists between " + ladder.get(0) + " and " + ladder.get(ladder.size() - 1) + "." );
			for (int i = 0; i < ladder.size(); i++) {
				System.out.println(ladder.get(i));
			}
		}
	}

	public static int check(String a,String b)
	{
		int e = 0;
		char[] d = a.toCharArray();
		char[] c = b.toCharArray();
		for(int i = 0; i<5;i++)
			if(d[i]!= c[i])
				e++;
		return e;
	}
	/* Do not modify makeDictionary */
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
}
