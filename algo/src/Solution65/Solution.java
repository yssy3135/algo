package Solution65;


import java.util.Arrays;

import java.util.LinkedList;

import java.util.Queue;


public class Solution {

	
	public static void main(String[] args) {
		String a[] = {"ABCD", "BACE", "BCDD", "BCDD" };
		
		solution(4,4,a);
	
		
	}
	
	
	static String[][] arr;
	static boolean visited[][];
	static int answer;
	static int sizem;
	static int sizen; 
    public static int solution(int m, int n, String[] board) {
        answer = 0;
        sizem = m;
        sizen = n;
	    //높이 m
	    //폭 n
        
        visited	 = new boolean[m][n];
        arr = new String[m][n];
        for(int i =0 ; i < board.length;i++) {
        	arr[i] = board[i].split("");
        }

	    	
	    	for(int i = 0 ;i  <arr.length;i++) {
	    		for(int j = 0 ; j < arr[i].length;j++) {
	    			if(!arr[i][j].isEmpty()) {
	    				check(i,j,arr[i][j]);
	    			}
	    		}
	    	}
	    	
	    	while(true) {

	    		if(!pop()) {
	    	
	    			break;
	    		}
	    	
	    	}

	  

	    
	    
	
   
        System.out.println(answer);
	   
        return answer;
    }
    
    
    public static void check(int x,int y,String target) {
    	int a[] = {0,1,1};
    	int b[] = {1,0,1};
    	
    	for(int i = 0 ; i < 3 ; i++) {
    		int movei = a[i]+x;
    		int movej = b[i]+y;
    		
    		if(movei >= 0 && movej >= 0 && movei < sizem && movej < sizen) {
	    		if(!arr[movei][movej].equals(target)) { // 같지않다.
	    				
	    				return ;
	    		}
    		}else {
    			return;
    		}
//    		System.out.println();
//    		System.out.println("기준"+arr[x].get(y)+target);

    	}
    
    	visited[x][y] = true;
    	
    	for(int i = 0 ; i < 3 ; i++) {
    		int movei = a[i]+x;
    		int movej = b[i]+y;
    		
    		visited[movei][movej] = true;

    		
    	}
//    	System.out.println(Arrays.deepToString(visited));
    	
    	
    	
    }
    
    public static boolean pop() {

    	
    	boolean flag = false;
    	for(int i = 0 ; i < arr.length;i++) {
    		for(int j = 0 ; j < arr[i].length;j++) {
    			if(visited[i][j]) {
    				flag = true;
//    				if(i != 0  && !arr[i-1][j].isEmpty()) {
//    					arr[i][j] = arr[i-1][j];
//    				}
    				arr[i][j] = "";
    				answer++;
    			}
    			
    		}
    	}


    	push();

//    	for(int i = 0 ;i  <arr.length;i++) {
//    		for(int j = 0 ; j < arr[i].length;j++) {
//    			if(arr[i][j].isEmpty()) {
//    				System.out.print(" ");
//    			}else {
//    				
//    				System.out.print(arr[i][j]);
//    			}
//    		}
//    		System.out.println();
//    	}
    	
    	
    	for(int i = 0 ; i <visited.length;i++) {
    		Arrays.fill(visited[i], false);
    	}
    	
    	
    	for(int i = 0 ;i  <arr.length;i++) {
    		for(int j = 0 ; j < arr[i].length;j++) {
    			if(!arr[i][j].isEmpty()) {
    				 check(i,j,arr[i][j]);
    			}
    		}
    	}
    	return flag;
    }
    
    public static void push() {
    		
	    	Queue<String> que = new LinkedList<String>();
	    	for(int j = 0 ; j < arr[0].length;j++) {
	    		for(int i = arr.length-1 ;i >=0;i--) {
		    		if(!arr[i][j].isEmpty()) {
		    			que.add(arr[i][j]);
		    			arr[i][j] = "";
		    			
		    		}
		    	}
	    		// 차례대로 열에 넣기
	    		
	    		int size = arr.length-1;
	    		while(!que.isEmpty()) {
	    			arr[size][j] = que.poll();
	    			size--;
	    		}
		    }
    
    			
    			
	    	
    		// 차례대로 열에 넣기
    		
	    	
	    }
    
    
    
    
    
    
	
}
