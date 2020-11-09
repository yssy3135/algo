package Solution55;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		int arr[][] = {{0,1,1,1},{0,0,1,0}};
		solution(arr);
	}
	
    public static int solution(int [][]board)
    {
        int answer = 0;
        
        int a[] = {0, -1, -1};
        int b[] = {-1, 0, -1};
        
        for(int i = 0 ;i < board.length;i++) {
        	for(int j = 0 ; j < board[i].length;j++) {
        		if(board[i][j] == 1) {
        			int min = 1000;
        			for(int k = 0 ; k <3 ; k++) {
        				int movei = i+a[k];
        				int movej = j+b[k];
        				if(movei >= 0  && movej >=0) {
        					min = Math.min(board[movei][movej],min);
        					
        				}else {
        					min= 0 ;
        					break;
        				}

        			}
        			board[i][j] = min+1;
        			answer = Math.max(min+1, answer);
        		}
        		
        	}
        }
        
        
		
		 System.out.println(Arrays.deepToString(board));
		 System.out.println((int)Math.pow(answer,2));
		 
        
        

        return answer;
    }
	
	
}
