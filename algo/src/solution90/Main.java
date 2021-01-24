package solution90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int map[][];
	static boolean visited[][];
	
	static int a[] = {1,-1,0,0};
	static int b[] = {0,0,-1,1};
	static int[] paper = {0,5,5,5,5,5};
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		//색종이를 가장 적게 붙여야 하니까 5개짜리부터 1개짜리까지 붙힐수 있는지 탐색하고
		//가능하면 붙힌다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[10][10];
		visited = new boolean[10][10];
		for(int i = 0 ; i < 10 ; i++) {
			String tmp[] = br.readLine().split(" ");
			for(int j = 0 ; j < tmp.length; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		
		
		dfs(0,0,0);
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	public static void dfs(int x,int y,int cnt) {

		
		if(x >=9 && y>9) {
			ans = Math.min(ans, cnt);
			return ;
		}
		if(y > 9) {
			dfs(x+1,0,cnt);
			return ;
		}
		
		if(ans <= cnt) return;
		
		
		if(map[x][y] == 1) {
			for(int i = 5 ; i >0 ; i--) {
				if(paper[i] > 0 && chk(x,y,i)) {
					onpaper(x, y, i, 0);
					paper[i]--;
					
					dfs(x,y+1,cnt+1);
					
					onpaper(x, y, i,1);
					paper[i]++;
				}
			}
		}else {
			dfs(x,y+1,cnt);
		}
		
	}
	
	
	public static boolean chk(int x,int y,int sizep) {
		
		
		for(int i = x ; i < x+sizep;i++) {
			for(int j = y ; j < y+sizep;j++) {
				if(i <10 && j < 10 && i >=0 && j >=0){
					if(map[i][j] == 0) {
						return false;
					}
				}else {
					return false;
				}
			}
		}
		

		return true;
	}
	
	public static void onpaper(int x,int y,int sizep,int status) {
		
		for(int i = x ; i < x+sizep;i++) {
			for(int j = y ; j< y+sizep;j++) {
					map[i][j] = status;
			}
		}
	}
	
	
	
}
