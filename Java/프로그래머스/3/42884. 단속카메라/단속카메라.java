import java.util.Arrays;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1]-o2[1];
        });
        int startPoint = -30001;

        for (int[] route : routes) {
            if (startPoint >= route[0] && startPoint <= route[1]) continue;
            startPoint=route[1];
            answer++;
        }
        return answer;
    }
}