package Solution77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> house;
	static boolean visited[];
	static ArrayList<String> chickennum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//r과c는 1부터 시작한다.
		// 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리
		// 도시의 치킨거리는 모든집의 치킨거리의 합
		chicken = new ArrayList<int[]>();
		house = new ArrayList<int[]>();
		chickennum = new ArrayList<String>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		int city[][] = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			
			for(int j =0 ; j < n; j++) {
				city[i][j] = sc.nextInt();
			}
		}

		
		// 0은빈칸 1은집 2는 치킨집 집의 개수는 2N개를 넘지않으며 적어도 1개는 존재한다
		// 치킨집의 개수는 M보다 크거나 같고 13보다 작거나 같다.
		// 임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.
		
		
		for(int i = 0 ; i < n ; i++) {
			for(int j =0 ; j < n; j++) {
				if(city[i][j] == 1) {
					house.add(new int[]{i+1,j+1});
				}else if(city[i][j] == 2) {
					chicken.add(new int[] {i+1,j+1});
				}
			}
		}
		
		visited = new boolean[chicken.size()];
	
		combi(0,m,chicken.size()-1);
		
		int ans = 9999;
		for(int i = 0 ; i < house.size(); i++) {
			ans = Math.min(distance(house.get(i)[0],house.get(i)[1]),ans);
		}
	
		System.out.println(ans);
		

	}
	
	
	// 모든 집의 치킨거리를 구해야한다. 조합을 구해서 주어진 M개를 돌려 가장 최소 한의 개수를 구한다.
	public static int distance(int i , int j) {

		
		int abs = 0;
		for(int q = 0 ; q < chickennum.size();q++) {
			String num =chickennum.get(q);
			String tmp[] = num.split("");
			for(int z = 0 ; z < chickennum.get(q).length(); z++) {
				int absi = Math.abs(chicken.get(Integer.parseInt(tmp[z]))[0]-i);
				int absj = Math.abs(chicken.get(Integer.parseInt(tmp[z]))[1]-j);
				abs += absi+absj;
			}
		}
		System.out.println("최소값"+abs);
		
		return abs;
		
	}
	
	public static void combi(int start,int m,int max) {

		if(m == 0) {	
			StringBuilder sb= new StringBuilder();
			for(int i = 0 ; i < max ;i ++) {
				if(visited[i]) {
					System.out.print(chicken.get(i)[0]+" "+chicken.get(i)[1]);
					System.out.print(", ");
					sb.append(i);
					
				}
				
			}
			chickennum.add(sb.toString());
			System.out.println();
			
//			System.out.println(ans);
			
		}
		
		for(int i = start ; i < max ; i++) {
			visited[i] = true;
			combi(i+1,m-1,max);
			visited[i] = false;
		}
		
	}
	
	
	
	
	
}
