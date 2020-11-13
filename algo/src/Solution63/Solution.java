package Solution63;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Solution {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		String s[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(s);
		
	}
	
	
    public static String[] solution(String[] record) {
        String[] answer = {};
        
        ArrayList<String> list = new ArrayList<String>();
        
        Map<String, String> map = new HashMap<String, String>();
        
        for(int i = 0 ; i< record.length; i++) {
        	String word[] = record[i].split(" ");
        	
        	if(word[0].equals("Enter") || word[0].equals("Change")) {
        		map.put(word[1],word[2]);        		
        	}
        }
        
        for(int i = 0 ; i< record.length; i++) {
        	String word[] = record[i].split(" ");
        	if(word[0].equals("Enter")) {
        		list.add(map.get(word[1])+"님이 들어왔습니다.");
        	}else if(word[0].equals("Leave")) {
        		list.add(map.get(word[1])+"님이 나갔습니다.");
        	}
        }
        System.out.println(list.toString());
        answer = (String[]) list.toArray(new String[0]);

        System.out.println(Arrays.toString(answer));
        
       
        return answer;
    }
	
	
}
