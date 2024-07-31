import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        char[][] map2DArr = new char[maps.length][maps[0].length()];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < maps.length; i++) {
            map2DArr[i] = maps[i].toCharArray();
        }
        
        for (int i = 0; i < map2DArr.length; i++) {
            for (int j = 0; j < map2DArr[0].length; j++) {
                if (!visited[i][j] && map2DArr[i][j] != 'X') {
                    int sum = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    
                    while (!q.isEmpty()) {
                        int[] currentIndex = q.poll();
                        int current_x = currentIndex[0], current_y = currentIndex[1];
                        sum += map2DArr[current_x][current_y] - '0';
                        
                        for (int k = 0; k < 4; k++) {
                            int new_x = current_x + directions[k][0], new_y = current_y + directions[k][1];
                            if (new_x < 0 || new_y < 0 || new_x >= map2DArr.length || new_y >= map2DArr[0].length) continue;
                            if (!visited[new_x][new_y] && map2DArr[new_x][new_y] != 'X') {
                                q.offer(new int[]{new_x, new_y});
                                visited[new_x][new_y] = true;
                            }
                        }
                    }
                    answerList.add(sum);
                }
            }
        }
        
        if (answerList.size() == 0) return new int[]{-1};
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
