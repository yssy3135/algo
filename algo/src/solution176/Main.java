package solution176;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int num[];
	
	static ArrayList<Integer> list[];
	static int time[];
	static int n;
	static int arr[][];
	static int ans = 0;
	static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new ArrayList[27];
		num = new int[27];
		time = new int[27];

		
		for(int i = 0; i <=26;i++) {
			list[i] = new ArrayList<Integer>();
		}


		String input ="";
		while(( input = br.readLine()) != null ) {
			
			StringTokenizer st = new StringTokenizer(input);
			
			int a = st.nextToken().codePointAt(0)-64;
			int b = Integer.parseInt(st.nextToken());
			
			if(st.hasMoreTokens()) {
				String c[] = st.nextToken().split("");
				time[a] = b;
				
				for(int i = 0 ; i < c.length;i++) {
					list[c[i].codePointAt(0)-64].add(a);	
					num[a]++;
				}
			}else {
				time[a] = b;
			}
		}
		
		n = 26;
		
		topology();
		
		

		Arrays.parallelSort(dp);
		System.out.println(dp[n]);
		
	}
	
	
	public static void topology() {
		Queue<Integer> que = new LinkedList<Integer>();
		dp = new int[n+1];
		
		for(int i = 1 ; i <= n ;i++) {
			if(num[i]==0 && time[i] !=0) {

				que.add(i);
				dp[i] = time[i];
			}
		}
	
		for(int i = 1 ; i <= n ;i++) {
			if(que.isEmpty()) {
				for(int k = 1 ; k<=n;k++) {
				}
				return;
			}
			
			int cur = que.poll();
		
			for(int j = 0 ; j < list[cur].size();j++) {
				int get = list[cur].get(j);

				if(dp[get] < time[get] + dp[cur]) {
					dp[get] = time[get]+dp[cur];
					
				}
				
				num[get]--;

				if(num[get]==0) {
					
					que.add(get);
				}
				
				
			}

		}
		
		

		
		
	}
	
	
	
}
