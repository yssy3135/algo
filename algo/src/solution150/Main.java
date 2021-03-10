package solution150;

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
		int k = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n+1];
		int dp[] = new int[k+1];
		
		for(int i = 1 ; i <= n ;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		

		Arrays.fill(dp, 100001);
		dp[0] = 0;
		for(int i = 1; i <=n;i++) {
			for(int j = arr[i]; j <=k;j++) {
			
				dp[j]= Math.min(dp[j],dp[j-arr[i]]+1);

			}
		}
		
		if(dp[k] != 100001) {
			
			System.out.println(dp[k]);
		}else {
			System.out.println(-1);
		}
		
	
		
		
		
	}
}
