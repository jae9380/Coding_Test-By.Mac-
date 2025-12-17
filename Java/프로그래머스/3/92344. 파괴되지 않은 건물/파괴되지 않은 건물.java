class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0, degree = 0,
        n = board.length, m = board[0].length;
        int[][] prefix = new int[n + 1][m + 1];
        
        for(int[] s : skill) {
            degree = s[0] == 1 ? -s[5] : s[5];
            
            prefix[s[1]][s[2]]          += degree;
            prefix[s[1]][s[4] + 1]      -= degree;
            prefix[s[3] + 1][s[2]]      -= degree;
            prefix[s[3] + 1][s[4] + 1]  += degree;
        }
        
        for(int i = 0; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                prefix[i][j] += prefix[i][j - 1];
            }
        }
        
        for(int i = 0; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                prefix[j][i] += prefix[j - 1][i];
            }
        }
            
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] + prefix[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}