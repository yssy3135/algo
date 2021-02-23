package solution118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n];
		
		
		String tmp[] = br.readLine().split(" ");
		for(int i = 0 ; i < n; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		
		
		int start = 0;
		int end = 0 ;
		int cnt = 0;
		int sum = 0;
		
		
		while(start <= end ) {
			System.out.println(sum);
			System.out.println("반복");
			
			if(sum >= m) {
				sum = sum - arr[start];
				start++;
			}else if(end == n-1) {
				break;
			}else {
				sum = sum + arr[end];
				end++;
			}
			
			
			if(sum == m) cnt++;
			
		}
		
		
		System.out.println(cnt );
		
	}
}
