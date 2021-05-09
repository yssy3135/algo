package solution234;

import com.sun.deploy.util.OrderedHashSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		solution(new String[] {"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"},new int[]{2,3,4});

	}


	static class Info{
		int length;
		String word;

		public Info(int length, String word) {
			this.length = length;
			this.word = word;
		}
	}


	static boolean visited[];
	static ArrayList<Info> list;
	static public String[] solution(String[] orders, int[] course) {
		String[] answer ;
		HashSet<String> set = new HashSet<String>();
		for(int j = 0 ;j < course.length;j++){
				list = new ArrayList<Info>();
			for(int i = 0 ; i < orders.length;i++){
				visited = new boolean [orders[i].length()];
				char str[] = orders[i].toCharArray();

				combi(str.length,course[j],0,str,orders);



			}
			list.sort(new Comparator<Info>() {
				@Override
				public int compare(Info o1, Info o2) {
					return Integer.compare(o2.length,o1.length);
				}
			});

			for(int k = 0 ; k < list.size();k++){
				if(list.get(0).length == list.get(k).length){
					set.add(list.get(k).word);
				}else{
					break;
				}

			}
		}


		answer = new String[set.size()];
		set.toArray(answer);

		Arrays.sort(answer);

		return answer;
	}


	public static void combi(int n,int depth,int start,char str[],String[] orders){
		if(depth == 0){
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < str.length;i++){
				if(visited[i]){

					sb.append(str[i]);
				}
			}

			char tmp[] = sb.toString().toCharArray();

			Arrays.sort(tmp);

			isContain(String.valueOf(tmp),orders);



			return;
		}

		for(int i = start ; i < str.length;i++ ){
			if(!visited[i]){
				visited[i] = true;
				combi(n,depth-1,i+1,str,orders);
				visited[i] = false;
			}


		}


	}

	public static void isContain(String word,String[] orders){
		int cnt = 0;

		for(int i = 0 ; i< orders.length;i++){
			boolean flag = false;
			for(int j = 0 ;j  < word.length();j++){
				if(!orders[i].contains(word.substring(j,j+1))){
					flag = true;
					break;
				}
			}
			if(flag)continue;
			cnt++;
		}

		if(cnt >= 2){
			list.add(new Info(cnt,word));
		}



	}





}
