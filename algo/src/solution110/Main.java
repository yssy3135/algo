package solution110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	static int eat[];
	static int max;
	public static void main(String[] args) throws IOException {
		
//		접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		arr = new int[n];
		eat = new int[d+1];
		max = 0;
		int cnt = 0 ;
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		
		
		for(int i = 0 ; i < k; i++) {
			if(eat[arr[i]] == 0 ) cnt++;
			eat[arr[i]]++;
		}
		
		max = cnt;
		
		for(int i = 1 ; i < n ; i++) {
			if(max <= cnt) {
				if(eat[c] == 0) {
					max = cnt +1;
				}
				else {
					max = cnt;
				}
			}
			
			eat[arr[i-1]]--;
			if(eat[arr[i-1]] == 0)cnt--;   //안먹은 종류
			
			
			if(eat[arr[(i+k-1)%n]] == 0)cnt++;
			eat[arr[(i+k-1)%n]]++;
			
		}
		
		
		System.out.println(max);

	}
}
