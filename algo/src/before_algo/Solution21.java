package before_algo;

import java.util.Scanner;

public class Solution21 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int [10];
		
//		����
//		��������
//		�������� ���Ƶ� ��������
//		0���� ���� ����
		
		// ���� �����ٴ� ������ ���ų� Ŀ���Ѵ�.
		// 1�϶��� ������ 1��
		
		
		for(int i = 0 ; i< 10;i++) {
			arr[i] = 1;
		}
		
		for(int i = 1 ; i<n;i++) {
			for(int j = 1 ; j < 10; j++) {
				arr[j] = (arr[j] + arr[j-1])%10007 ; //arr[i]���� n-1�� arr[i]�� ����Ǿ������״� [i-1]�� �����ָ� arr[n-1][i] �� ����
				
			}
			
		}
		
		long sum = 0 ;
		
		for(int i = 0 ; i < 10 ; i++) {
			sum += arr[i];
		}
		
	
		System.out.println(sum%10007);
		
		
	}
}
