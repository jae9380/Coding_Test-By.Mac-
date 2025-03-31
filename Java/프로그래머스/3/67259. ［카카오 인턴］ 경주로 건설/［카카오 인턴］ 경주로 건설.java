import java.util.*;

class Solution {
    private int[][] direction = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    private int[][][] costMap;
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        int range = board.length;

        costMap = new int[range][range][4];

        for (int[][] ints : costMap) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, answer);
            }
        }

        for (int i = 0; i < 4; i++) {
            Arrays.fill(costMap[0][0], 0);
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0, -1, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int curX = current[0], curY = current[1], curD = current[2], curC = current[3];

            for (int i = 0; i <4 ; i++) {
                int nexX = curX + direction[i][0], nexY = curY + direction[i][1], newC;

                if (nexX >= range || nexY >= range || nexX < 0 || nexY < 0 || board[nexX][nexY] == 1) continue;

                if (i == curD || curD == -1) {
                    newC = curC + 100;
                }else {
                    newC = curC + 600;
                }

                if (costMap[nexX][nexY][i] > newC) {
                    costMap[nexX][nexY][i] = newC;
                    q.offer(new int[]{nexX, nexY, i, newC});
                }
            }
        }

        for (int i : costMap[range - 1][range - 1]) {
            answer = answer > i ? i : answer;
        }
        return answer;
    }
}