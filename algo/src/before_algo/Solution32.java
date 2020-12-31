package before_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution32 {
	
	
	static boolean visited[][];
	static int arr[][];
	
	public static void main(String[] args) throws IOException {
		
		// ���� ���� �Ǵ� �밢������ ����Ǿ� �ִ� �簢���� �ɾ �� �ִ� �簢���̴�.
		
		// ù° �ٿ� ������ �ʺ�w�� ���� h�� �־�����.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		while(true) {
			int ans = 0;
			String tmp[] = br.readLine().split(" ");
			
			int w = Integer.parseInt(tmp[0]);
			int h = Integer.parseInt(tmp[1]);
		
			if(w == 0 || h ==0) return ;
		
			 arr = new int[h+2][w+2];
			visited = new boolean[h+2][w+2];
			
			for(int i = 1 ; i <= h ; i++) {
				
				String row[]= br.readLine().split(" ");
				for(int j = 1 ; j <= w ; j++) {
					arr[i][j] = Integer.parseInt(row[j-1]);

				}
				
			}
			

			for(int i = 1 ; i <= h ; i++) {
				for(int j = 1 ; j <= w ; j++) {
					if(!visited[i][j] && arr[i][j] == 1) {
						visited[i][j] = true;
						dfs(i,j);
						ans++;
					}

				}
			}
			
			System.out.println(ans);

		} // while end
		

		
	}// main end
	
	public static void dfs(int i,int j) {

		if(arr[i-1][j] == 1 && !visited[i-1][j]) { //��
			visited[i-1][j] = true;
			dfs(i-1,j);
		}
		if(arr[i+1][j] == 1 && !visited[i+1][j]) { //��
			visited[i+1][j] = true;
			dfs(i+1,j);
		}
		if(arr[i-1][j-1] == 1 && !visited[i-1][j-1]) { //��޴�
			visited[i-1][j-1] = true;
			dfs(i-1,j-1);
		}
		if(arr[i-1][j+1] == 1 && !visited[i-1][j+1]) {//�����
			visited[i-1][j+1] = true;
			dfs(i-1,j+1);
		}
		if(arr[i][j-1] == 1 && !visited[i][j-1]) {//��
			visited[i][j-1] = true;
			dfs(i,j-1);
		}
		if(arr[i+1][j-1] == 1 && !visited[i+1][j-1]) { // �Ͽ޴�
			visited[i+1][j-1] = true;
			dfs(i+1,j-1);
		}
		if(arr[i+1][j+1] == 1 && !visited[i+1][j+1]) {//�� ����
			visited[i+1][j+1] = true;
			dfs(i+1,j+1);
		}
		if(arr[i][j+1] == 1 && !visited[i][j+1]) {// ��
			visited[i][j+1] = true;
			dfs(i,j+1);
		}

	}
	
	
	

}
