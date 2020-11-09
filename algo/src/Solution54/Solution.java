package Solution54;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	
	
	static boolean visited[];
	static int answer;
	public static void main(String[] args) {
		int arr[] = {3,3,3,2,2,4};
		solution(arr);
	}
	
    public static int solution(int[] nums) {
        answer = 0;
        
       visited = new boolean[nums.length];
       
       combi(nums,0,nums.length,nums.length/2);
       
      
        
        return answer;
    }
    
    public static void combi(int arr[],int start,int n,int r) {
    	if(r == 0 ) {
    		HashSet<Integer> set = new HashSet<Integer>();
    		for(int i = 0 ; i < arr.length;i++) {
    			if(visited[i]) {
    				set.add(arr[i]);
    				
    			}
    		}
    	
    		answer = Math.max(answer, set.size());
    		
    	}
    	
    	for(int i = start ; i < arr.length;i++) {
    		visited[i] = true;
    		combi(arr,i+1,n,r-1);
    		visited[i] = false;
    	}
    	
    	
    	
    }
    
    
   
	
}
