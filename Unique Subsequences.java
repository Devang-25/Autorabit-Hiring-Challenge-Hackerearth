// Submitted By: DEVANG SHARMA
// Linkedin: https://www.linkedin.com/in/devang25/


import java.io.*;
import java.util.*;

public class Main
{

static int func(String S, String T) {
        int n = S.length();
        int m = T.length();

        int[][] dp = new int[m + 1][n + 1];
        if (m > n) return 0;

        for (int i = 1; i <= m; i++) dp[i][0] = 0;

        for (int j = 0; j <= n; j++) dp[0][j] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) != S.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }


	public static void main(String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int T=sc.nextInt();

        for (int i=0; i<T; i++)
        {
	    int n=sc.nextInt();
	    
	    String s=sc.next();
	    String t="abcdefghijklmnopqrstuvwxyz";
        
	
		System.out.println(func(s,t));
        }
	}
}



I/P:
3
27
abcdefghijklmnopqrstuvwxyzz
28
abcdefghijklmnopqrstuvwxyyzz
3
abz

O/P:
2
0
4


