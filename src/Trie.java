import java.util.*;
import java.lang.*;

//class that represents a Trie tree for the words in the dictionary
public class Trie implements Storage 
{ 
	private TrieNode root;
	public int size;
	
	public Trie() //constructor
    	{
		root = new TrieNode();
		size = 0;
	}

	public void insert(String str) 
	{
		TrieNode node = root;
		for (int level = 0; level < str.length(); level++) 
		{
			int currentChar = str.charAt(level);
            		if (node.letters[currentChar] == null)
            		{
				node.letters[currentChar] = new TrieNode(); //place node there
			}
			node = node.letters[currentChar]; //traverse the tree letter by letter
		} 
        	node.end = true;
        	++size;
	} 

	public boolean find(String str) //searches through tree to find the string
	{ 
		TrieNode node = root; 
		for (int level = 0; level < str.length(); level++)
		{ 
			int index = str.charAt(level); //travel down letter by letter
           		 if (node.letters[index] == null) //if you reached the end of the tree and did not find it return false
			 {
                		return false; 
			}
			node = node.letters[index]; //sets the node so it travels down the tree
		}
		return node.end; //if you found the end of the word return true;
	}

	public String toString()
	{
		return "trie";
	}

	private class TrieNode
	{ 
		private final int SIZE = 127; //max amount of ascii characters

		private TrieNode[] letters; //array of nodes that contains possible letters
		private boolean end; //boolean to represent end of word

		public TrieNode() //constructor
		{ 
			letters = new TrieNode[SIZE];
			end = false;
		}
	}
}
