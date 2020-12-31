package before_algo;

import java.util.Scanner;

public class Solution28 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		int j = sc.nextInt();
		
		
		int arr[][] = new int[j][2];
		
		for(int i = 0 ; i < j ;  i ++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			
		}
		
		int ans = 0 ;
		for(int i = 0 ; i < j-1; i ++) {
			if(arr[i][1] == arr[i+1][0]) {
				ans = 1;
			}
		}
		
		System.out.println(ans);
		
		
		
	}
}
