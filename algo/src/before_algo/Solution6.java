package before_algo;

class Solution6 {
	public static void main(String[] args) {
		
		System.out.println(solution("asdfsadf asdf        "));
		
	}
	
	
	
    public static String solution(String s) {
        String answer = "";
        
      
        String space[] = s.split(" ");
        
   
        StringBuilder sb = new StringBuilder();
        System.out.println(space.length);
        for(int i = 0 ; i<space.length;i++) {
        	if(!space[i].isEmpty()) {
     
	        space[i] = space[i].toLowerCase(); 
	        	
	        sb.append(space[i].substring(0, 1).toUpperCase());
	        sb.append(space[i].substring(1, space[i].length()).toLowerCase());
	  
	         
        
		         if(i < space.length) {
		        	 
		        	 sb.append(" ");
		         }
        	 }else {
        		sb.append(" ");
        	 }
        	
   
        	
        	
        	
        	
       }
        
        int gap = s.length()-sb.length();
        for(int j = 0 ; j < gap;j++){
        	sb.append(" ");
        }
        
        
        return sb.toString();
    }
}