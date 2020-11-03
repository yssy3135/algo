package Solution51;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	public static void main(String[] args) {
		
		int arr[][] = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		solution(arr);
		
	}
	
	
	static boolean visited[][];
	static int sum[][];
	
    static int solution(int[][] land) {
        int answer = 0;
        
        
        visited = new boolean[land.length][4];
        sum = new int[land.length][4];
        
 
        for(int i = 0 ; i < land.length-1;i++) {
        	if( i == 0 ) {
        		for(int j = 0 ; j < 4 ; j++) {
        			sum[i][j] = land[i][j];
        		}
        	}
        	next(land, i+1);
        }
        
      
        	for(int j = 0 ; j < 4 ; j++) {
        		answer = Math.max(answer, sum[land.length-1][j]);
        	}

      
        System.out.println(answer);
        

        return answer;
    }
    
    
    public static void next(int arr[][],int nexth) {
    	
        	
        	for(int j = 0 ; j < 4 ; j++) { //  ¿­
        		for(int k = 0 ; k < 4 ; k++) {
        			
        			if(j != k) {
        				sum[nexth][k] = Math.max(sum[nexth][k], arr[nexth][k]+sum[nexth-1][j]);
        			}
        		}
        		
        		
        	}
   
    }
    
    
    
 

}
