import java.util.*;
class Solution {
    static List<int[]>hanoi;
    public int[][] solution(int n) {
        hanoi=new ArrayList<>();
        func(n,1,2,3);
        int[][] answer = hanoi.stream()
                .toArray(int[][]::new);
        return answer;
    }
    private static void func(int n, int start, int middle, int end) {
        if(n==0) return;
        func(n-1,start,end,middle);
        hanoi.add(new int[]{start,end});
        func(n-1,middle,start,end);
    }
}