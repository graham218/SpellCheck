import java.io.*;
import java.util.*;

//driver class that parses in files and outputs the spellcheck
public class CS245A1
{
	private static Storage data;

	public static void readDictionary()	//method that reads the dictionary file to store all the read words.
	{
		try
		{
			File file = new File("english.0");
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) //continues to read next line while there still is one
			{
				String word = scan.next();
				data.insert(word);
			}
			scan.close(); 
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
	}

	public static void acceptConfig() //method that takes in config file and then sets the right tree to use
	{
		try
		{
			Properties properties = new Properties(); 
			FileInputStream fis = new FileInputStream(new File("storage.txt"));
			properties.load(fis);
			String storage = properties.getProperty("storage");
			if(storage == null)
			{
				throw new IllegalArgumentException("Property 'storage' not found");
			}
			if(storage.equals("BST"))
			{
				data = new BST();
			}	
			if(storage.equals("trie"))
			{
				data = new Trie();
			}
			if(data == null) 
			{
				throw new IllegalArgumentException("Not valid storage config");
			}
			
		}
		//if error occurs print message
		catch (FileNotFoundException e)
		{
			System.out.println("Config file not found");
			System.exit(1);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		catch (IOException e)
		{
			System.out.println("Error reading the config file");
			System.exit(1);
		}
	}
	
	public static void processFile(String inputpath, String outputpath) //read input output file and write.
	{
		try
		{
			File input = new File(inputpath); //create both files
			File output = new File(outputpath);
			
			FileWriter fw = new FileWriter(output);  
			Scanner scan = new Scanner(input);
			while(scan.hasNextLine())
			{
				String word = scan.nextLine();
				if(data.find(word)) //if word already exists in file you just write.
				{
					fw.write(word);
				}
				else
				{
					List<String> suggestions = data.suggest(word);//get list of suggestions and write them in
					if(suggestions.size() == 0)
					{
						fw.write("--- 0 suggestions for "+word);
					}
					else
					{
						String suggest = "";
						for(String s : suggestions)
						{
							suggest += s +" ";
						}
						fw.write(suggest);
					}
				}
				fw.write("\r\n"); //this adds a new line
			}
			fw.close(); 
			scan.close(); 
		}
		catch (Exception e)
		{
			System.out.println("Error reading or writing the files");
		}
		
	}
	
	public static void main(String[] args)
	{
		acceptConfig(); //read config
		readDictionary(); //input words from dictionary to tree
		processFile(args[0], args[1]);//take command line arguments and process the files
		
	}
}
