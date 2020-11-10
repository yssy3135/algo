package Solution60;

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		
		solution(5,words );
		
	}

	
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        ArrayList<String> list = new ArrayList<String>();
        
        for(int i = 0 ; i < words.length;i++) {
        	System.out.println(list.toString());
        	if(i <1) {
        		list.add(words[i]);
        	}else if(list.contains(words[i])) {
        		System.out.println((i+1)/n);
        		System.out.println((i%n)+1);
        		answer[0] = (i%n)+1;
        		answer[1] = (i/n)+1;
        		return answer;
        		
        	}else {
        		list.add(words[i]);
        		char c = words[i-1].charAt(words[i-1].length()-1);
        		if(!words[i].startsWith(Character.toString(c))) {
        			System.out.println((i%n)+1);
        			System.out.println((i/n)+1);
            		answer[0] = (i%n)+1;
            		answer[1] = (i/n)+1;
            		return answer;
        		}
        		
        	}
        	
        	
        }
        answer[0] = 0;
		answer[1] = 0;
		
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		
        return answer;
    }
}

