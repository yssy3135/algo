package algo;

/*위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.*/

import java.util.Scanner;

public class Solution24 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n+1][n+1];
		
		
		
		
		
		for(int i = n ; i >= 1 ; i--) {
			for(int j = 1 ; j <= n-i+1 ; j++ ) {
				arr[i][j] = sc.nextInt();
				System.out.print(arr[i][j]);
			}
			System.out.println("");
		}
		
		
		
		for(int i = 2 ; i <= n ; i ++) {
			for(int j = 1 ; j <= n-i+1 ; j++ ) {
				
				arr[i][j] += Math.max(arr[i-1][j], arr[i-1][j+1]);

				
			}
		}
		
		
	
		System.out.println(arr[n][1]);
		
		
	
		
		
	}
	
	

	
}
