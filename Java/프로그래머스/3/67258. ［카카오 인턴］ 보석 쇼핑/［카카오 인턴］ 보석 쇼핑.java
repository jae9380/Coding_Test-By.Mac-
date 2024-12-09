import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        int startIndex = 0, endIndex = 0;
        int[] answer = new int[2];
        for (int i = 0; i < gems.length; i++) {
            if (!map.containsKey(gems[i])) {
                map.put(gems[i], i);
                endIndex = i;
                answer = new int[] { startIndex + 1, endIndex + 1 };
            } else {
                map.put(gems[i], i);
                endIndex = i;
                if (gems[startIndex].equals(gems[i])) {
                    startIndex = getMinIndex(map);
                    if (answer[1] - answer[0] > endIndex - startIndex) {
                        answer = new int[] { startIndex + 1, endIndex + 1 };
                    }
                }
            }
        }
        return answer;
    }
        private int getMinIndex(Map<String, Integer> map) {
        int min = 100001;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            min = Math.min(min, entry.getValue());
        }
        return min == 100001 ? 0 : min;
    }
}