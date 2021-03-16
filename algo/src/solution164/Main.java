package solution164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int arr[][];
	static int n;
	static int INF = 10000000;
	static int cnt[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		
		arr = new int[n+1][n+1];
		cnt = new int[n+1];
		
		
		for(int i = 0 ;i < m ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;

		
		}
		
		floyd();
		
		Arrays.fill(cnt, n-1);
		for(int i = 1 ; i <=n ; i++) {
			for(int j = 1; j <=n;j++) {
				if(arr[i][j] == 1 ) {
					cnt[i] -=1;
					cnt[j] -=1;
				}
				
			}
		}
		
		
		for(int i = 1 ; i <=n ; i++) {
			
			System.out.println(cnt[i]);
			
		}
		
		
		
	
		
		
	}
	
	public static void floyd() {
		 // 기준이 되는 거쳐가는 노드 i
		for(int i = 1 ; i <=n ; i++) {
			// 출발하는 노드 j
			for(int j = 1; j <=n;j++) {
				// 도착하는 노드 k
				for(int k = 1 ; k <=n;k++) {
					if(arr[j][i] ==1 && arr[i][k] ==1) {
						arr[j][k] = 1;
					}
				}
			}
		}
		
		
	}
	
}
