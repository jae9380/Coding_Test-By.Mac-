import java.util.*;

class Solution {
    Map<String, Integer> hashMap;
    List<String> answerList;

    public String[] solution(String[] orders, int[] course) {
        answerList = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for (int num : course) {
            hashMap = new HashMap<>();
            for (String order : orders) {
                combination("", order, num, 0);
            }

            if (!hashMap.isEmpty()) {
                List<Integer> countList = new ArrayList<>(hashMap.values());
                int maxCount = Collections.max(countList);

                if (maxCount > 1) {
                    for (String key : hashMap.keySet()) {
                        if (hashMap.get(key) == maxCount) {
                            answerList.add(key);
                        }
                    }
                }
            }
        }

        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    public void combination(String current, String order, int length, int start) {
        if (current.length() == length) {
            hashMap.put(current, hashMap.getOrDefault(current, 0) + 1);
            return;
        }
        for (int i = start; i < order.length(); i++) {
            combination(current + order.charAt(i), order, length, i + 1);
        }
    }
}