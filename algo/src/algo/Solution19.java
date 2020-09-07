package algo;

import java.util.Scanner;

public class Solution19 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int arr[][] = new int[n+1][3];
		
		for(int i = 1 ; i <= n;i++) {
			
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}//  비용 입력
		
		
		
		/*
		 * 1번 집의 색은 2번 집의 색과 같지 않아야 한다. 
		 * N번 집의 색은 N-1번 집의 색과 같지 않아야 한다. i(2 ≤ i ≤ N-1)번
		 * 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다
		 */
		
		
		


		for(int i = 2 ; i <= n;i++) {
			arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]); // 빨간색이면 초록 파랑
			arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]); // 초록이면 빨간 파랑
			arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]); // 파랑이면 빨간 초록
			
		
		
		}
	

		System.out.println(Math.min(arr[n][0], Math.min(arr[n][1], arr[n][2])));
	
	}
}

/*
 * 조건이다 따지고보면 서로 인접한 집들은 모두 색이 달라야한다.
 * 
 * 그러므로
 * 
 * 이전 집이 빨강 -> 초록 파랑
 * 
 * 초록 -> 빨강 파랑
 * 
 * 파랑 -> 빨강 초록
 * 
 * 
 * 
 * 이점화식을 세워 풀이했다.
 */


