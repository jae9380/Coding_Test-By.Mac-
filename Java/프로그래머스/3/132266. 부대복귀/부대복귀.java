import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
    int[] answer = new int[sources.length];
    
    List<List<Integer>> map = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
        map.add(new ArrayList<>());
    }
    for (int[] road : roads) {
        int nodeA = road[0], nodeB = road[1];
        map.get(nodeA).add(nodeB);
        map.get(nodeB).add(nodeA);
    }

    int[] minDistance = new int[n + 1];
    Arrays.fill(minDistance, -1);
    Queue<Integer> q = new LinkedList<>();
    q.offer(destination);
    minDistance[destination] = 0;

    while (!q.isEmpty()) {
        int node = q.poll();
        for (Integer neighbor : map.get(node)) {
            if (minDistance[neighbor] == -1) {
                minDistance[neighbor] = minDistance[node] + 1;
                q.offer(neighbor);
            }
        }
    }
    for (int i = 0; i < sources.length; i++) {
        answer[i] = minDistance[sources[i]];
    }

    return answer;
    }
}