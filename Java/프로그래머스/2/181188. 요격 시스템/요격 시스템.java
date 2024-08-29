import java.util.Arrays;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b) -> a[1]-b[1]);

        int interception=0;
        for (int[] target : targets) {
            if (interception>target[0]) continue;
            interception=target[1];
            answer++;

        }
        return answer;
    }
}