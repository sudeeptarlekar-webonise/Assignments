package Parser;

import java.io.IOException;
import java.util.List;

public class ListAllMethods
{
	public List listAllJavaMethods(String currentLine, List methods) throws IOException
	{
		int start=0;
		int start1=0;
		int end=0;
		String methodName = null;
		
		start = currentLine.indexOf(" ");
		start1 = currentLine.indexOf(" ", start+1);
		end = currentLine.indexOf("(");
		if(start != -1 && start1 != -1 && end != -1)
			if(start1<end)
			{
				methodName = currentLine.substring(1, start)+" "+ currentLine.substring(start1+1, end);
				methods.add(methodName);
			}
		return methods;
	}
	
	public List listAllRubyMethods(String currentLine, List methods) throws IOException
	{
		int start = 0;
			start = currentLine.indexOf("def");
			if(start>=0)
				methods.add(currentLine.substring(start+4));
		return methods;
	}
	
	public List listAllPhpMethods(String currentLine, List methods) throws IOException
	{
		int start = 0;
		String methodName = null;
			
		start = currentLine.indexOf("function");
		if(start>=0 )
		{
			if(currentLine.indexOf("//")<start && currentLine.indexOf("//")!=-1)
				return methods;
			if(currentLine.indexOf("#")!=-1 && currentLine.indexOf("#")<start)
				return methods;
			if(start-1>=0)
				methodName = currentLine.substring(0,currentLine.indexOf(" ", start-1)) + currentLine.substring(start+8, currentLine.indexOf(")")+1);
			else
				methodName = currentLine.substring(start+8, currentLine.indexOf(")")+1);
			methods.add(methodName);
		}
		return methods;
	}
}
