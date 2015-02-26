package Parser;

import java.io.*;

/*
 * This is main class which accepts path of the file from user and pass this path to the file information 
 * object, which will collect all the information from the file and store to the hashmap, and will return that hashmap.
 * Once you receive this hashmap it will be passes to display class for displaying purpose
 */
public class FileParser
{
	public static void main(String arg[])
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter path of the file to be parsed");
		FileReader fileReader = null;
		String path = null;
		
		try
		{
			path = inputReader.readLine();
			fileReader = new FileReader(path);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Path doesn't contain file or directory");
		}
		catch(IOException e)
		{
			System.out.println("Enter correct path");
		}
		
		FileInformation fileInformation = new FileInformation();
		Display display = new Display();
		try
		{
			display.DisplayContent(fileInformation.getFileInfo(path));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
