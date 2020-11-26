package ReSolution67;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Solution {
	public static void main(String[] args) throws ParseException {
		
		String a[] = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		solution("ABC",a);
	}
	
	
    public static String solution(String m, String[] musicinfos) throws ParseException {
        String answer = "(None)";
        m = m.replaceAll("C#","c");
        m = m.replaceAll("D#","d");
        m = m.replaceAll("F#","f");
        m = m.replaceAll("G#","g");
        m = m.replaceAll("A#","a");
        int maxtime = 0 ;
       
        
       
        for(int i = 0 ; i < musicinfos.length;i++) {
        	String[] music = musicinfos[i].split(",");
        	
        	String melody = music[3];
        	melody = melody.replaceAll("C#","c");
        	melody = melody.replaceAll("D#","d");
        	melody = melody.replaceAll("F#","f");
        	melody = melody.replaceAll("G#","g");
        	melody = melody.replaceAll("A#","a");
        	
        	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        	
        	Date start = sdf.parse(music[0]);
        	Date end = sdf.parse(music[1]);
        	long time = end.getTime() - start.getTime();
        	
        	long minute = time / (60*1000);
        	boolean flag = false;
        	
        	if(melody.length() < minute) {
        	
        		if(m.contains(melody)) {
        			System.out.println(music[2]);
        			flag = true;
        		}
        	}else {
        	
        		
        		for(int j = 0 ; j < minute; j++) {
        				
        			m = m + m.charAt(j);
        			if(m.contains(melody)) {
        		
        				flag = true;
        				break;
        			}
        			
        			
        		}	
        	}
        	
        	if(maxtime == (int)minute) continue;
        	
        	if((int)minute > maxtime) {
        		maxtime = (int)minute;
        		answer = music[2];
        	}
        		
        	
        	
        	
        	
        }
                
        
        
        
        
        
        System.out.println(answer);
        
        
        return answer;
    }
	
}
