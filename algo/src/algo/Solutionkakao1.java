package algo;

public class Solutionkakao1 {
	
	public static void main(String[] args) {
		System.out.println(solution("abcdefghijklmn.p"));
	}
	
    public static String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        
        
        // 소문자
        new_id = new_id.toLowerCase();
        
        // 특수문자를 제외하고 제거
        for(int i = 0 ; i < new_id.length();i++) {
        	char tmp = new_id.charAt(i);
        	
        	
        	if(  ( (int)tmp < 97 || (int)tmp >122 ) && ( (int)tmp < 48 || (int)tmp > 57 ) ) {
        		if((int)tmp == 45 || (int)tmp == 95 || (int)tmp == 46  ) {
        			System.out.println("걸림");
        			continue;
        		}
        		
        		new_id = new_id.replace(Character.toString(tmp)," ");
        	
        	}
        }
        new_id = new_id.replaceAll(" ", "");

        // 마침표가 2번이상 연속된 부분을 하나의 마침표로 
        for(int i = 0 ; i < new_id.length();i++) {
        	char tmp = new_id.charAt(i);
        	if(tmp == '.'	 ) {
        		
        		flag = true;
        		
        		continue;
        	}else if(tmp != '.' && flag) {
        		sb.append(".");
        		flag = false;
        		
        	}
        	
        	sb.append(tmp);
        	
        }
        new_id = sb.toString();
       
        
        if(new_id.startsWith("."))new_id = new_id.substring(1, new_id.length());
        if(new_id.endsWith("."))new_id = new_id.substring(0, new_id.length()-1);
        
        
        
        if(new_id.isEmpty()) new_id = "a";
        
        
        if(new_id.length() >= 16) {
        	new_id = new_id.substring(0, 15);
        	if(new_id.endsWith("."))new_id = new_id.substring(0, new_id.length()-1);
        }
        
        if(new_id.length() <=2) {
        	String tmp = new_id.substring(new_id.length()-1, new_id.length());
        	while(new_id.length() <=2) {
        		new_id += tmp;
        	}
        }
        
        
			
        
        
        return new_id;
    }
}
