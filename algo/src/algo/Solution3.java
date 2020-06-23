package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution3 {
    boolean solution(String s) {
        boolean answer = true;
        Queue<String> queue = new LinkedList<String>();
        
        String[] one = s.split("");
        Stack<String> st = new Stack<String>();
        Stack<String> st2 = new Stack<String>();
        
        
        for(int i = 0 ;i < one.length;i++) {
        	queue.add(one[i]);
        	
        	if(one[i].equals("(")) {
        		st.push("(");
        	}else {
        		st.push(")");
        	}
        	
        	
        }
        
        for(int i = 0;i<queue.size();i++) {
        	
        	
        	
   
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}