package solution225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		String tmp[] = br.readLine().split(" ");
		
		int blockHeight[] = new int[tmp.length];
		for(int i = 0 ; i < tmp.length;i++) {
			blockHeight[i] = Integer.parseInt(tmp[i]);
		}
		
		int ans = 0;
		for(int i = 1 ; i < blockHeight.length-1;i++) {
			
			int left = 0;
			int right = 0;
			for(int j = 0; j < i; j++) {
				left = Math.max(left, blockHeight[j]);
			}
			
			for(int j = i+1; j < blockHeight.length; j++) {
				right = Math.max(right, blockHeight[j]);
			}
			
			System.out.println("왼쪽"+left+"오른쪽"+right+"나"+blockHeight[i]);
			
			if(left <blockHeight[i] || right<blockHeight[i])continue;
			if(left == 0 || right == 0 )continue;
			
			ans += Math.min(left, right)-blockHeight[i];
		
		}
		
		System.out.println(ans);
		
		
	}
}
