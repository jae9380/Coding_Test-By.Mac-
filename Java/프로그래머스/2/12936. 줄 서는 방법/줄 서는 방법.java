import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> tail = new ArrayList<>();
        long factorial = 1;
        int index = 0;
        --k;
        for(int i=1; i<=n; i++) {
            factorial*=i;
            tail.add(i);
        }
        while(n > 0) {
            factorial /= n;
            int value = (int)(k / factorial);
            k%=factorial;
            n--;
            answer[index++] = tail.get(value);
            tail.remove(value);
        }
        return answer;
    }
}