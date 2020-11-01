package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public static void main(String[] args) {
		
		int arr[][] = {{1,3,1},{3,5,0},{5,4,0},{2,5,0}};
		solution(6,arr);
	}
	
    public static String solution(int n, int[][] delivery) {
        String answer = "";
        
        int chk[] = new int[n+1];
        StringBuilder sb= new StringBuilder();
        
        
    	Arrays.sort(delivery,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[2] - o1[2];
			}
    	});
    	
   
    	System.out.println( Arrays.deepToString(delivery));
    	
        for(int i = 0 ; i < delivery.length;i++) {
        	if(delivery[i][2] == 1) {
        		chk[delivery[i][0]] = 1;
        		chk[delivery[i][1]] = 1;

        	}else if(chk[delivery[i][0]] == 1 && chk[delivery[i][1]] == 1 ) {
        		chk[delivery[i][1]] = 1;
        	}else if(chk[delivery[i][0]] == 1 && chk[delivery[i][1]] == 0  && delivery[i][2] == 0) {
        		chk[delivery[i][1]] = -1;
        	
        	}else if(chk[delivery[i][0]] == 0 && chk[delivery[i][1]] == 1 && delivery[i][2] == 0 ) {
        		chk[delivery[i][0]] = -1;
        		
        	}
        	
        	
        	
   
        	
        }
        
        for(int i = 1 ; i < chk.length;i++) {
        	if(chk[i] == 0) {
        		sb.append("?");
        	}else if (chk[i] == 1) {
        		sb.append("O");
        	}else {
        		sb.append("X");
        	}

        }
        
        
        
        return sb.toString();
    }
    

	
}
