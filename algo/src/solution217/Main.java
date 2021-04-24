package solution217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static class TrieNode {
	    // 자식 노드맵.
	    Map<Character, TrieNode> childe = new HashMap<>();
	    // 마지막 글자인지 여부.
	    boolean isLastChar;
	    
		public Map<Character, TrieNode> getChilde() {
			return childe;
		}
		public void setChilde(Map<Character, TrieNode> childe) {
			this.childe = childe;
		}
		public boolean isLastChar() {
			return isLastChar;
		}
		public void setLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}

	}
	
	static class Trie{
		TrieNode root;
		
		public Trie() {
			// TODO Auto-generated constructor stub
			root = new TrieNode();
		}
		
		//자식 노드 추가
		void insert(String word) {
			TrieNode thisNode = this.root;
			
			for(int i = 0 ; i < word.length();i++) {
				// computeIfabsent 키에 해당하는 값이 존재하지 않을 때에만 넘겨준 람다식을 사용한다.
				thisNode = thisNode.getChilde().computeIfAbsent(word.charAt(i), key -> new TrieNode());
			}
			thisNode.setLastChar(true);
			
		}
			
		//특정 단어가 들어있는지 확인
		boolean contains(String word) {
			TrieNode thisNode = this.root;
			
			for(int i = 0 ; i < word.length();i++) {
				char c = word.charAt(i);
				TrieNode node = thisNode.getChilde().get(c);
				
				if(node == null) {
					return false;
				}
				
				thisNode = node;
			}
			
//			해당 단어로 종료하는 문자가 있는경우중 자신과 같은 문자가 있으면 false 문자 중복이 없다.
			if(thisNode.isLastChar()) {
				if(thisNode.getChilde().isEmpty()) {
					return false;
				}
			}
			
			return true;
		}
		
	
		
		
	}
	
	
	
	
	static String num[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			num = new String[n];
			Trie trie = new Trie();
			 
			for(int j = 0 ; j < n; j++) {
				num[j] = br.readLine();
				trie.insert(num[j]);
			}
			
			if(sol(n, trie)) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
			
			
			
		}
		
		
	}
	
	public static boolean sol(int n,Trie trie) {
		
		
		for(int j = 0 ; j < n; j++) {
			if(trie.contains(num[j])) {
				System.out.println(num[j]);
				return true;
			}
		}
		

		return false;
	}
	
}
