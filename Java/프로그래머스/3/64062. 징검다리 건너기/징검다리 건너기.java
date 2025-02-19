import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0, low = 1, high = Arrays.stream(stones).max().getAsInt();
        while (low <= high) { 
            int mid = (low + high) / 2;
            if (canCross(stones, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        answer = high;
        return answer;
    }

    private boolean canCross(int[] stones, int k, int mid) {
        int count = 0;
        for (int stone : stones) {
            if (stone - mid < 0) {
                count++;
                if (count >= k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        return true;
    }
}