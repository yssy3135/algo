package Test2;

import java.util.Arrays;

public class Solution2 {
	
	public static void main(String[] args) {
		solution(10000000,5,5);
		
	}
	
    public static long solution(int n,int r, int c) {
        long answer = 0;

       
        long arr[][] = new long[n][n];
        int cnt = 1;
        
        int size = n*n;
        
        int x = 0;
        int y = 0;
        
        boolean flag = false;
        
        while(cnt<=size) {
        	
        	if(x == 0 && y== 0) { // 시작
        		arr[x][y] = cnt;
        		y++;
        	}else if(x == n-1 && y== n-1) { // 끝
        		arr[x][y] = cnt;
        	}else if(x == 0 && flag && y != n-1) { // 맨위
        		arr[x][y] = cnt;
        		y++;
        		flag = false;
        	}else if(y == 0 && !flag && x != n-1) { // 왼쪽 
        		arr[x][y] = cnt;
        		x++;
        		flag = true;
        	}else if ( x == n-1 && !flag ) { // 아래
        		arr[x][y] = cnt;
        		y++;
        		flag = true;
        	}else if ( y == n-1 && flag) {// 오른쪽
        		arr[x][y] = cnt;
        		x++;
        		flag = false;
        	}else {
        		//오른 모서리 true
        		if(flag) {
        			arr[x][y] = cnt;
        			y++;
        			x--;
        		}else {
        			arr[x][y] = cnt;
        			y--;
        			x++;
        		}
        	}
        	

        	cnt++;
        	
        }
        

        

        return answer;
    }
}
