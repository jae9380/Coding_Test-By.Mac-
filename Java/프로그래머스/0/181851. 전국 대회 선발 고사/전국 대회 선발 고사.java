import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        Map<Integer, Integer> total = new HashMap<>();
        for(int i = 0; i < attendance.length; i++) {
            if(attendance[i] == true) {
                total.put(rank[i], i);
            }
        }
        List<Integer> keySet = new ArrayList<>(total.keySet());
        Collections.sort(keySet);
        int[] inThird = keySet.stream().mapToInt(Integer::intValue).toArray();

        answer = (10000 * total.get(inThird[0]) ) + (100 * total.get(inThird[1])) + total.get(inThird[2]);
        
        return answer;
    }
}