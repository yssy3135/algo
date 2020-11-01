package programmers;

public class Solution2 {
	
	public static void main(String[] args) {
		
		String a = "qyyigoptvfb";
		String b = "abcdefghijk";
		int num = 3;
		
		solution(a,b,num);
		
	}
	   public static String solution(String encrypted_text, String key, int rotation) {
	        String answer = "";
	        
	        boolean flag = false ;
	        if(rotation > 0) { // 양수이면 true
	        	flag = true;
	        }
	        
	        Math.abs(rotation);
	        
	        for(int i = 0 ; i < rotation; i++) {
	        	StringBuilder sb = new StringBuilder();
	        	if(!flag) { // 오른쪽
	        		char change = encrypted_text.charAt(encrypted_text.length()-1);
	        		
	        		encrypted_text = change + encrypted_text.substring(0, encrypted_text.length()-1);
	        		
	        	}else { // 왼쪽
	        		char change = encrypted_text.charAt(0);
	        		
	        	
	        		encrypted_text = encrypted_text.substring(1, encrypted_text.length())+change;
	        	}
	        
	        	
	        }
	        
	        System.out.println(encrypted_text);
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0 ; i < key.length(); i++) {
	        	int num = key.charAt(i)-96;
	        	int plus = encrypted_text.charAt(i) - num;
	        	System.out.println(num);
	        	if(plus < 97) {
	        		plus = plus +26;
	        	}
	        	
	        	
	        	sb.append((char) plus);
	        }
	        
	       
	        
	        System.out.println(sb.toString());
	        
	        
	        
	        
	        return sb.toString();
	    }
}
