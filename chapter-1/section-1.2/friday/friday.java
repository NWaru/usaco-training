/*
ID: nosawar1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;

class friday
{        
    public static void main(String[] args) throws IOException
    {
	BufferedReader f = new BufferedReader(new FileReader("friday.in"));
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

	int span = Integer.parseInt(f.readLine());
       
	int[] thirteens = count13(span);

	out.print(thirteens[5] + " " + thirteens[6] + " ");
	for(int i = 0; i < 4; i++)
	{
	    out.print(thirteens[i] + " ");
	}
	out.println(thirteens[4]);

	out.close();
	
    }

    private static boolean isLeap(int year)
    {
	if(year % 100 == 0)
	{
	    return(year % 400 == 0); 
	}
	return(year % 4 == 0); 
    }

    private static int[] count13(int span)
    {
	int[] appearances = new int[7];
	int currentDate;
	int day = 0;
	
	for(int i = 1900; i < 1900 + span; i++)
	{
	    int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
	    if(isLeap(i))
	    {
		months[1] = 29;
	    }
	    
	    for(int j = 0; j < months.length; j++)
	    {
		currentDate = 1;
		
		while(currentDate <= months[j])
		{
		    if(currentDate == 13)
		    {
			appearances[day] += 1;
		    }
		    
		    day++;
		    if(day > 6)
		    {
			day = 0;
		    }
		    
		    currentDate++;
		}
	    }
	}
	return(appearances);
    }   
}
