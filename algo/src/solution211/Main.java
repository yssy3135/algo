package solution211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String tmp = st.nextToken();
	
		int n = Integer.parseInt(tmp);
		int m = tmp.length();
		
		// j의 최대값은 m이고 i의 최대값은 m-1이다
		// k번 수행
		int k = Integer.parseInt(st.nextToken());
		
		
		bfs(m,k,tmp);
		
		
		
		
		
	}
	public static void bfs(int m,int cnt,String num) {
		Queue<String> que = new LinkedList<String>();
		que.add(num);
		int chk = 0;
		
		for(int i = 0 ; i < m ;i++) {
			chk += 9*Math.pow(10, i);
		}
		
		for(int k = 0 ; k < cnt ;k++) {
			boolean visited[] = new boolean[chk+1];

			int size = que.size();
			for(int s = 0 ;s < size ;s++) {
				String str = que.poll();
				
				char[] arr = str.toCharArray();
				for(int i = 0 ; i < m-1 ; i++) {
					for(int j = i+1; j < m ;j++) {
						
						if(i == 0 && arr[j] == '0')continue;
						char tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
						
						String change =String.valueOf(arr);
						if(!visited[Integer.parseInt(change)]) {
							visited[Integer.parseInt(change)] = true;
							que.add(change);
						}
						
						tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;

					}
				}

			}
		
		}
		if(que.isEmpty()) {
			System.out.println(-1);
		}else {
			int max = 0 ;
			while(!que.isEmpty()) {
				max = Math.max(max, Integer.parseInt(que.poll()));
			}
			
			System.out.println(max);		
		}
		
		
		
		
		
	}
	
	
}
