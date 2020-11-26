package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution27 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int arr[][] = new int[n+6][m+6];
		
		int ans = 0;
		
		
		
		for(int i = 3 ;i <n+3;i++) {
			for(int j = 3 ; j < m+3 ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		for(int i = 3 ; i< n+3 ; i++) {
			for(int j = 3 ; j < m+3; j++) {
				ans = tetromino(arr,i,j);
			}
		
		}
		
		
		System.out.println(ans);
		
		
		
		
		
		
	}
	
	static int max = 0;
	
	public static int tetromino (int arr[][],int a ,int b ) {
		
		int sum = 0;
		
		// 모든 가능성을 모두 체크 회전이나 대칭 모두 포함
		
		// 1-1. 직선 case (세로 놓기)
		sum += arr[a][b];
		sum += arr[a+1][b];
		sum += arr[a+2][b];
		sum += arr[a+3][b];
		if(max<sum){
		max = sum;
		}
		// 1-2 직선 case (가로 놓기)
		sum=0;
		sum += arr[a][b];
		sum += arr[a][b+1];
		sum += arr[a][b+2];
		sum += arr[a][b+3];
		if(max<sum){
		max = sum;
		}
		// 2. 네모 case
		sum=0;
		sum += arr[a][b];
		sum += arr[a+1][b];
		sum += arr[a+1][b+1];
		sum += arr[a][b+1];
		if(max<sum){
		max = sum;
		}
		// 3-1. ㄴ case // 왼상단시작 오른 하단 종료. (반시계방향)
		sum=0;
		sum += arr[a][b];
		sum += arr[a+1][b];
		sum += arr[a+2][b];
		sum += arr[a+2][b+1];
		if(max<sum){
		max = sum;
		}
		// 3-1-2. ㄴ case // 왼상단시작 오른 하단 종료. (반시계방향)의 대칭.
		sum=0;
		sum += arr[a][b+1];
		sum += arr[a+1][b+1];
		sum += arr[a+2][b+1];
		sum += arr[a+2][b];
		if(max<sum){
		max = sum;
		}
		// 3-2. ㄴ case // 왼하단시작 오른 상단 종료.
		sum=0;
		sum += arr[a][b];
		sum += arr[a+1][b];
		sum += arr[a][b+1];
		sum += arr[a][b+2];
		if(max<sum){
		max = sum;
		}
		// 3-2-2. ㄴ case // 왼하단시작 오른 상단 종료. 의 대
		sum=0;
		sum += arr[a][b];
		sum += arr[a+1][b+2];
		sum += arr[a][b+1];
		sum += arr[a][b+2];
		if(max<sum){
		max = sum;
		}
		// 3-3. ㄴ case // 왼상단시작 오른 하단 종료 (시계방향)
		sum=0;
		sum += arr[a][b];
		sum += arr[a][b+1];
		sum += arr[a+1][b+1];
		sum += arr[a+2][b+1];
		if(max<sum){
		max = sum;
		}
		// 3-3-2. ㄴ case // 왼상단시작 오른 하단 종료 (시계방향) 의 대칭
		sum=0;
		sum += arr[a][b];
		sum += arr[a][b+1];
		sum += arr[a+1][b];
		sum += arr[a+2][b];
		if(max<sum){
		max = sum;
		}
		// 3-4. ㄴ case // 오른 상단시작 왼 하단 종료
		sum=0;
		sum += arr[a][b+2];
		sum += arr[a+1][b+2];
		sum += arr[a+1][b+1];
		sum += arr[a+1][b];
		if(max<sum){
		max = sum;
		}
		// 3-4-2. ㄴ case // 오른 상단시작 왼 하단 종료 의 대칭
		sum=0;
		sum += arr[a+1][b+2];
		sum += arr[a+1][b+1];
		sum += arr[a+1][b];
		sum += arr[a][b];
		if(max<sum){
		max = sum;
		}
		// 4-1. ㄴㄱ case // 왼상단시작 오른 하단 종료. (ㄴㄱ)
		sum=0;
		sum += arr[a][b];
		sum += arr[a+1][b];
		sum += arr[a+1][b+1];
		sum += arr[a+2][b+1];
		if(max<sum){
		max = sum;
		}
		// 4-2. ㄴㄱ case // 오른 상단시작 하단 종료.
		sum=0;
		sum += arr[a][b+2];
		sum += arr[a][b+1];
		sum += arr[a+1][b+1];
		sum += arr[a+1][b];
		if(max<sum){
		max = sum;
		}
		// 4-3. ㄴㄱ case // 왼하단시작 오른 상단 종료.
		sum=0;
		sum += arr[a+2][b];
		sum += arr[a+1][b];
		sum += arr[a+1][b+1];
		sum += arr[a][b+1];
		if(max<sum){
		max = sum;
		}
		// 4-4. ㄴㄱ case // 왼상단시작 오른 하단 종료. (ㄱㄴ꼴)
		sum=0;
		sum += arr[a][b];
		sum += arr[a][b+1];
		sum += arr[a+1][b+1];
		sum += arr[a+1][b+2];
		if(max<sum){
		max = sum;
		}
		// 5-1. ㅗ case // ㅜ
		sum=0;
		sum += arr[a][b];
		sum += arr[a][b+1];
		sum += arr[a][b+2];
		sum += arr[a+1][b+1];
		if(max<sum){
		max = sum;
		}
		// 5-2. ㅗ case // ㅓ
		sum=0;
		sum += arr[a][b+1];
		sum += arr[a+1][b+1];
		sum += arr[a+2][b+1];
		sum += arr[a+1][b];
		if(max<sum){
		max = sum;
		}
		// 5-3. ㅗ case // ㅗ
		sum=0;
		sum += arr[a+1][b];
		sum += arr[a+1][b+1];
		sum += arr[a+1][b+2];
		sum += arr[a][b+1];
		if(max<sum){
		max = sum;
		}
		// 5-4. ㅗ case // ㅏ
		sum=0;
		sum += arr[a][b];
		sum += arr[a+1][b];
		sum += arr[a+2][b];
		sum += arr[a+1][b+1];
		if(max<sum){
		max = sum;
		}
		
		return max;

	}
	
	
	
}
