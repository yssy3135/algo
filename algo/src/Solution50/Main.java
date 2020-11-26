package Solution50;

public class Main {
	public static void main(String[] args) {
		solution("JEROEN");
		solution("JAN");
		
	}
	//65 ~ 90
    public static int solution(String name) {
        int answer = 0;
        int cnt = 0;
        for(int i = 0 ; i < name.length();i++) {
        	int wordlen = (int)name.charAt(i);
        	System.out.println("����"+wordlen);
        	
        	if(wordlen == 65) {
        		cnt ++;
        		
        	}else if(wordlen-'A'>13) {
        		cnt += 91-wordlen;
        	}else {
        		cnt += wordlen-'A';
        	}
        
        	cnt++;
        }
        
        System.out.println(cnt);
        return answer;
    }
	
	
}
