class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int spread = 2 * w + 1;
        int start = 1;

        for (int station : stations) {
            int left = station - w;
            if (start < left) {
                int uncovered = left - start;
                answer += (uncovered + spread - 1) / spread;
            }
            start = station + w + 1;
        }

        if (start <= n) {
            int uncovered = n - start + 1;
            answer += (uncovered + spread - 1) / spread;
        }

        return answer;
    }
}