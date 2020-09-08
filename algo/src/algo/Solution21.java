package algo;

import java.util.Scanner;

public class Solution21 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int [10];
		
//		조건
//		오름차순
//		인접수가 같아도 오름차순
//		0으로 시작 가능
		
		// 전의 수보다는 무조건 같거나 커야한다.
		// 1일때는 무조건 1개
		
		
		for(int i = 0 ; i< 10;i++) {
			arr[i] = 1;
		}
		
		for(int i = 1 ; i<n;i++) {
			for(int j = 1 ; j < 10; j++) {
				arr[j] = (arr[j] + arr[j-1])%10007 ; //arr[i]에는 n-1의 arr[i]이 저장되어있을테니 [i-1]을 더해주면 arr[n-1][i] 가 성립
				
			}
			
		}
		
		long sum = 0 ;
		
		for(int i = 0 ; i < 10 ; i++) {
			sum += arr[i];
		}
		
	
		System.out.println(sum%10007);
		
		
	}
}
