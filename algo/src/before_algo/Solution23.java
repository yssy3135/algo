package before_algo;

import java.util.Scanner;

public class Solution23 {
	public static void main(String[] args) {
		 //1. ���� �����ϸ� ���ܿ� �ִ� �����ִ� ��� ���ž� �Ѵ�.
		// 2. �������� �����ִ� 3���� ��� ���� ���� ����.
		
		// �ִ� 2�ܱ��� ���Ǽ� �ִ�.
		// ���� �ִ�� ���Ǽ� �ִ� ���
		
		
		
		//�������� ����
		Scanner sc = new Scanner(System.in);
		
		int ans = 0;
		
		int n = sc.nextInt();
		
		int arr[] = new int[n+1];
		
		for(int i= 1 ; i <= n;i++) {
			arr[i] = sc.nextInt();
			
		}
		
		int dp[] = new int[n+1];
		
//		����� ��
//		2���� �԰� ������ ����
//		1���� �԰� ������ ����
		
		
		dp[1] =arr[1];
		
		if(n>1)
		dp[2] = arr[1]+arr[2];
		for(int i = 3 ; i <= n;i++) {
			// �ȸ��� ��� ���� �ȸԾ����� �� ���� ������ �ȸ����� �������
			//dp[n] = dp[n-1];
			
			// ���� �Դ°��� ������ ������ 2�ܸԴ°� �ǹǷ� ������ �ȵȴ�.
			//dp[n] = dp[n-2]+arr[n];
			// ���� �Դ°�� ������ ������ �ȵǰ� n-3 ���� ���� ������ �ִ�
			//dp[n] = dp[n-3]+arr[n-1]+arr[n];
			
			dp[i] = Math.max( dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]) );
			
		}
		
		
		
		System.out.println(dp[n]);
		
		
		
		
		
		
	}
}
