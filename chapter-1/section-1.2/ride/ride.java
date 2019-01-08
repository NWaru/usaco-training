/*
ID: nosawar1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main(String[] args) throws IOException {
	
	BufferedReader f = new BufferedReader(new FileReader("ride.in"));
	PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("ride.out")));

	String name = f.readLine();
	String msg = f.readLine();

	char[] n = name.toCharArray();
	char[] c = msg.toCharArray();

	int commetProd = 1; 
	int groupProd = 1; 

	for(char letter: n)
	{
	    commetProd *= ((int)(letter)) - 64;
	}
	for(char letter: c)
	{
	    groupProd *= ((int)(letter)) - 64;
	}

	if(groupProd % 47 == commetProd % 47)
	{
	    out.println("GO");
	}
	else
	{
	    out.println("STAY");
	}

	out.close();
    }
}
	
