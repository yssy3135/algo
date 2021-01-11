package solution87;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		
		solution(4,4,new int[][] {{3,2},{2,4}});
		
	}
	

	
	static int ans;
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int map[][] = new int[n+1][m+1];
        
        

        for(int i  = 0 ; i < puddles.length; i++) {
        	int x = puddles[i][0];
        	int y = puddles[i][1];
        	map[x][y] = -1;
        	
        	
        }
        
        ans = 0;
        bfs(map,m,n);
        System.out.println(ans%1000000007);
        return ans%1000000007;
    }
    
   
   public static void bfs(int map[][],int m,int n) {
	   int a[] = {1, 0};
	   int b[] = {0, 1};
	   Queue<int[]> que = new LinkedList<int[]>();
	   que.add(new int[] {1,1,0});
	   
	   
	   while(!que.isEmpty()) {
		   int cur[] = que.poll();
		   
		   int cnt = cur[2];
		   int x = cur[0];
		   int y = cur[1];
		   
		   for(int i = 0 ; i <2;i++) {
			   int mx = x+a[i];
			   int my = y+b[i];
			   
			   if(mx <=n && my <= m && mx !=0 && my!=0) {
				   
				   if(mx == n && my == m ) {
					   if(map[mx][my] == 0) {
						   map[mx][my] = cnt;
						   ans = ans%1000000007+1; 
					   }else if(map[mx][my] == cnt) {
						   ans = ans%1000000007+1; 
					   }
					   
				   }else if(map[mx][my] != -1 ) {
					   map[mx][my] = cnt;
					   que.add(new int[] { mx,my,cnt+1});
				   }
				   
				   
				   
			   }
			   
			   
			   
		   }
	   }
	   
	   
	   
   }
    
	
}
