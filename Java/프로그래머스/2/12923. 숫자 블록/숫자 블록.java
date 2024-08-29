import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
        int[] answer= new int[(int)(end-begin)+1];
        int index=0;
        for (int i = (int)begin; i <= end; i++) {
            answer[index++] = func(i);
        }
        return answer;
    }

    private static int func(int x) {
        if (x == 1) return 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                list.add(i);
                if (x / i <= 10000000) return x/i;
            }
        }
        if (!list.isEmpty()) return list.get(list.size() - 1);
        return 1;
    }
}