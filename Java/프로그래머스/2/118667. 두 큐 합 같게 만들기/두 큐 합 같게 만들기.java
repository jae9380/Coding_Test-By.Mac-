import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0, count=3*(queue1.length-1);
        long q1Sum=0, q2Sum=0;

        Queue<Long> q1 =new LinkedList<>();
        Queue<Long> q2 =new LinkedList<>();
        
        for(long num:queue1) {
            q1.add(num);
            q1Sum+=num;
        } 
        for(long num:queue2) {
            q2.add(num);
            q2Sum+=num;            
        }
        
        if((q1Sum+q2Sum)%2!=0) return -1;        
        
        while(answer<=count) {
            if(q1Sum==q2Sum) break;
            if(q1Sum>q2Sum) {
                q1Sum-=q1.peek()!=null ? q1.peek():0l;
                q2Sum+=q1.peek()!=null ? q1.peek():0l;
                q2.add(q1.poll());
            }else {
                q1Sum+=q2.peek()!=null ? q2.peek():0l;
                q2Sum-=q2.peek()!=null ? q2.peek():0l;
                q1.add(q2.poll());
            }
            answer++;
        }
        return answer>count?-1:answer;
    }
}