package before_algo;

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
		
		// ��� ���ɼ��� ��� üũ ȸ���̳� ��Ī ��� ����
		
		// 1-1. ���� case (���� ����)
		sum += arr[a][b];
		sum += arr[a+1][b];
		sum += arr[a+2][b];
		sum += arr[a+3][b];
		if(max<sum){
		max = sum;
		}
		// 1-2 ���� case (���� ����)
		sum=0;
		sum += arr[a][b];
		sum += arr[a][b+1];
		sum += arr[a][b+2];
		sum += arr[a][b+3];
		if(max<sum){
		max = sum;
		}
		// 2. �׸� case
		sum=0;
		sum += arr[a][b];
		sum += arr[a+1][b];
		sum += arr[a+1][b+1];
		sum += arr[a][b+1];
		if(max<sum){
		max = sum;
		}
		// 3-1. �� case // �޻�ܽ��� ���� �ϴ� ����. (�ݽð����)
		sum=0;
		sum += arr[a][b];
		sum += arr[a+1][b];
		sum += arr[a+2][b];
		sum += arr[a+2][b+1];
		if(max<sum){
		max = sum;
		}
		// 3-1-2. �� case // �޻�ܽ��� ���� �ϴ� ����. (�ݽð����)�� ��Ī.
		sum=0;
		sum += arr[a][b+1];
		sum += arr[a+1][b+1];
		sum += arr[a+2][b+1];
		sum += arr[a+2][b];
		if(max<sum){
		max = sum;
		}
		// 3-2. �� case // ���ϴܽ��� ���� ��� ����.
		sum=0;
		sum += arr[a][b];
		sum += arr[a+1][b];
		sum += arr[a][b+1];
		sum += arr[a][b+2];
		if(max<sum){
		max = sum;
		}
		// 3-2-2. �� case // ���ϴܽ��� ���� ��� ����. �� ��
		sum=0;
		sum += arr[a][b];
		sum += arr[a+1][b+2];
		sum += arr[a][b+1];
		sum += arr[a][b+2];
		if(max<sum){
		max = sum;
		}
		// 3-3. �� case // �޻�ܽ��� ���� �ϴ� ���� (�ð����)
		sum=0;
		sum += arr[a][b];
		sum += arr[a][b+1];
		sum += arr[a+1][b+1];
		sum += arr[a+2][b+1];
		if(max<sum){
		max = sum;
		}
		// 3-3-2. �� case // �޻�ܽ��� ���� �ϴ� ���� (�ð����) �� ��Ī
		sum=0;
		sum += arr[a][b];
		sum += arr[a][b+1];
		sum += arr[a+1][b];
		sum += arr[a+2][b];
		if(max<sum){
		max = sum;
		}
		// 3-4. �� case // ���� ��ܽ��� �� �ϴ� ����
		sum=0;
		sum += arr[a][b+2];
		sum += arr[a+1][b+2];
		sum += arr[a+1][b+1];
		sum += arr[a+1][b];
		if(max<sum){
		max = sum;
		}
		// 3-4-2. �� case // ���� ��ܽ��� �� �ϴ� ���� �� ��Ī
		sum=0;
		sum += arr[a+1][b+2];
		sum += arr[a+1][b+1];
		sum += arr[a+1][b];
		sum += arr[a][b];
		if(max<sum){
		max = sum;
		}
		// 4-1. ���� case // �޻�ܽ��� ���� �ϴ� ����. (����)
		sum=0;
		sum += arr[a][b];
		sum += arr[a+1][b];
		sum += arr[a+1][b+1];
		sum += arr[a+2][b+1];
		if(max<sum){
		max = sum;
		}
		// 4-2. ���� case // ���� ��ܽ��� �ϴ� ����.
		sum=0;
		sum += arr[a][b+2];
		sum += arr[a][b+1];
		sum += arr[a+1][b+1];
		sum += arr[a+1][b];
		if(max<sum){
		max = sum;
		}
		// 4-3. ���� case // ���ϴܽ��� ���� ��� ����.
		sum=0;
		sum += arr[a+2][b];
		sum += arr[a+1][b];
		sum += arr[a+1][b+1];
		sum += arr[a][b+1];
		if(max<sum){
		max = sum;
		}
		// 4-4. ���� case // �޻�ܽ��� ���� �ϴ� ����. (������)
		sum=0;
		sum += arr[a][b];
		sum += arr[a][b+1];
		sum += arr[a+1][b+1];
		sum += arr[a+1][b+2];
		if(max<sum){
		max = sum;
		}
		// 5-1. �� case // ��
		sum=0;
		sum += arr[a][b];
		sum += arr[a][b+1];
		sum += arr[a][b+2];
		sum += arr[a+1][b+1];
		if(max<sum){
		max = sum;
		}
		// 5-2. �� case // ��
		sum=0;
		sum += arr[a][b+1];
		sum += arr[a+1][b+1];
		sum += arr[a+2][b+1];
		sum += arr[a+1][b];
		if(max<sum){
		max = sum;
		}
		// 5-3. �� case // ��
		sum=0;
		sum += arr[a+1][b];
		sum += arr[a+1][b+1];
		sum += arr[a+1][b+2];
		sum += arr[a][b+1];
		if(max<sum){
		max = sum;
		}
		// 5-4. �� case // ��
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
