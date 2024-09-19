import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[][] range;
    public int[] solution(int m, int n, int[][] picture) {
        visited=new boolean[m][n];
        range = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int numberOfArea = 0, maxSizeOfOneArea = 0;

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (!visited[i][j]&&picture[i][j]!=0) {
                    int size=bfs(i,j,picture,picture[i][j]);
                    numberOfArea++;
                    maxSizeOfOneArea= maxSizeOfOneArea<size ? size : maxSizeOfOneArea;
                }

            }

        }
        return new int[]{numberOfArea,maxSizeOfOneArea};
    }

    public int bfs(int x, int y, int[][]picture, int target) {

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        int count = 1;
        visited[x][y]=true;
        while (!q.isEmpty()) {
            int[] index = q.remove();
            for (int[] ints : range) {
                int nx=index[0]+ints[0],ny=index[1]+ints[1];
                if (nx<0 || nx>=picture.length || ny<0 || ny>= picture[0].length) continue;

                if (!visited[nx][ny] && picture[nx][ny] == target) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }

        }
        return count;
    }
}