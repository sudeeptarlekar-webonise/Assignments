package Parser;

import java.io.*;
import java.util.*;

class FileInformation
{
	String currentLine;

	HashMap collection = new HashMap(); // Will store all the information about the file
	private List classesList = new ArrayList(); // This list will contain all the classes in the file
	private	List methodsList = new ArrayList(); // This list will contain all the methods in the file
	private List variablesList = new ArrayList(); // This list will contain all the variables in the file
	
	
	public HashMap getFileInfo(String path) throws IOException
	{
		collection.put("Type", (String)getType(path));
		BufferedReader fin = getFileObject(path);
		
		ListAllClasses allClasses = new ListAllClasses();
		ListAllMethods allMethods = new ListAllMethods();
		ListAllVariables allVariables = new ListAllVariables();
		
		if("Java".equals((String)collection.get("Type")))
		{
			while((currentLine = fin.readLine()) != null)
			{
				fin = checkForComment(currentLine, fin);
				
				classesList = allClasses.listAllClasses(currentLine, classesList);
				methodsList = allMethods.listAllJavaMethods(currentLine, methodsList);
			}
		}
		else if("PHP".equals((String)collection.get("Type")))
		{
			while((currentLine = fin.readLine())!=null)
			{
				fin = checkForComment(currentLine, fin);
				
				classesList = allClasses.listAllClasses(currentLine, classesList);
				methodsList = allMethods.listAllPhpMethods(currentLine, methodsList);
				variablesList = allVariables.listAllPHPVariables(currentLine, variablesList);
			}
		}
		else
		{
			while ((currentLine = fin.readLine()) !=null)
			{
				fin = checkForComment(currentLine, fin);
				classesList = allClasses.listAllClasses(currentLine, classesList);
				methodsList = allMethods.listAllRubyMethods(currentLine, methodsList);
				variablesList = allVariables.listAllRubyVariables(currentLine, variablesList);
			}
		}
		
		collection.put("Classes", classesList);
		collection.put("Methods", methodsList);
		collection.put("Variables", variablesList);
		
		return collection;
	}
	
	/*
	 * This method will identify the type of the file from its containts
	 */
	private String getType(String path) throws IOException
	{
		String type = null;
		BufferedReader fin = getFileObject(path);
		String currentLine = null;
		while((currentLine = fin.readLine()) != null)
		{
			if(currentLine.indexOf("<?php") >=0)
			{
				type="PHP";
				break;
			}
			else if(currentLine.indexOf("class")>=0)
			{
				if(currentLine.indexOf("{")>=0)
					type="Java";
				else
					type = "Ruby";
			}
		}
		return  type;
	}
		
	/*
	 * This method will be used to obtain fresh new file object from path received
	 */
	
	private BufferedReader getFileObject(String path) throws FileNotFoundException
	{
		BufferedReader fin = new BufferedReader(new FileReader(path));
		return fin;
	}

	/*
	 * If file contains some comment then this function will parse that line and keep file pointer to the end of the comment line
	 */
	private BufferedReader checkForComment(String currentLine, BufferedReader fin) throws IOException
	{
		if(currentLine.indexOf("/*")>=0)
			while(currentLine.indexOf("*/")<0)
				currentLine = fin.readLine();
		return fin;
	}
}
