import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 0, right =(long) n * times[times.length-1],
        mid = 0, passed = 0;
        
        while(left <= right) {
            mid = (left + right)/2;
            
            for(int time : times) {
                passed += mid / time;
                
                if(passed >= n) break;
            }
            
            if (passed >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            passed = 0;
        }
        return answer;
    }
}