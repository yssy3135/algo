package solution131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	
	static long num[];
	static long tree[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		num = new long[n];
		tree = new long[n*4];
		
		for(int i = 0 ; i < n ; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		init(0,n-1,1);
		for(int i = 0 ; i < m+k;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			
			//1일때는 b번째 수를 c로 바꾸고 
			if(a == 1) {

				update(0, n-1, 1, b-1, c);
			//2인경우에는 b부터c까지의 곱을 구하여 출력
			}else {
				System.out.println("답"+mul(0, n-1, 1, b-1, c-1)%1000000007);
			}
			
			
		}
		
	}
	
	public static long init(int start,int end,int node) {
		if(start == end) return tree[node] = num[start];
		
		int mid  = (start + end)/2;
		
		
		return tree[node]=(init(start,mid,node*2) * init(mid+1,end,node*2+1))%1000000007;

	}
	
	public static long mul(int start,int end,int node,int left,long right) {
		
		if(left > end || right <start) return 1;
		
		if(left <=start && end <=right) return tree[node];
		
		int mid = (start+end)/2;
		
		
		return (mul(start,mid,node*2,left,right)*mul(mid+1,end,node*2+1,left,right))%1000000007;
	}
	
	public static long update(int start,int end,int node,int idx,long val) {
		if(idx > end || idx <start) return tree[node];
		
		if(start == end) return tree[node] = val;
		
		int mid = (start+end)/2;
		
		return tree[node] = (update(start,mid,node*2,idx,val) * update(mid+1,end,node*2+1,idx,val))%1000000007;
	}
	
	
	
	
}
