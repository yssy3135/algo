package solution145;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[n+1][n+1];
		int dp[][] = new int[n+1][n+1];
		
		for(int i = 1 ; i <= n; i++) {
			String tmp[] = br.readLine().split(" ");
			for(int j = 1 ; j <= n;j++) {
				
				map[i][j] = Integer.parseInt(tmp[j-1]);
				
			}
		}
		
		for(int i = 1 ; i <= n; i++) {
			for(int j = 1 ; j <= n;j++) {
				
				dp[i][j] = dp[i-1][j] + dp[i][j-1]-dp[i-1][j-1]+map[i][j];
				
			}
		}
		

		
		for(int i = 0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum = 0;
			
			sum = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
			System.out.println(sum);
			
		}
		
		
		
		
	}
	
	
	
	
	
}
