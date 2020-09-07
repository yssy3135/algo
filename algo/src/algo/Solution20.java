package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution20 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		// 한줄의 경우에 수는 3가지이다.
		//오른쪽, 왼쪽, 안넣는경구
		//그러므로 0 - 안넣음 1- 왼쪽 2 - 오른쪽  으로 가정하고 
		int arr[][] = new int[n+1][3];
		
		arr[1][0]= 1;
		arr[1][1]= 1;
		arr[1][2]= 1;
		
		
		for(int i = 2 ; i <= n ; i++) {
			arr[i][0] = arr[i-1][0]+arr[i-1][1] + arr[i-1][2];
			arr[i][1] = arr[i-1][0]+arr[i-1][2];
			arr[i][2] = arr[i-1][0]+arr[i-1][1];
		
			arr[i][0] = arr[i][0] %9901; 
			arr[i][1] = arr[i][1] %9901; 
			arr[i][2] = arr[i][2] %9901; 
		}
		
		
		
		int sum = arr[n][0]+arr[n][1]+arr[n][2];
	
		System.out.println(arr[n][0]);
		System.out.println(arr[n][1]);
		System.out.println(arr[n][2]);
		System.out.println("----------------------------");
		
		
		System.out.println(sum%9901);
		
		
		
	}
}
