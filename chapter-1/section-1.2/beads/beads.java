/* 
ID: nosawar1
LANG: JAVA
TASK: beads 
*/

import java.io.*;
import java.util.*;

class beads
{
    public static void main(String[] args) throws IOException
    {
	BufferedReader f = new BufferedReader(new FileReader("beads.in"));
	PrintWriter out = new PrintWriter(new FileWriter("beads.out"));

	StringTokenizer st = new StringTokenizer(f.readLine());
	int num = Integer.parseInt(st.nextToken());

	st = new StringTokenizer(f.readLine());
	String beads = st.nextToken();

	String sep;
	
	String first;
	String last;

	int greatest = 0;
	
	for(int i = 0; i < num; i++)
	{
	    sep = beads.substring(i) + beads.substring(0, i);
	    
	    first = sep.substring(0,1);
	    int n = 1;
	    while(n < num && first.equals("w"))
	    {
		first = sep.substring(n,n+1);
		n++;
	    }
	    
	    last = sep.substring(num-1);
	    n = num-2;
	    while(n >= 0 && last.equals("w"))
	    {
		last  = sep.substring(n, n+1);
		n--;
	    }
	    System.out.println(first + " " + last);
	    
	    int fromStart = 0;
	    int fromEnd = 0;
	    int sum = 0;

	    int j = 0;
	    while(j < num && (sep.substring(j,j+1).equals(first) || sep.substring(j,j+1).equals("w")))
	    {
		fromStart++;
		j++;
	    }

	    int k = num-1;
	    while(k >= j && (sep.substring(k,k+1).equals(last) || sep.substring(k,k+1).equals("w")))
	    {
		fromEnd++;
		k--;
	    }
	    sum = fromStart + fromEnd;

	    if(sum > greatest)
	    {
		greatest = sum;
	    }
	}

	out.println(greatest);
	out.close();
    }
}
