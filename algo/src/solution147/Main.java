package solution147;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String word = br.readLine();
		visited = new boolean[word.length()];
		//1. 사전순서중 제일 앞에 있는 단어 위치 찾기
		
		search(word,0,word.length());

		
	}
	
	public static void print(String word) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < visited.length;i++) {
			if(visited[i]) {
				sb.append(word.charAt(i));
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void search(String word,int left,int right) {
		int idx = 0;
		int min = Integer.MAX_VALUE;
		for(int i = left ; i < right; i++) {
			if((min > word.codePointAt(i)) && !visited[i]) {
				min = word.codePointAt(i);
				idx = i;
			}
		}
		
		if(min == Integer.MAX_VALUE) return;
		
		visited[idx] = true;
		print(word);
		
		search(word,idx,right);
		search(word,left,idx);
		
		
		

	}
	
}
