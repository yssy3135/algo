package solution167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	static boolean visited[];
	static int n;
	static int list[][];
	static int ans = 0;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		list = new int [n][3];
		for(int i = 0 ; i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[i][0] = num;
			list[i][1] = a;
			list[i][2] = b;
		}
		arr = new int[10];
		visited = new boolean[10];
		for(int i = 1 ; i <=9 ; i++) {
			arr[i] = i;
		}
		perm(9,3,0,new int[3]);
		System.out.println(ans);
	}
	
	public static void perm(int n,int r,int cnt,int output[]) {
		if(cnt == r) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i <output.length;i++) {

				sb.append(output[i]);
				
			}
			if(chk(sb.toString())) {

				ans++;
			}
		
			return;
		}
		
		for(int i = 1 ; i <=n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[cnt] = i;
				perm(n,r,cnt+1,output);
				visited[i] = false;
			}
		}
		
	}
	
	public static boolean chk(String num) {
		
		for(int i = 0  ; i < n;i++) {
			
			String vs = Integer.toString(list[i][0]);
			int st = 0;
			int ball = 0;
			
			for(int j = 0 ; j < 3; j++) {
				if(vs.charAt(j) == num.charAt(j)) {
					st++;
				}else if (vs.contains(num.substring(j, j+1))) {
					ball++;
				}
				
			}
			
			if(list[i][1] != st) return false;
			if(list[i][2] !=ball) return false;
			
		}
		
		
		
		return true;
	}
	
	
}
