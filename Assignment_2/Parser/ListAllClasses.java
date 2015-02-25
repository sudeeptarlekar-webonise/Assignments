package Parser;

import java.io.IOException;
import java.util.List;

public class ListAllClasses 
{
	public List listAllClasses(String currentLine, List classes) throws IOException
	{
		if(currentLine.indexOf("class")>=0 && currentLine.indexOf("//")<0 )
		{
			int startindex = currentLine.indexOf("class")+6;
			String classname = currentLine.substring(startindex);
		
			char[] clname = classname.toCharArray();
			int i=0;
				
			int size = clname.length;
			
			i=0;
			while(i<size && clname[i]!=' ' && clname[i]!='{')
				i++;
			
			classname = classname.substring(0,i);
			
			classes.add(classname);
		}			
		return classes;
	}
}
