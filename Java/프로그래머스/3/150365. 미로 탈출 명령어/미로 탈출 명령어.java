class Solution {
    int[][] direction = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
    String[] dir = {"d", "l", "r", "u"};
    boolean found;
    int n, m, k, r, c;
    String answer = "impossible";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.k = k;
        this.r = r - 1;
        this.c = c - 1;
        this.n = n;
        this.m = m;
        dfs(x - 1, y - 1, "", 0);
        return answer;

    }
    private void dfs(int x, int y, String path, int depth) {
        if (found) return;
        
        int remain = k - depth;
        int dist = Math.abs(r - x) + Math.abs(c - y);
        
        if (dist > remain || (remain - dist) % 2 != 0) return;

        if (depth == k) {
            if (x == r && y == c) {
                answer = path;
                found = true;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + direction[i][1];
            int ny = y + direction[i][0];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                dfs(nx, ny, path + dir[i], depth + 1);
            }
        }
    }
}