package solution108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrefixSum {
	static int num[];
	static int prefixsum[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		num = new int[n];
		prefixsum = new int[n+1];
		
		String tmp[] = br.readLine().split(" ");
		for(int i = 0 ; i< n ; i++) {
			num[i] = Integer.parseInt(tmp[i]);
			
			prefixsum[i+1] = prefixsum[i] + num[i]; 
			
			
		}
		for(int i = 0 ; i < m ;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(prefixsum[b]-prefixsum[a-1]);
		}
	}
}	
