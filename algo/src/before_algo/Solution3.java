package before_algo;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution3 {
    boolean solution(String s) {
        boolean answer = false;
        Queue<String> queue = new LinkedList<String>();
        
        String[] one = s.split("");
        Stack<String> st = new Stack<String>();
        Stack<String> st2 = new Stack<String>();
        
        
        for(int i = 0 ;i< one.length;i++) {
        	
        	
        	if(one[i].equals("(")) {
        		
        		st.add("(");
        		
        	}else if (one[i].equals(")")) {
        		
        		if(st.isEmpty()) {
        			answer = false;
        			break;
        			
        		}else {
        			
        			if(st.peek().equals("(")) {
        				st.pop();
        				if(i == one.length-1 && st.isEmpty()) {
        					answer = true;
        				}
        			}
        			
        			
        			
        			
        		}
        		
        		
        		
        		
        		
        		
        	}
        	
        	
        	
        	
        	
        }
        
 
        
		return answer;
    }
}