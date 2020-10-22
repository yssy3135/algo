package Solution48;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int num = sc.nextInt();
		int arr[] = new int[num];
		int dp[] = new int[num];
		int max = 0;
		
		for(int i = 0 ; i < num ;i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
			for(int j = 0 ; j < num ;j++) {
				if(arr[i]>arr[j] && dp[i]<dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
			
		}
		
		for(int i = 0 ; i < num ; i ++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
			

		
		
		
		
	}
}
