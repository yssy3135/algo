package Test2;

public class Solution {
	
    public int solution(int[][] location, int[] s, int[] e) {
        int answer = 0;
        
        int x = Math.max(s[0],e[0]);
        int y = Math.max(s[1],e[1]);
        
        int sx = Math.min(s[0],e[0]);
        int sy = Math.min(s[1],e[1]);
        
        
        for(int i = 0 ; i< location.length;i++) {
        	int ux = location[i][0];
        	int uy = location[i][1];
        	
        	if(ux <= x && uy <= y && sx <= ux && sy>= uy) {
        		answer++;
        	}

        }
        
        

        return answer;
    }

}
