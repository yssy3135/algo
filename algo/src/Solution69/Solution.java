package Solution69;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public static void main(String[] args) {
		String a[] = {"img000012345", "img1.png", "img2", "IMG02", };
		
		
		solution(a);
		
	}
	
	
    public static String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files,new Comparator<String>() {
        	
			@Override
			public int compare(String o1, String o2) {
				
				String[] file1 = detach(o1);
				String[] file2 = detach(o2);
				
				System.out.println("비교"+ file1[0].compareTo(file2[0]));
				System.out.println("file[0]"+ file1[0]);
				System.out.println("file[1]"+ file2[0]);
				
				
				if(file1[0].compareTo(file2[0]) == 0) {	 //앞에 head 부분이 동일한가?
					// 동일하면 뒤에 number 부분 처리
					int num1 = Integer.parseInt(file1[2]);
					int num2 = Integer.parseInt(file2[2]);

					
					return num1 - num2;
				}else {
					return file1[0].compareTo(file2[0]);
				}
			}
        	
        });
        
        System.out.println(Arrays.toString(files));

        
        return answer;
    }
    
    public static String[] detach(String word) {
    	System.out.println(word);
    	boolean flag = false;
    	int start = 0;
    	int end = 0;
      	for(int j = 0 ; j <word.length();j++) {
    		char c = word.charAt(j);
    		
    		if(Character.isDigit(c)) {
    			if(!flag ) {
    				start = j;
    			}
    			flag = true;
    		}else if (!Character.isDigit(c) && flag) {
    			end = j;
    			break;
    		}
    	}// inner for end
    	String name =word;
    	String head = name.substring(0, start);
    	String tail = name.substring(end,name.length());
    	System.out.println(start);
    	System.out.println(end);
    	
    	end = end == 0 ? word.length() : end;
    	String number = name.substring(start, end);
    	
  
    	
    	String file[] = {head.toLowerCase(),tail,number};
    	
		return file;
    	
    }
    
    
    
}
