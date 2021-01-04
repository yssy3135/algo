package Solution86;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	
	static String se1[];
	static String se2[];
	static int dp[][];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		se1 = br.readLine().split("");
		se2 = br.readLine().split("");
		
		dp = new int[se1.length][se2.length];
		
		for(int i = 0 ; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(LCS(se1.length-1,se2.length-1));
	}
	
	
	public static int LCS(int x, int y) {
		
		if(x == -1 || y == -1) {
			return 0;
		}
		
	
		if(dp[x][y] == -1) {
			dp[x][y] = 0;
			if(se1[x].equals(se2[y])) {
				dp[x][y] = LCS(x-1,y-1)+1;
		
			}else {
				dp[x][y] = Math.max(LCS(x-1,y), LCS(x,y-1));
			}
			
			
		}
		
		return dp[x][y];
		
	}
	
}
