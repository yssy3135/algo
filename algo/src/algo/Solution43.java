package algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution43 {
	static int move[] = {-1,+1,2};
	static boolean visited[];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ans = 0;
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		int cnt[] = new int[100000+1];
		

		
		Arrays.fill(cnt, 1);
		cnt[N] = 0;
		
		visited	= new boolean[100000+1];
		if(N == K) {
			System.out.println(0);
		}else{
			
			bfs(N,K,cnt);
			
			System.out.println(cnt[K]);
		}
		
		
		
		
	}
	
	public static void bfs(int N,int K,int cnt[]) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(N);
	
		while(!que.isEmpty()) {
			int now = que.poll();
			
				for(int i = 0 ; i < 3;i++) {
					int moveN = 0;
					
					if(move[i] !=2) {					
						moveN = now + move[i];
					}else if(move[i] == 2){
						moveN = now * 2;
					}
					
					if(moveN >= 0 && moveN <=100000 && !visited[moveN] ) {
						visited[moveN] =true;
						cnt[moveN] = cnt[now]+1;
						que.add(moveN);
					}
					
					
				}
			}
			
			
		}
		
		
		
	}
	
	

