// Submitted By: DEVANG SHARMA
// Linkedin: https://www.linkedin.com/in/devang25/

import java.util.*;
import java.io.*;

class Main 
{ 
	static final int MAXN = 1000001; 
	
	static int spf[] = new int[MAXN]; 
	
	static void sieve() 
	{ 
		spf[1] = 1; 
		for (int i=2; i<MAXN; i++) 
	
			spf[i] = i; 
	
		for (int i=4; i<MAXN; i+=2) 
			spf[i] = 2; 
	
		for (int i=3; i*i<MAXN; i++) 
		{ 
			if (spf[i] == i) 
			{ 
				for (int j=i*i; j<MAXN; j+=i) 
	
					if (spf[j]==j) 
						spf[j] = i; 
			} 
		} 
	} 
	
	static Vector<Integer> getFactorization(int x) 
	{ 
		Vector<Integer> ret = new Vector<>(); 
		while (x != 1) 
		{ 
			ret.add(spf[x]); 
			x = x / spf[x]; 
		} 
		return ret; 
	} 
	
	static int func(int x)
	{
	    Vector <Integer> p = getFactorization(x); 
		Map<Integer, Integer> mp = new HashMap<>(); 
		int n=p.size();
	
			for (int i = 0; i < n; i++) 
        { 
            if (mp.containsKey(p.get(i)))  
            { 
                mp.put(p.get(i), mp.get(p.get(i)) + 1); 
            }  
            else
            { 
                mp.put(p.get(i), 1); 
            } 
        } 
        
        int sum=0;
         for (Map.Entry<Integer, Integer> entry : mp.entrySet()) 
        { 
            sum+= entry.getValue(); 
        } 
        
	    
	    return sum;
	}
	
	public static void main(String args[]) 
	{ 
		sieve(); 
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		
		for (int t=0;t<T;t++)
		{
		int x =s.nextInt(); 
		int i=1;
		int ans=0;
		
		for (i=1;i<=x;i++)
		ans+=func(i);
		
		System.out.println(ans);
		}
	
	
	} 
} 


I/P:
2
4
10

O/P:
4
15
