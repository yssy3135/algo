package Solution47;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int num = sc.nextInt();
		int arr[] = new int[num];
		int dp[] = new int[num];
		int max = 0;
		for(int i = 0 ; i < num ; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp[0] =arr[0];
		max = dp[0];
		for(int i = 0 ; i< num ; i++) {
			
			dp[i] =Math.max(arr[i], arr[i] + dp[i-1]);
			
			max = Math.max(max, dp[i]);
		}
		

		System.out.println(max);
		
	}
}
