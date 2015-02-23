package Parser;

import java.io.*;
import java.util.*;

class AllClassesAndMethods
{
	String currentLine;

	HashMap collection = new HashMap();
	private List classes = new ArrayList();
	private	List methods = new ArrayList();
	
	public HashMap getFileInfo(String path) throws IOException
	{
		collection.put("Type", (String)getType(path));
		listAllClasses(path);
		switch((String)collection.get("Type"))
		{
		case "Java":	listAllJavaMethods(path);
						break;
		case "Ruby":	listAllRubyMethods(path);
						break;
		case "PHP":		listAllPhpMethods(path);
						break;
		}
		
		return collection;
	}
	
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
	
	public void listAllClasses(String path) throws IOException
	{
		BufferedReader fin = getFileObject(path);
		currentLine = fin.readLine();
		
		
		while(currentLine != null)
		{
			if(currentLine.indexOf("/*")>=0)
				while(currentLine.indexOf("*/")<0)
					currentLine = fin.readLine();
			if(currentLine.indexOf("class")>=0 && currentLine.indexOf("//")<0 )
			{
				int startindex = currentLine.indexOf("class")+6;
				//System.out.println(currentLine);
				//System.out.println(startindex);
				
				String classname = currentLine.substring(startindex);
				//System.out.println(classname);
				
				char[] clname = classname.toCharArray();
				int i=0;
				
				//System.out.println("Printing class name using char array");
				//System.out.println(clname.length);
				int size = clname.length;
				/*while(i<size)
				{
					System.out.print(clname[i]);
					i++;
				}*/				
				i=0;
				while(i<size && clname[i]!=' ' && clname[i]!='{')
				{
					//System.out.println(i);
					i++;
				}
				//System.out.println(i);
				classname = classname.substring(0,i);
				//System.out.println(classname);
				classes.add(classname);
			}			
			currentLine = fin.readLine();
		}
		collection.put("Classes",classes);
		//collection.put("Type", "Java");
	}

	public void listAllJavaMethods(String path) throws IOException
	{
		int start=0;
		int start1=0;
		int end=0;
		String methodName = null;
		String currentLine = null;
		BufferedReader fin = getFileObject(path);
		currentLine = fin.readLine();
		//System.out.println(currentLine);
		
		while(currentLine != null)
		{
			start = currentLine.indexOf(" ");
			start1 = currentLine.indexOf(" ", start+1);
			end = currentLine.indexOf("(");
			if(start != -1 && start1 != -1 && end != -1)
				if(start1<end)
				{
					methodName = currentLine.substring(1, start)+" "+ currentLine.substring(start1+1, end);
					methods.add(methodName);
					//System.out.println(methodName);
				}
			
			if(methodName != null && methodName.equals("public main"))
				break;
			
			currentLine = fin.readLine();
		}
		collection.put("Methods", methods);
	}
	
	public void listAllRubyMethods(String path) throws IOException
	{
		BufferedReader fin = getFileObject(path);
		String currentLine = null;
		int start = 0;
		while((currentLine = fin.readLine()) != null)
		{
			start = currentLine.indexOf("def");
			if(start>=0)
				methods.add(currentLine.substring(start+4));
		}
		collection.put("Methods", methods);
	}
	
	public void listAllPhpMethods(String path) throws IOException
	{
		BufferedReader fin = getFileObject(path);
		
		int start = 0;
		String methodName = null;
		
		while((path = fin.readLine()) != null)
		{
			if(path.indexOf("/*")>=0)
				while(path.indexOf("*/")<0)
					path = fin.readLine();
			
			start = path.indexOf("function");
			if(start>=0 )
			{
				if(path.indexOf("//")<start && path.indexOf("//")!=-1)
					continue;
				if(path.indexOf("#")!=-1 && path.indexOf("#")<start)
					continue;
				if(start-1>=0)
					methodName = path.substring(0,path.indexOf(" ", start-1)) + path.substring(start+8, path.indexOf(")")+1);
				else
					methodName = path.substring(start+8, path.indexOf(")")+1);
				methods.add(methodName);
			}
		}
		collection.put("Methods", methods);
	}
	
	private BufferedReader getFileObject(String path) throws FileNotFoundException
	{
		BufferedReader fin = new BufferedReader(new FileReader(path));
		return fin;
	}
}
