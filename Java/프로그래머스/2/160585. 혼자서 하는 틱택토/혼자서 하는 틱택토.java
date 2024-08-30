class Solution {
    public int solution(String[] board) {
        char[][] map = new char[3][3];
        int count_o = 0, count_x = 0;

        for (int i = 0; i < 3; i++) {
            map[i] = board[i].toCharArray();
            for (char c : map[i]) {
                if (c == 'O') count_o++;
                if (c == 'X') count_x++;
            }
        }

        if (count_x > count_o || count_o > count_x + 1) return 0;

        boolean oWins = func('O', map);
        boolean xWins = func('X', map);

        if (oWins && xWins) return 0;
        if (oWins && count_o != count_x + 1) return 0;
        if (xWins && count_x != count_o) return 0;

        return 1;
    }

    private boolean func(char target, char[][] map) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == target && map[i][1] == target && map[i][2] == target) return true;
        }

        for (int i = 0; i < 3; i++) {
            if (map[0][i] == target && map[1][i] == target && map[2][i] == target) return true;
        }

        if (map[0][0] == target && map[1][1] == target && map[2][2] == target) return true;

        if (map[2][0] == target && map[1][1] == target && map[0][2] == target) return true;

        return false;
    }
}