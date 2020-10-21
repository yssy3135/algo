package Solution46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean visited[];
	static StringBuilder sb;
	static String ans;
	static ArrayList<String> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int L = sc.nextInt();
		int C = sc.nextInt();
		
		String arr[] = new String[C];
		visited = new boolean[C];
		ans = "";
		list = new ArrayList<String>();
		for(int i = 0 ; i< C;i++) {
			arr[i] = sc.next();
		}
		Arrays.sort(arr);
		combi(arr,visited,0,L,C);
		
	}
	
	public static void combi(String[] arr, boolean visited[],int start,int r,int n) {
		if(r==0) {
			sb = new StringBuilder();
			int cntmo = 0;
			int cntja = 0;
			for(int i = 0 ; i< n ; i++) {
				if(visited[i]) {
					
					sb.append(arr[i]);
					
					if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
						cntmo++;
					}else {
						cntja++;
					}
				}
			}
			// 한개의 모음과 두개의 자음
			
			if(cntmo>=1 && cntja >=2) {
				ans = sb.toString();
				System.out.println(sb.toString());
			}

			
		}
		
		for(int i = start; i< n ;i++) {
			visited[i] = true;
			combi(arr,visited,i+1,r-1,n);
			visited[i] = false;
			
		}
		
		
		
	}
	
	
}
