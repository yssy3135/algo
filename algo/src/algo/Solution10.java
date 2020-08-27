package algo;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution10 {
	public static void main(String[] args) {
		
		reverse(1534236469);
		
	}
	
	
    public static int reverse(int x) {
    	
    	int ans = 0;
    	
    	boolean	flag = false;
    ;
    	if(x < 0) {
    		flag = true;
    		x *= -1;
    	}
    	String num = Integer.toString(x);
        
    	
    	
    	List<String> list; 
    	 
    	
    	String tmp[] = num.split("");
    	list =  Arrays.asList(tmp);
    	
    	Collections.reverse(list);
    	
    	StringBuilder sb= new StringBuilder();
    	for(int i = 0 ; i < list.size();i++) {
    		sb.append(list.get(i));
    	}
    	
    	
    	num = sb.toString();
    	
    	
    	System.out.println(num);
    	try {
			
    		ans = Integer.parseInt(num);
		} catch (Exception e) {
			ans = 0;
		}
    	if(flag) {
    		ans *=-1;
    	}
    	
    	System.out.println(ans);

        return ans;
        
    }

}
