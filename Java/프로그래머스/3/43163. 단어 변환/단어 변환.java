import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!hasTarget(words, target)) return 0;

        int answer=0;
        boolean[] visited=new boolean[words.length];
        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{begin,answer});

        while (!q.isEmpty()) {
            Object[] current=q.poll();
            String word = (String)current[0];
            int count = (int)current[1];
            if (word.equals(target)) return count;

            for (int i = 0; i < words.length; i++) {
                if (!visited[i]&&check((String)current[0],words[i])) {
                    q.add(new Object[]{words[i], count+1});
                    visited[i]=true;
                }
            }
        }
        return answer;
    }

    static boolean hasTarget(String[] words, String target) {
        for (String word : words) {
            if (word.equals(target)) return true;
        }
        return false;
    }
    
    static boolean check(String str1, String str2) {
        int count=0;
        for (int i = 0; i <str1.length() ; i++) {
            if (str1.charAt(i)!=str2.charAt(i)) count++;
        }
        return count==1 ? true:false;
    }
}