package Parser;

import java.io.*;

public class FileParser
{
	public static void main(String arg[])
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter path of the file to be parsed");
		FileReader file = null;
		String path = null;
		
		try
		{
			path = in.readLine();
			file = new FileReader(path);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Path doesn't contain file or directory");
		}
		catch(IOException e)
		{
			System.out.println("Enter correct path");
		}
		
		AllClassesAndMethods allClassesAndMethods = new AllClassesAndMethods();
		Display display = new Display();
		try
		{
			display.DisplayContent(allClassesAndMethods.getFileInfo(path));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
