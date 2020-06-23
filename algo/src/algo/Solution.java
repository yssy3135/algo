package algo;


import java.util.Arrays;


class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        
       
        Arrays.sort(B);
        Arrays.sort(A);
        
        int len = B.length-1;
        for(int i = 0 ; i < A.length;i++) {
        	answer = answer+ (A[i]*B[len-i]);
        	
        	
        }
     
        return answer;
    }
}