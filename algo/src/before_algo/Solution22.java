package before_algo;

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


		for(int i = 1 ; i <= n ;i++) {
			arr[i][0] = sc.nextInt();
		}
		
		for(int i = 1 ; i <= n ;i++) {
			arr[i][1] = sc.nextInt();
		}
		

		
		for(int i= 2 ; i <= n ; i++) {
		
			arr[i][0] = Math.max(arr[i-1][1],arr[i-2][1] ) + arr[i][0];
            arr[i][1] = Math.max(arr[i-1][0],arr[i-2][0] ) + arr[i][1];
            
 
            
 //           ��ƼĿ�� ����, ������, ��, �Ʒ��� �ִ� ��ƼĿ�� ����� �� ���� �ȴ�.
//			�׷��� �ڽ��� [i][0]�϶� [i-1][1] ���밢��  [i-2][0] �ڽ��� 2ĭ ����
//            3ĭ �� �밢���� ���� �ᱹ 1ĭ�� �밢�� + 2ĭ�� �밢�� + 3ĭ�� �밢���� ���ε� �� �� �ֱ� ������ ����� ���� ĭ���� ��ģ ��캸�� Ŭ �� ����
//            ����ؾ� �� ���� 1ĭ �� �밢��, 2ĭ �� �밢���� ���� �̷��� 2���� �̴�. 
// 
				
		}
			
		
		
		
		
		
		
		
		
		
		
		return Math.max(arr[n][0], arr[n][1]);
		
	}
	
	
}
