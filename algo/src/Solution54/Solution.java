package Solution54;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	
	
	


	
    public static int solution(int[] nums) {
        int answer = 0;
        
        int size = nums.length/2;
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i < nums.length;i++) {
        	set.add(nums[i]);
        }
        
        
        if(size<set.size()) {
        	answer = size;
        }else {
        	answer = set.size();
        }
     
       
      
        
        return answer;
    }
    

    
   
	
}
