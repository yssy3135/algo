package algo;

import java.util.Scanner;

public class Solution26 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
		
		
		for(int i = 1 ; i <= n ; i ++) {
			arr[i] = sc.nextInt();
		}
		
		
		
		dp[1] = 1;
		for(int i = 2; i <=n ; i++) {
			dp[i] = 1;
			for(int j = 1 ; j <i;j++) {
				if(arr[i] < arr[j] && dp[i] <dp[j]+1) {
					dp[i] = dp[j] + 1;
					
				}
			}
		
		}
		
		
		int ans = 1;
		
		for(int i = 1; i < arr.length;i++) {
			ans = Math.max(dp[i], ans);
	
		}
		
	
		
		System.out.println(ans);
		
		
		
		
		
		
		
		
	}
}
