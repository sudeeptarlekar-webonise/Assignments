package Parser;

import java.util.*;

public class ListAllVariables 
{
	public List listAllPHPVariables(String currentLine, List variablesList)
	{
		char[] variable = null;
		int start = currentLine.indexOf("var $");
		if(start>=0)
			variable = (currentLine.substring(start+5)).toCharArray();
		int i=0;
		if(variable!=null)
		{
			while(i<variable.length)
			{
				if(variable[i]==' ' || variable[i]=='=' || variable[i]==';')
					break;
				i++;	
			}
			variablesList.add((currentLine.substring(start+5, (start+5+i))));
		}
		return variablesList;
	}
	
	public List listAllRubyVariables(String currentLine, List variablesList)
	{
		int start = currentLine.indexOf("@");
		int i=0;
		char[] variable = null;
		
		if(start>=0)
			variable = (currentLine.substring(start+1)).toCharArray();
		
		if(variable!=null)
		{
			while(i<variable.length)
			{
				if(variable[i]=='@')
					start++;
				if(variable[i]==' ' || variable[i]=='=')
					break;
				i++;
			}
			variablesList.add((currentLine.substring(start+1, (start+1+i))));
		}
		
		return variablesList;
	}
	
	public List listAllJavaVariables(String currentLine, List variablesList)
	{
		
		return variablesList;
	}
}
