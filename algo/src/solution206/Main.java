package solution206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean selected[];
	static int result[][];
	static int player[];
	static int ans = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		result = new int[n][9];
		player = new int[9];
		
		for(int i = 0 ; i < n;i++) {
			String tmp[] = br.readLine().split(" ");
			for(int j = 0 ; j < tmp.length;j++) {
				result[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		selected = new boolean[9];
		
		selected[3] = true;
		player[3] = 0;
		
		permuitation(1, n);
		System.out.println(ans);
		

		

	}
	
	public static void permuitation(int dept,int n) {
		if(dept == 9) {
			
			play(n);
			return;
		}
		
		
		for(int i = 0 ; i < 9;i++) {
			if(!selected[i]) {
				selected[i] = true;
				player[i] =dept ; 
				permuitation(dept+1,n);
				selected[i] = false;
			}
			
		}
	}
	
	public static void play(int n) {

		int score = 0;
		int first = 0;
		int j = 0;
		for(int i = 0 ; i < n; i++) {
			int outcnt = 0;
			boolean base[] = new boolean[3]; 
		
	
			while(true) {
		
				//이닝 시작
					
					if(result[i][player[j]] == 0) {
						outcnt++;
					}else if(result[i][player[j]] == 1) {
		//					j번선수 근데 0번선수는 4번타자
						for(int b = 2 ; b >= 0 ;b--) {
							if(base[b] ) {
								if(b==2) {
									
									base[b] = false;
									score++;
								}else {
									
									base[b] = false;
									base[b+1] = true;
								}
							}
						}
					
						base[0] = true;
						
					}else if(result[i][player[j]] == 2) {
						
						for(int b = 2 ; b >= 0 ;b--) {
							if(base[b]  ) {
								
								if(b==2 || b ==1) {
									
									base[b] = false;
									score++;
								}else {
									base[b] = false;
									base[b+2] = true;
									
								}
								
							}
						}
					
						base[1] = true;
						
					}else if(result[i][player[j]] == 3) {
						
						for(int b = 2 ; b >= 0 ;b--) {
							if(base[b]) {
								
								base[b] = false;
								score++;
							}
		
						}
					
						base[2] = true;
						
					}else if(result[i][player[j]] == 4) {
						for(int b = 2 ; b >= 0 ;b--) {
							if(base[b]) {
								
								base[b] = false;
								score++;
							}
		
						}
						score++;
					}
					
					j = (j+1)%9;
					if(outcnt == 3) {
						
						break;
					}
					
				}
				
				
				
	
			}
		
	
		ans = Math.max(ans,score);
		
		
	}
	
	
	
	
}
