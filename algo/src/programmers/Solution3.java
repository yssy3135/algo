package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution3 {
	public static void main(String[] args) {
		
		int arr[][] = {{0,0,1,1},{1,1,1,1},{2,2,2,1},{0,0,0,2}};
		solution(arr);
		
	}
	
	
	static boolean visited[][];
	static int a[] = {1,-1,0,0};
	static int b[] = {0,0,1,-1};
	
    public static int[] solution(int[][] v){
        int[] answer = {0,0,0};

        int num = v.length;
  
        visited = new boolean[num][num];
		
		for(int i = 0 ; i < num ; i++) {
			for(int j = 0 ;  j < num; j ++) {
				if(v[i][j] == 0 && !visited[i][j]) {
					dfs(v,i,j,0);
				
					answer[0]++;
				}
				if(v[i][j] == 1 && !visited[i][j]) {
					dfs(v,i,j,1);
				
					answer[1]++;
				}
				if(v[i][j] == 2 && !visited[i][j]) {
					dfs(v,i,j,2);
				
					answer[2]++;
				}
				
			}
		}
        
        System.out.println(Arrays.toString(answer));
        
        
        return answer;
    }
	
    
    
    public static void dfs(int arr[][],int i ,int j,int target) {
    	
    	
    	visited[i][j] = true;
    	
		for(int k = 0 ; k < 4 ; k++) {
			int nexti = i+a[k];
			int nextj = j+b[k];
			if(nexti >= 0  && nextj >= 0 && nexti <= arr.length-1  && nextj <= arr.length-1 && !visited[nexti][nextj] && arr[nexti][nextj] == target) {
				dfs(arr,nexti,nextj,target);
		
			}
			
			
		}
    	
    	
    	
    }
    
}
