package solution89;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static String map[][];
	
	static int a[] = {1,-1,0,0};
	static int b[] = {0,0,-1,1};
	static boolean visited[][];
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map= new String[5][5];
		visited = new boolean[5][5];
		

		ans = 0;
		boolean num[] = new boolean[25];
		for(int i = 0 ; i < 5 ; i++) {
			String tmp[] = br.readLine().split("");
			for(int j = 0 ;j < tmp.length;j++) {
				map[i][j] = tmp[j];
			}
			
		}
		
		
		select(num,0,0,new int[] {0,0,0,0,0,0,0});
	
		
		System.out.println(ans);
		
		
		
		
	}// main end
	
	
	
	
	// 7명의 숫자를 뽑는다.
	public static void select(boolean num[], int cnt,int start) {
		if(cnt == 6) {
			
			
			
			return;
		}
		System.out.println("재귀"+cnt);
		for(int i = start ; i < 25 ; i++) {
			if(!num[i]) {
				num[i] = true;
				select(num,cnt+1,start+1);
				num[i] = false;
			}
		}
		
		
		
	}
	
	
	
}
