package algo;

import java.util.Scanner;

public class Solution25 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
		
		
		for(int i = 1 ; i <= n ; i ++) {
			arr[i] = sc.nextInt();
		}
		
		
		
		dp[1] = arr[1];
		for(int i = 2; i <=n ; i++) {
			dp[i] = arr[i];	// 자신의 값을 dp[i] 로 초기화
			for(int j = 1 ; j < i;j++) {
				if(arr[i] > arr[j]) { // 내가 작아야 더하면서  DP[I] 에 값을 넣음 
					dp[i] = Math.max(dp[j]+arr[i], dp[i]);
					//dp[i] = dp[j]+arr[i] >=  dp[i] ? dp[j]+arr[i] : dp[i];
				}
			}
		
		}
		
		
		int ans = 1;
		
		for(int i = 1; i < arr.length;i++) {
			ans = Math.max(dp[i], ans);
		//	ans = ans >= dp[i] ? ans : dp[i]
		}
		
	
		
		System.out.println(ans);
		
		
		
		
		
		
		
		
	}
}
