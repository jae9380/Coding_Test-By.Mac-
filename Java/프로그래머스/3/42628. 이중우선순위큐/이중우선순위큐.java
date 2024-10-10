import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String operation : operations) {
            String[] options = operation.split(" ");

            if (options[0].equals("I")) {
                int number = Integer.parseInt(options[1]);
                map.put(number, map.getOrDefault(number, 0) + 1);
            } else if (options[0].equals("D")) {
                if (map.isEmpty()) continue;

                if (options[1].equals("1")) {
                    int maxKey = map.lastKey();
                    if (map.get(maxKey) == 1) map.remove(maxKey);
                    else map.put(maxKey, map.get(maxKey) - 1);
                } else if (options[1].equals("-1")) {
                    int minKey = map.firstKey();
                    if (map.get(minKey) == 1) map.remove(minKey);
                    else map.put(minKey, map.get(minKey) - 1);
                }
            }
        }

        if (map.isEmpty()) return new int[]{0, 0};
        return new int[]{map.lastKey(), map.firstKey()};
    }
}