package algo;

import java.util.Scanner;

public class Solution23 {
	public static void main(String[] args) {
		 //1. 잔을 선택하면 그잔엘 있는 포도주는 모두 마셔야 한다.
		// 2. 연속으로 놓여있는 3잔을 모두 마실 수는 없다.
		
		// 최대 2잔까지 마실수 있다.
		// 가장 최대로 마실수 있는 방법
		
		
		
		//포도주의 개수
		Scanner sc = new Scanner(System.in);
		
		int ans = 0;
		
		int n = sc.nextInt();
		
		int arr[] = new int[n+1];
		
		for(int i= 1 ; i <= n;i++) {
			arr[i] = sc.nextInt();
			
		}
		
		int dp[] = new int[n+1];
		
//		경우의 수
//		2번을 먹고 다음을 쉬기
//		1번을 먹고 다음을 쉬기
		
		
		dp[1] =arr[1];
		
		if(n>1)
		dp[2] = arr[1]+arr[2];
		for(int i = 3 ; i <= n;i++) {
			// 안먹을 경우 지금 안먹었으면 전 잔은 먹으나 안먹으나 상관없다
			//dp[n] = dp[n-1];
			
			// 한잔 먹는경우는 전잔을 먹으면 2잔먹는게 되므로 먹으면 안된다.
			//dp[n] = dp[n-2]+arr[n];
			// 두잔 먹는경우 전잔을 먹으면 안되고 n-3 전의 잔을 먹을수 있다
			//dp[n] = dp[n-3]+arr[n-1]+arr[n];
			
			dp[i] = Math.max( dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]) );
			
		}
		
		
		
		System.out.println(dp[n]);
		
		
		
		
		
		
	}
}
