class Solution {
    static int[][] check = {{1,0},{0,1},{1,1},{2,0},{0,2},{-1,1}};
    public int[] solution(String[][] places) {
        int[] answer= new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = func(places[i]);
        }

        return answer;
    }
    public static int func(String[] place) {
        char[][] map = new char[5][5];
        boolean[][] bMap=new boolean[5][5];
        for (int i = 0; i <5 ; i++) {
            map[i]=place[i].toCharArray();
            for (int j = 0; j <5; j++) {
                if (map[i][j]=='P') {
                    bMap[i][j]=true;
                }
            }
        }

        for (int i = 0; i <5; i++) {
            for (int j = 0; j <5 ; j++) {
                if (!bMap[i][j]) continue;
                for (int k = 0; k <check.length ; k++) {
                    int next_i=i+check[k][0];
                    int next_j=j+check[k][1];
                    if (next_i < 0 || next_j < 0 || next_i > 4 || next_j > 4) continue;

                    if (bMap[next_i][next_j]) {
                        if (k < 2) return 0;
                        if (k == 2) {
                            if (map[next_i][j] == 'X' && map[i][next_j] == 'X') continue;
                            return 0;
                        }
                        if (k > 2) {
                            if (k == 3 && map[next_i-1][next_j] != 'X') return 0;
                            if (k == 4 && map[next_i][next_j-1] != 'X') return 0;
                                                    if (k == 5) {
                            if (map[next_i][j] == 'X' && map[i][next_j] == 'X') continue;
                            return 0;
                        }
                        }
                    }
                }

            }
        }

        return 1;
    }
}