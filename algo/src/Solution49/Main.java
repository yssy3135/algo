package Solution49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;




public class Main {
	public static void main(String[] args) {
		
		solution("{{2,1},{2},{2,1,3},{2,1,3,4}}");
		
	}
	
    public static int[] solution(String s) {
        int[] answer ;
        
        String input = s.substring(2, s.length()-2);

        String word[] = input.split("\\}\\,\\{");
        Arrays.sort(word,new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		// TODO Auto-generated method stub
        		return o1.length() - o2.length();
        	}
		});
        ArrayList<String> list = new ArrayList<String>();
        
        for(int i = 0 ; i < word.length;i++) {
        
        	String tmp[] = word[i].split(",");
        	for(String d : tmp) {
        		if(!list.contains(d)) {
        			list.add(d);
        		}
        	}
        }
       
        answer = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++) {
        	answer[i] = Integer.parseInt(list.get(i));
        	
        }
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	
}
