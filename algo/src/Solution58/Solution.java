package Solution58;


import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		solution("cdcd");
	}
	
    public static int solution(String s)
    {
        int answer = 0;
        
        String word[] = s.split("");
        
    
        Stack<String> st = new Stack<String>();
        
        for(int i = 0 ; i <word.length;i++) {
        	
        	if(st.size() <1 ) {
        		st.add(word[i]);
        	}else {
        		st.add(word[i]);
        		
        		if(st.peek().equals(st.get(st.size()-2))) {
        			st.pop();
        			st.pop();
        		}
        		
        		
        	}
        }
        
        
        if(st.size() == 0 ) {
        	answer = 1;
        }else {
        	answer = 0;
        }
       
        
        
        System.out.println(answer);

        return answer;
    }
	
}
