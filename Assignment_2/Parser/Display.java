package Parser;

import java.util.*;
import java.io.*;
class Display
{
	
	public void DisplayContent(HashMap collection)
	{
		
		System.out.println("Type of the file is " +collection.get("Type"));
		
		System.out.println("All Classes are " + collection.get("Classes"));
		
		System.out.println("All Methods are " +  collection.get("Methods"));
		
	}
}
