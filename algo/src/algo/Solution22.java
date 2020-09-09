package algo;

import java.util.Scanner;

public class Solution22 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n = sc.nextInt();
		
		
		for(int i = 0 ; i< n ; i++) {
			
			int num = sc.nextInt();
			
			
			System.out.println(score(num));
		}
		
	
			
			
			
			
		
		
	
		
		
		
	}
	
	
	public static int score(int n) {
		int arr[][] = new int[n+1][2];
		int topsum = arr[0][1];
		int bottomsum = arr[0][0];
		
		
		
		
		
		
		for(int i = 1 ; i <= n ;i++) {
			arr[i][0] = sc.nextInt();
		}
		
		for(int i = 1 ; i <= n ;i++) {
			arr[i][1] = sc.nextInt();
		}
		
		
		

		
		int oper = 1;
		
		int tool = -1;
		
		for(int i= 2 ; i <= n ; i++) {
		
			arr[i][0] = Math.max(arr[i-1][1],arr[i-2][1] ) + arr[i][0];
            arr[i][1] = Math.max(arr[i-1][0],arr[i-2][0] ) + arr[i][1];
            
//          조건  스티커의 왼쪽, 오른쪽, 위, 아래에 있는 스티커는 사용할 수 없게 된다.
//			그러면 자신이 [i][0]일때 [i-1][1] 위대각선  [i-2][0] 자신의 2칸 왼쪽
//            3칸 뒤 대각선의 경우는 결국 1칸뒤 대각선 + 2칸뒤 대각선 + 3칸뒤 대각선의 경우로도 갈 수 있기 때문에 절대로 많은 칸수를 거친 경우보다 클 수 없다
//            고려해야 할 것은 1칸 뒤 대각선, 2칸 뒤 대각선의 경우로 이렇게 2가지 이다. 

				
		}
			
		
		
		
		
		
		
		
		
		
		
		return Math.max(arr[n][0], arr[n][1]);
		
	}
	
	
}
