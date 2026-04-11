import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int first = Integer.parseInt(br.readLine());
        int[][] map = new int[3][3];

        int winner = 0;

        for (int t = 0; t < 9; t++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int player;
            if ((t % 2 == 0 && first == 1) || (t % 2 == 1 && first == 2)) {
                player = 1;
            } else player = 2;
            map[x - 1][y - 1] = player;
            if (t >= 4) {
                winner = checkWinner(map);
                if (winner != 0) break;
            }
        }

        System.out.println(winner);
    }

    static int checkWinner(int[][] map) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] != 0 &&
                map[i][0] == map[i][1] &&
                map[i][1] == map[i][2]) {
                return map[i][0];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (map[0][i] != 0 &&
                map[0][i] == map[1][i] &&
                map[1][i] == map[2][i]) {
                return map[0][i];
            }
        }
        if (map[0][0] != 0 &&
            map[0][0] == map[1][1] &&
            map[1][1] == map[2][2]) {
            return map[0][0];
        }
        if (map[0][2] != 0 &&
            map[0][2] == map[1][1] &&
            map[1][1] == map[2][0]) {
            return map[0][2];
        }
        return 0;
    }
}