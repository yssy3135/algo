package Solution80;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int s = sc.nextInt();
		int arr[][] = new int[s+1][s+1];
		
		for(int i = 0 ;i < arr.length; i++) {
			Arrays.fill(arr[i], -1);
		}
		arr[1][0] = 0 ;
		
//		화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
//		클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
//		화면에 있는 이모티콘 중 하나를 삭제한다.
		
		bfs(arr,s);
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0 ; i < s+1; i++) {
			if(arr[s][i] != -1) {
				ans = Math.min(ans, arr[s][i]);
			}
		}
		System.out.println(ans);
		
	}
	
	public static void bfs(int arr[][],int s) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(1);
		que.add(0);
	
		
		while(!que.isEmpty()) {
			int screen = que.poll();
			int clipboard = que.poll();
			
			// 현재 screen을 클립보드에 저장 
			if(arr[screen][screen] == -1) { // -1 이면 방문을 안한거
				arr[screen][screen] = arr[screen][clipboard]+1;
				que.add(screen);
				que.add(screen);
			}
			// 클립보드에 있는것을 스크린에 더하기
			if(screen+clipboard <= s && arr[screen+clipboard][clipboard] == -1) {
				arr[screen+clipboard][clipboard] = arr[screen][clipboard] + 1;
				que.add(screen+clipboard);
				que.add(clipboard);
			}
			// 스크린에 있는것을 하나 삭제
			if(screen-1 >=0 && arr[screen-1][clipboard] == -1) {
				arr[screen-1][clipboard] = arr[screen][clipboard] +1;
				que.add(screen -1);
				que.add(clipboard);
			}
			
			
		}
	
		
		
	}
	
	

	
	
}
