package Solution81;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static class CCTV{
		int ctx;
		int cty;
		int type;
		public CCTV() {
			this.ctx = -1;
			this.cty = -1;
			this.type = -1;
		}
		
		
	}
	static int n;
	static int m;
	static int[] way;
	static boolean[] visited;
	static int office[][];
	static int wall;
	static Map<String, Integer> dup;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		way = new int[]{1,2,3,4};
		visited = new boolean[4];
		office = new int[n][m];
		dup = new HashMap<String,Integer>();
		
		ArrayList<CCTV> cctv = new ArrayList<CCTV>();
		

		for(int i = 0 ;i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				int num = sc.nextInt();
				office[i][j] =num;
				if(num >= 1 && num <=5) {
					CCTV c = new CCTV();
					c.type = office[i][j];
					c.ctx = i;
					c.cty = j;
					
					cctv.add(c);
				}else if (num == 6) {
					wall++;
				}
			}
		}
		
		 detect(cctv);
		
		
	}
	
	public static void detect(ArrayList<CCTV> cctv) {
		
		int sum = 0;
		
		
		

		for(int i = 0; i < cctv.size(); i++) {
			CCTV cam = cctv.get(i);
			int type = cam.type;
			
			if(type == 1) {
				//y++,x++.y--.x--
				int map[][] = office;
				int cnt = 0;
				for(int j = 0 ; j < 4 ; j++) {
					if(j == 0 ) {
						cnt = Math.max(cnt, left(cam.ctx,cam.cty,type,map));
//						System.out.println("칸수"+ left(cam.ctx,cam.cty,type) +"타입 "+type+"왼족");
					}else if(j == 1) {
						cnt = Math.max(cnt, right(cam.ctx,cam.cty,type,map));
//						System.out.println("칸수"+right(cam.ctx,cam.cty,type) +"타입 "+type+"오른");

					}else if(j == 2) {
						cnt = Math.max(cnt, up(cam.ctx,cam.cty,type,map));
//						System.out.println("칸수"+up(cam.ctx,cam.cty,type) +"타입 "+type+"위");
					}else if(j == 3) {
						cnt = Math.max(cnt, down(cam.ctx,cam.cty,type,map));
//						System.out.println("칸수"+down(cam.ctx,cam.cty,type) +"타입 "+type+"아래");
					}
				}
				System.out.println("칸수"+cnt +"타입 "+type);
				sum += cnt;
			}else if (type ==2) {
				//y--,y++
				int cnt = 0;
				int map[][] = office;
				for(int j = 0 ; j <2; j++) {
					if( j == 0) {
						cnt = Math.max(cnt,left(cam.ctx,cam.cty,type,map)+right(cam.ctx,cam.cty,type,map));
					}else if( j == 1) {
						cnt = Math.max(cnt, up(cam.ctx,cam.cty,type,map)+down(cam.ctx,cam.cty,type,map));
					}
					System.out.println("칸수"+cnt +"타입 "+type+"테스트"+cam.ctx+"ctx"+cam.cty);
				}
				sum += cnt;
			}else if(type == 3) {
				//y++,x++.y--.x--
				int cnt = 0;
				int map[][] = office;
				for(int j = 0 ; j < 4 ; j++) {
					if(j == 0 ) {
						cnt = Math.max(cnt, left(cam.ctx,cam.cty,type,map) + down(cam.ctx,cam.cty,type,map));
					}else if(j == 1) {
						cnt = Math.max(cnt, right(cam.ctx,cam.cty,type,map)+ down(cam.ctx,cam.cty,type,map));
					}else if(j == 2) {
						cnt = Math.max(cnt, up(cam.ctx,cam.cty,type,map) +  right(cam.ctx,cam.cty,type,map));
					}else if(j == 3) {
						cnt = Math.max(cnt, up(cam.ctx,cam.cty,type,map) +  left(cam.ctx,cam.cty,type,map));
					}
				}
				System.out.println("칸수"+cnt +"타입 "+type);
				sum += cnt;
			}else if (type ==4) {
				int cnt = 0;
				int map[][] = office;
				for(int j = 0 ; j <2; j++) {
					if( j == 0) {
						cnt = Math.max(cnt, left(cam.ctx,cam.cty,type,map)+ right(cam.ctx,cam.cty,type,map) + down(cam.ctx,cam.cty,type,map));
					}else if( j == 1) {
						cnt = Math.max(cnt, left(cam.ctx,cam.cty,type,map)+ right(cam.ctx,cam.cty,type,map)+ up(cam.ctx,cam.cty,type,map));
					}
				}
				System.out.println("칸수"+cnt +"타입 "+type);
				sum += cnt;
			}else if (type ==5) {
				int cnt = 0;
				int map[][] = office;
				cnt += left(cam.ctx,cam.cty,type,map);
				cnt += right(cam.ctx,cam.cty,type,map);
				cnt += up(cam.ctx,cam.cty,type,map);
				cnt += down(cam.ctx,cam.cty,type,map);
					
				System.out.println("칸수"+cnt +"타입 "+type);
				sum += cnt;
			}
			
			
			System.out.println(Arrays.deepToString(office));
			
			
		}
		int ans = n*m;
		System.out.println("칸수합"+sum);
		System.out.println(ans-(sum));
		
	}
	
	
	public static int right(int x,int y,int type,int office[][]) {
		int cnt = 0;
		y= y+1;
		for(int i = 0 ; i < m; i++) {
			if(y<m &&office[x][y] == 0) {
				office[x][y] = 9;
				y++;
				cnt++;
			}else {
				break;
			}
		}
		return cnt;
		
	}
	public static int left(int x,int y,int type,int office[][]) {
		int cnt = 0;
		y= y-1;
		for(int i = 0 ; i < m; i++) {
			if(y>-1 &&office[x][y] == 0) {
				office[x][y] = 9;
				y--;
				cnt++;
			}else {
				break;
			}
		}
		return cnt;
	}
	
	public static int up(int x,int y,int type,int office[][]) {
		int cnt = 0;
		x= x-1;
		for(int i = 0 ; i < n; i++) {
			if(x>-1 &&office[x][y] == 0) {
				office[x][y] = 9;
				x--;
				cnt++;
			}else {
				break;
			}
		}
		return cnt;
	}
	public static int down(int x,int y,int type,int office[][]) {
		int cnt = 0;
		x= x+1;
		for(int i = 0 ; i < n; i++) {
			if(x<n &&office[x][y] == 0) {
				office[x][y] = 9;
				x++;
				cnt++;
			}else {
				break;
			}
		}
		return cnt;
		
	}
	
}
