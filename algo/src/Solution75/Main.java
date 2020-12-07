package Solution75;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String wheel[] = new String[4];
		int ans = 0;
		for(int i = 0 ;i  < wheel.length;i++) {
			wheel[i] = sc.next();
		}
		
		int times = sc.nextInt();
		
		int spin[][] = new int[times][2];
		for(int i = 0 ; i < times; i++) {
			spin[i][0] = sc.nextInt();  //회전 바퀴번호
			spin[i][1] = sc.nextInt();  //회전 방향
		}
		
		for(int i = 0 ; i < times; i++) {
			int wheelnum = spin[i][0];
			int way = spin[i][1];
			
			System.out.println(wheel[wheelnum-1]);
			String pole = "";
			
			pole = rotate(wheel, way, wheelnum);
			wheel[wheelnum-1] = pole;
			
			// 인근 -1,+1 인 바퀴와 비교해서 회전시켜야함 
			
			if(wheelnum == 0 ) {
				if(!wheel[wheelnum].substring(6, 7).equals(wheel[wheelnum-1].substring(2, 3))) {
					String pole2 = rotate(wheel,way == 0 ? 1 : 0,wheelnum);
				}
				
			}else if (wheelnum == 1) {
				
			}else if (wheelnum == 2) {
				
			}else if (wheelnum == 3) {
				
			}

		}
		System.out.println("------------------------");
		for(int i = 0 ;i  < wheel.length;i++) {
			System.out.println(wheel[i]);
		}
		
		for(int i = 0 ; i < wheel.length;i++) {
			String twelve = wheel[i].substring(0, 1);
			
			if(i == 0) {
				if(twelve.equals("0")) {
					continue;
				}else {
					ans += 1;
				}
			}else if(i == 1) {
				if(twelve.equals("0")) {
					continue;
				}else {
					ans += 2;
				}
				
			}else if(i == 2) {
				if(twelve.equals("0")) {
					continue;
				}else {
					ans += 4;
				}
			}else if(i == 3) {
				if(twelve.equals("0")) {
					continue;
				}else {
					ans += 8;
				}
			}
			
			
		}
		
		System.out.println(ans);
		
	}
	
	public static String rotate(String wheel[],int way,int wheelnum) {
		String pole = "";
		if(way == 1) { //시계방향 회전 (맨뒤 것을 맨 앞으로 붙힌다.)
			String last = wheel[wheelnum-1].substring(wheel[wheelnum-1].length()-1, wheel[wheelnum-1].length());
			pole = wheel[wheelnum-1].substring(0,wheel[wheelnum-1].length()-1);
			pole = last+pole;
			System.out.println(pole+"회전");
		}else {// 반시계방향 회전(맨앞것을 맨뒤로)
			String first = wheel[wheelnum-1].substring(0,1);
			pole = wheel[wheelnum-1].substring(1,wheel[wheelnum-1].length());
			pole = pole+first;
			System.out.println(pole+"회전");
		}
		return pole;
	}
	
	
}



//N극이 0 S극은 1 12시방향부터 5줄에 회전횟수
