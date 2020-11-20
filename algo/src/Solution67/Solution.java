package Solution67;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;


public class Solution {
	public static void main(String[] args) throws ParseException {
		String a[] = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		String m = "CC#BCC#BCC#BCC#B";
		
		m = m.replaceAll("C#","c");
		m = m.replaceAll("D#","d");
		m = m.replaceAll("F#","f");
		m = m.replaceAll("G#","g");
		m = m.replaceAll("A#","a");
		
		solution(m,a);
	}
	
	
    public static String solution(String m, String[] musicinfos) throws ParseException {
        String answer = "(None)";

        long max = -1;
        for(int i = 0 ; i <musicinfos.length; i ++ ) {
        	String music[] = musicinfos[i].split(",");
        	String melody = music[3];
        	
        	SimpleDateFormat smdf = new SimpleDateFormat("HH:mm");
        	Date start = smdf.parse(music[0]);
        	Date end = smdf.parse(music[1]);
        	
        	long time = end.getTime() - start.getTime();
        	
        	long minute = time / (60*1000);
        	
        	System.out.println(m);
        	melody = melody.replaceAll("C#","c");
        	melody = melody.replaceAll("D#","d");
        	melody = melody.replaceAll("F#","f");
        	melody = melody.replaceAll("G#","g");
        	melody = melody.replaceAll("A#","a");
        	System.out.println(melody);
        	int size = melody.length();
        	
        	boolean contains = false;
        	StringBuilder sb= new StringBuilder();
			for ( int j = 0; j < minute; j++ ) {

				if (sb.toString().length() >= m.length()*2 && j >= melody.length()*2 ) break;
				
				sb.append(melody.charAt(j%size));
				
				if ( sb.toString().length() >= m.length() && sb.toString().contains(m) ){
					contains=true;
					break;
				}
			}
			
			if ( contains ) {
				if ( max == (int)minute ) continue;
				if ( (int)minute > max ) {
					max = (int)minute;
					answer = music[2];
				}
			}

        }


        System.out.println(answer);
        
        return answer;
    }
}
