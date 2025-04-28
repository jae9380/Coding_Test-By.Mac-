class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] gameRecord = new int[n][n];

        for (int i = 0; i < results.length; i++) {
            gameRecord[results[i][0] - 1][results[i][1] - 1] = 1;
            gameRecord[results[i][1] - 1][results[i][0] - 1] = -1;
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (gameRecord[i][k] == 1 && gameRecord[k][j] == 1) {
                        gameRecord[i][j] = 1;
                        gameRecord[j][i] = -1;
                    }
                    if (gameRecord[i][k] == -1 && gameRecord[k][j] == -1) {
                        gameRecord[i][j] = -1;
                        gameRecord[j][i] = 1;
                    }
                }
            }
        }
            int count = 0;
        for (int[] ints : gameRecord) {
            for (int i : ints) {
                if (i != 0) count++;
            }
            if (count == n - 1) {
                answer++;
            }
            count = 0;
        }
        return answer;
    }
}