import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if (s<n) return new int[]{-1};
        
        int share=s/n;
        int[] answer=new int[n];
        Arrays.fill(answer, share);
        for(int i=0;i<=s%n-1;i++) {
            answer[n-1-i] += 1;
        }
        return answer;
    }
}