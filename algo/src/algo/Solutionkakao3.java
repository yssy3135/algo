package algo;

public class Solutionkakao3 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        
        for(int i = 0 ;i < query.length;i++) {
        	String b[] = query[i].split("and");
        
        	
        	int cnt  = 0 ;
        	//a[0]은 음식 a[1]은 점수
        	String queryscore[] = b[3].split(" ");
        	StringBuilder sb= new StringBuilder();
        	for(int j = 0 ; j< b.length-1;j++) {
        		sb.append(b[i]);
        	}
        	
        	
        	// info 에서 조회
        	for(int k = 0 ; k < info.length;k++) {
        		String score[] = info[k].split(" ");
        		if(info[k].contains(sb.toString())) {
        			if(Integer.parseInt(score[5]) > Integer.parseInt(queryscore[1])) {
        				cnt++;
        			}
        		}
        		
        	}
        	
        	
        }
        
        
        
        
        
        return answer;
    }
}
