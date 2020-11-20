package Solution66;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
	
	public static void main(String[] args) {
		String a[][] = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		solution(a);
	}
	static boolean visited[];
	static String[][] srel;
	static int answer;
    public static int solution(String[][] relation) {
    	answer = 0;
        sub = new ArrayList<ArrayList<String> >();
        //1. 조합만들기
        int arr[] = new int[relation[0].length];
        srel = relation;
        visited = new boolean[relation[0].length];
       
        for(int i = 0; i < arr.length;i++) {
        	arr[i] = i ;
        }
        
        ArrayList<Integer> set = new ArrayList<Integer>();
        for(int i = 0; i <= arr.length;i++) {
        
        	combi(arr,0,arr.length,i);
        }
        
        
        System.out.println(sub.size());
        return sub.size();
    }
    
    static ArrayList<ArrayList<String> > sub ;
    public static void combi(int arr[],int start,int n,int r) {
    	if(r == 0) {
    		ArrayList<String> list = new ArrayList<String>();
    		for(int i = 0 ; i < arr.length;i++) {
    			if(visited[i]) {
    				list.add(Integer.toString(arr[i]));
    			}
    		}
    		System.out.println(list.toString());
    		// 다른 후보키 포함 여부
    		for(int i = 0 ;i < sub.size();i++) {
    			if(list.containsAll(sub.get(i))) {
    				return ;
    			};
    		}
    		
    		// 유일성 검사
    		ArrayList<String> test = new ArrayList<String>();

    		for(int row = 0 ; row < srel.length;row++) {
    			String word = "";
    			for(int i = 0 ; i< list.size();i++) {
    				word += srel[row][Integer.parseInt(list.get(i))];
    			}
    			
    			if(test.contains(word)) {
    				System.out.println("걸림");
    				return;
    			}
    			test.add(word);
    		}
    		System.out.println("테스트"+test.toString());
    		
    		sub.add(list);
    	}
    	
    	
    	for(int i = start; i < n ;i ++) {
    		visited[i] = true;
    		combi(arr,i+1,n,r-1);
    		visited[i] = false;
    	}
    	
    	
    }
    
    
}