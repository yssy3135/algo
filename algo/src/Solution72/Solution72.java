package Solution72;

import java.util.Arrays;

public class Solution72 {
	
	public static void main(String[] args) {
		int a[][]= {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		solution(a);
		
		
	}
	
    public static int solution(int[][] triangle) {
        int answer = 0;
        
        
        for(int i = triangle.length-1 ; i >0 ;i--) {
        	for(int j = 0 ;j < triangle[i].length-1;j++) {
        		triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
        	}
        }
        
        System.out.println(Arrays.deepToString(triangle));
        answer = triangle[0][0];
        System.out.println(answer);
        
        return answer;
    }
}
