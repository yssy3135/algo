package before_algo;

import java.util.Scanner;

public class Solution39 {
	static boolean visited[];
	
	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);

	        int N = sc.nextInt();   
	        int[] T = new int[N+10];
	        int[] P = new int[N+10];
	        int[] dp = new int[N+10];

	  
	        for(int i=1; i<=N; i++){
	        	
	            T[i] = sc.nextInt();
	            P[i] = sc.nextInt();
	        }

	        int max = 0; 

	        for(int i=1; i<=N+1; i++){
	          
	            dp[i] = Math.max(max, dp[i]);
	           if(i+T[i] <= N+1) {
	        	   dp[i+T[i]] = Math.max(dp[i+T[i]], P[i]+dp[i]);
	           }
	           if(max < dp[i]) {
	        	   max = dp[i];
	           }
	           
	           
	        }

	        System.out.println(max);
		
		
	}
	

}
