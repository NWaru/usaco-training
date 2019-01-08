/*
ID: nosawar1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

class gift1
{
    public static void main(String[] args) throws IOException
    {
	BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
	StringTokenizer st;

	int groupSize = Integer.parseInt(f.readLine());
	
	Map<String, Integer> m = new HashMap<String, Integer>();
       
	for(int i = 0; i < groupSize; i++)
	{
	    m.put(f.readLine(), 0);
	}
       		
	int amount = 0;
	int shared = 0;
	for(String person = f.readLine(); person != null; person = f.readLine())
	{
	    st = new StringTokenizer(f.readLine());
	    amount = Integer.parseInt(st.nextToken());
	    shared = Integer.parseInt(st.nextToken());
	    
	    if(shared == 0) continue;
	    
	    amount = amount - (amount % shared); 
	    m.put(person, m.get(person) - amount);
	    
	    for(int i = 0; i < shared; i++)
	    {
		String recipient = f.readLine();
		m.put(recipient, m.get(recipient) + (amount/shared));
	    }
	}
	
	f.close();
	f = new BufferedReader(new FileReader("gift1.in"));
	f.readLine();
	for(int i = 0; i < groupSize; i++)
	{
	    String p = f.readLine();
	    out.println(p + " " + m.get(p));
	}
	out.close();
    }
}
