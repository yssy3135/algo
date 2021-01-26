package solution93;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
	static String sosu[] = {"1","2","3","5","7","9"};
	static StringBuilder sb = new StringBuilder();
	static int n;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		n = Integer.parseInt(br.readLine());
		
		dfs("",0);
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(String num,int cnt) {
		
		if(cnt == n) {
			sb.append(num).append("\n");
			
			return ;
		}
		
	
		for(int i = 0 ; i <= 5; i++) {
//			String next = num +Integer.toString(i);
			String next = num +sosu[i];
			if(sosu(Integer.parseInt(next))) {
				dfs(next, cnt+1);
			}
		}
		
	}
	
	
	public static boolean sosu(int i) {
		if(i==1) return false;
		
		int root = (int)Math.sqrt(i)+1;
		for(int j = 2 ; j < root; j++) {
			if(i%j == 0) {
				return false;
			}
		}
		
		return true;
		
	}
	
	
	
}
