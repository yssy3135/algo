package solution238;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        solution("02:03:55","00:14:15",new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
        
    }

    //1.단위 시간별시청 누적 시간 구하기
    //2.

    static int timeCnt[];
    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int startLogs[] = new int[logs.length];
        int endLogs[] = new int[logs.length];
        
        int play_time_sec = timeToSecond(play_time);
        int adv_time_sec = timeToSecond(adv_time);
        
        int max = 0;

        
        timeCnt = new int[timeToSecond("99:59:59")+1];

        //시각에 저장된 재생 구간의 개수 , 종료된 재생 구간의 개수
        for(int i = 0 ; i < logs.length;i++){
            String log[] = logs[i].split("-");
            startLogs[i] = timeToSecond(log[0]);
            endLogs[i] = timeToSecond(log[1]);

            timeCnt[startLogs[i]] = timeCnt[startLogs[i]]+1;
            timeCnt[endLogs[i]] = timeCnt[endLogs[i]]-1;
        }

        //시간 i부터 i+1까지 1초간의 구간을 포함하는 재생 구간의 개수
        for(int i = 1 ; i < play_time_sec ;i++){
            timeCnt[i]  =  timeCnt[i] + timeCnt[i-1];
        }


        //시간 i부터 i+1까지 1초간의 구간을 포함하는 누적 재생시간
        for(int i = 1 ; i < play_time_sec ;i++){
            timeCnt[i]  =  timeCnt[i] + timeCnt[i-1];
        }

        long maxsum = timeCnt[adv_time_sec];
        int maxIdx = 0;
        for(int i = adv_time_sec; i < play_time_sec;i++){
            int cur = timeCnt[i]-timeCnt[i-adv_time_sec];
            if(maxsum < cur){
                maxsum = cur;
                maxIdx = i-adv_time_sec+1;
            }
        }



        System.out.println(String.format("%02d:%02d:%02d",maxIdx/3600,maxIdx/60%60,maxIdx%60));

        answer = String.format("%02d:%02d:%02d",maxIdx/3600,maxIdx/60%60,maxIdx%60);

        
        return answer;
    }
    
    
    public static int timeToSecond(String getTime){
         String time[] = getTime.split(":");
        
         String hour = time[0];
         String min = time[1];
         String sec = time[2];
         //시간은 *3600 
        //분은 *60
        
        int totalSec = (Integer.parseInt(hour)*3600)+(Integer.parseInt(min)*60)+Integer.parseInt(sec);
         
        return totalSec; 
    }
}
