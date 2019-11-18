import java.util.*;
import java.lang.*;

//interface for both trees
public interface Storage
{
    public void insert(String str);
	public boolean find(String str);
	public String toString();
    default ArrayList<String> suggest(String str)
    {
		//arraylist of all possible suggestions
		ArrayList<String> suggestions = new ArrayList<String>();
		
		String temp="";
		String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'"; //all possible letters
		char[] allLeters = letters.toCharArray(); //made into an array

		//append a letter
		for(int i = 0; i < allLeters.length; i++)
		{
			temp = str;
			if(find(temp+=allLeters[i]) && !suggestions.contains(temp))
			{
				suggestions.add(temp);
			}
		}

		//add a letter in between each letter
		for(int i = 0; i < str.length(); i++)
		{
			for(int j=0; j < allLeters.length; j++)
			{
				temp = str.substring(0,i) + allLeters[j] + str.substring(i);//concatenate the string
				if(find(temp) && !suggestions.contains(temp))//if word exists and is not in the suggestions add it
				{
					suggestions.add(temp);
				}
			}
		}

		//replace every letter
		for(int i = 0; i < str.length(); i++)
		{
			for (int j=0; j < allLeters.length; j++)
			{
				if (i == str.length()-1) //if the letter is 
				{
					temp = str.substring(0,i) + allLeters[j];

				}
				else
				{
					temp = str.substring(0,i) + allLeters[j] + str.substring(i+1);
				}
				if(find(temp) && !suggestions.contains(temp))//if word exists and is not in the suggestions add it
				{
					suggestions.add(temp);
				}
			}
		}

		//remove a letter
		for(int i=0; i < str.length(); i++)
		{
			temp = str.substring(0,i) + str.substring(i+1); //skip the letter
			if(find(temp) && !suggestions.contains(temp)) //if word exists and is not in the suggestions add it
			{
				suggestions.add(temp);
			}
		}

		//swap letters
		for(int i=0; i < str.length()-1; i++)
		{
			char[] chs = swap(i,i+1, str);//swap the letter and the letter before
			temp = new String(chs); //make that new char array into a string
			if(find(temp) && !suggestions.contains(temp))//if word exists and is not in the suggestions add it
			{
				suggestions.add(temp);
			}
		}

		if (suggestions.size() > 3) //make sure to only have 3 suggestions
		{
			String suggestion1 = suggestions.get(0);
			String suggestion2 = suggestions.get(1);
			String suggestion3 = suggestions.get(2);
			suggestions.clear();
			suggestions.add(suggestion1);
			suggestions.add(suggestion2);
			suggestions.add(suggestion3);
		}
		return suggestions;
	}

	default char[] swap(int i, int j, String str) // helper function
	{
		char ch[] = str.toCharArray(); 
		char temp = ch[i]; 
		ch[i] = ch[j]; 
		ch[j] = temp; 
		return ch;
	}

}
