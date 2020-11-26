package algo;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;

public class Solutionkakao2 {
	
	public static void main(String[] args) {
		
		String orders[] = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		
		int course[] = {2,3,4};
        
		solution(orders,course);
		
	}
	
	
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        

        ArrayList<String> list = new ArrayList<String>();
        
        for(int i = 0 ; i < orders.length;i++) {
        	list.add(orders[i]);
        }
        
        
        
        HashSet<String> set = new HashSet<String>();
        for(int i = 0 ; i < list.size();i++) {
        	for(int j = i +1; j < list.size(); j++) {
        		
        		for(char a : list.get(j).toCharArray()) {
        			if(!list.get(i).contains(Character.toString(a))) { // 문자가 있냐		
        				//없으면 
        				break;
        			}
        		}
        		//있다. 있으면 set에 저장
        		set.add(list.get(i));
        	}
        }
        
      String[] ans =  set.toArray(new String[set.size()]);
    
      
      list.clear();
      for(int i= 0 ; i < ans.length;i++) {
    	  
    	  	if(ans[i].length()>=course[0] && ans[i].length()<=course[course.length-1]) {
    	  		
    	  		System.out.println(ans[i]);
    	  		list.add(ans[i]);
    	  	}
    	  
      }
        
      Collections.sort(list);
      ans = list.toArray(new String[list.size()] )  ;
      
        
        return ans;
    }

}
