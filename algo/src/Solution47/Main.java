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
		
		max = 0;
		dp[0] =arr[0];
		for(int i = 1 ; i< num ; i++) {
			
			dp[i] =Math.max(arr[i], arr[i] + dp[i-1]);
			
			max = Math.max(max, dp[i]);
		}
		
		for(int i = 0 ; i< num ; i++) {
			
			System.out.print(dp[i]+ " ");
		}
		System.out.println();
		System.out.println(max);
		
	}
}
