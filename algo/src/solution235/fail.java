package solution235;
import java.util.*;

public class fail {


    static Map<String, ArrayList<Integer>> map;
    static boolean visited[];
    public static int[] solution(String[] info, String[] query) {
        int[] answer ;

        map = new HashMap<String,ArrayList<Integer>>();


        for(int i = 0 ;i  < info.length;i++){
            for(int j = 0 ; j < info[i].length()-1;j++){
                String select[] = info[i].split(" ");
                visited = new boolean[select.length];
                combi(info[i].length(),j,0,select);
            }
        }

        answer = new int[query.length];

        for(int i = 0 ; i< query.length;i++){
            String isoQuery = query[i].replace("and","");
            String sQuery[] = isoQuery.replace("  ","").split(" ");

            int criterion = Integer.parseInt(sQuery[1]);


            if(!map.containsKey(sQuery[0])){
                answer[i] = 0;
            }else{
                ArrayList<Integer> score = map.get(sQuery[0]);

                score.sort(null);


                int start = 0;
                int end = score.size()-1;
                int mid = (start+end)/2;

                while(start<=end){
                    mid = (start+end)/2;

                    if(score.get(mid) < criterion){
                        start = mid+1;
                    }else{
                        end = mid-1;

                    }
                }
                answer[i] = score.size()-start;

            }

        }


        return answer;
    }

    public static void combi(int n ,int depth,int start,String str[]){

        if(depth == 0){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < str.length-1;i++){
                if(visited[i]){
                    sb.append(str[i]);
                }else{
                    sb.append("-");
                }
            }
            int score = Integer.parseInt(str[4]);

            if(map.containsKey(sb.toString())){{
                map.get(sb.toString()).add(score);
            }}else{
                map.computeIfAbsent(sb.toString(), s -> new ArrayList<Integer>()).add(score);
            }

            return ;
        }

        for(int i = start ; i < str.length-1;i++){
            if(!visited[i]){
                visited[i] = true;
                combi(n,depth-1,i+1,str);
                visited[i] = false;
            }
        }

    }
}
