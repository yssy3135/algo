package before_algo;

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
		}//  ��� �Է�
		
		
		
		/*
		 * 1�� ���� ���� 2�� ���� ���� ���� �ʾƾ� �Ѵ�. 
		 * N�� ���� ���� N-1�� ���� ���� ���� �ʾƾ� �Ѵ�. i(2 �� i �� N-1)��
		 * ���� ���� i-1��, i+1�� ���� ���� ���� �ʾƾ� �Ѵ�
		 */
		
		
		


		for(int i = 2 ; i <= n;i++) {
			arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]); // �������̸� �ʷ� �Ķ�
			arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]); // �ʷ��̸� ���� �Ķ�
			arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]); // �Ķ��̸� ���� �ʷ�
			
		
		
		}
	

		System.out.println(Math.min(arr[n][0], Math.min(arr[n][1], arr[n][2])));
	
	}
}

/*
 * �����̴� �������� ���� ������ ������ ��� ���� �޶���Ѵ�.
 * 
 * �׷��Ƿ�
 * 
 * ���� ���� ���� -> �ʷ� �Ķ�
 * 
 * �ʷ� -> ���� �Ķ�
 * 
 * �Ķ� -> ���� �ʷ�
 * 
 * 
 * 
 * ����ȭ���� ���� Ǯ���ߴ�.
 */


