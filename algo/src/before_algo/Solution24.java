package before_algo;

/*�� �׸��� ũ�Ⱑ 5�� ���� �ﰢ���� �� ����̴�.

�� ���� 7���� �����ؼ� �Ʒ��� �ִ� �� �� �ϳ��� �����Ͽ� �Ʒ������� ������ ��, �������� ���õ� ���� ���� �ִ밡 �Ǵ� ��θ� ���ϴ� ���α׷��� �ۼ��϶�. �Ʒ����� �ִ� ���� ���� ������ ���õ� ���� �밢�� ���� �Ǵ� �밢�� �����ʿ� �ִ� �� �߿����� ������ �� �ִ�.

�ﰢ���� ũ��� 1 �̻� 500 �����̴�. �ﰢ���� �̷�� �ִ� �� ���� ��� �����̸�, ������ 0 �̻� 9999 �����̴�.*/

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


/*
 * ���� ���α׷����� bottom top ��� ���� ���� �ٷ� ������ �����ϸ� Math.max(arr[i-1][j],
 * arr[i-1][j+1]); ��� ��ȭ���� �̿��Ͽ� ū ���� ���ϸ鼭 �ö�´�. ������ ���� return �ϸ� �ڿ����� ���� ū ����
 * ������ �ȴ�.
 */



