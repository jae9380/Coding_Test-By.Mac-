import java.util.*;
class Solution{
    public int solution(String s){
        int answer = 0;
        StringBuilder sb = new StringBuilder("@");
        for(char c : s.toCharArray()) {
            sb.append(c).append('@');
        }
        char[] arr = sb.toString().toCharArray();
        int[] radius = new int[arr.length];
        int center = 0, right = 0, maxLen = 0, centerIndex = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                radius[i] = Math.min(right - i, radius[mirror]); 
            }
            while (i + (radius[i] + 1) < arr.length && i - (radius[i] + 1) >= 0
       && arr[i + (radius[i] + 1)] == arr[i - (radius[i] + 1)]) {
    radius[i]++;
}

            if (i + radius[i] > right) {
                center = i;
                right = i + radius[i];
            }

            if (radius[i] > maxLen) {
                maxLen = radius[i];
                centerIndex = i;
            }
        }
        
        return maxLen;
    }
}