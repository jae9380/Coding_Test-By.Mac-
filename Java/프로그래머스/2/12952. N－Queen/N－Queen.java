class Solution {
    private static int[] map;
    private static int answer;

    public static int solution(int n) {
        map = new int[n];
        func(0, n);

        return answer;
    }
    private static void func(int depth, int n) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            map[depth] = i;
            if (func2(depth)) {
                func(depth + 1, n);
            }
        }
    }

    private static boolean func2(int i) {
        for (int j = 0; j < i; j++) {
            if (map[i] == map[j]) return false;
            if (Math.abs(i - j) == Math.abs(map[i] - map[j])) return false;
        }
        return true;
    }
}