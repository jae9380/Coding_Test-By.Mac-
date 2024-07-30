import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcd_A = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcd_A = gcd(gcd_A, arrayA[i]);
        }
        int gcd_B = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcd_B = gcd(gcd_B, arrayB[i]);
        }
        int answer = 0;
        boolean validA = true;
        for (int num : arrayB) {
            if (num % gcd_A == 0) {
                validA = false;
                break;
            }
        }
        if (validA) {
            answer = Math.max(answer, gcd_A);
        }
        boolean validB = true;
        for (int num : arrayA) {
            if (num % gcd_B == 0) {
                validB = false;
                break;
            }
        }
        if (validB) {
            answer = Math.max(answer, gcd_B);
        }

        return answer;
    }
    private int gcd(int a, int b) {
        if(a%b==0) return b;
        return gcd(b,a%b);
    }
}
