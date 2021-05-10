package solution235;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		String info[] = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
		String query[] = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};


		solution(info, query);
	}

	static Map<String, ArrayList<Integer>> map;
	static boolean visited[];
	static ArrayList<Integer> score;
	public static int[] solution(String[] info, String[] query) {
		int[] answer ;

		map = new HashMap<String,ArrayList<Integer>>();


		for(int i = 0 ;i  < info.length;i++){
			combi(4,0,info[i].split(" "),"");
		}

		answer = new int[query.length];

		Iterator<Map.Entry<String, ArrayList<Integer>>> iter = map.entrySet().iterator();
		while(iter.hasNext()){
			iter.next().getValue().sort(null);
		}




		for(int i = 0 ; i< query.length;i++){
			String isoQuery = query[i].replace(" and ","");
			String sQuery[] = isoQuery.split(" ");
			int criterion = Integer.parseInt(sQuery[1]);

			String str = sQuery[0];

			ArrayList<Integer> score = map.get(str);

			if(!map.containsKey(str)){
				answer[i] = 0;
			}else{

				int start = 0;
				int end = score.size()-1;


				while(start<=end){
					int mid = (start+end)/2;

					if(score.get(mid) < criterion){
						start = mid+1;
					}else{
						//크거나 같은 숫자가 처음 나타나는 위치
						end = mid-1;
					}
				}
				answer[i] = score.size()-start;
			}

		}



		return answer;
	}

	public static void combi(int n ,int depth,String str[],String strCombi){

		if(depth == n ){

			int score = Integer.parseInt(str[4]);

			if(map.containsKey(strCombi)){{
				map.get(strCombi).add(score);
			}}else{
				map.computeIfAbsent(strCombi, s -> new ArrayList<Integer>()).add(score);
			}

			return;
		}

		combi(n,depth+1,str,strCombi.concat(str[depth]));
		combi(n,depth+1,str,strCombi.concat("-"));
	}




}
