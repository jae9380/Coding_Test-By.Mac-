import java.util.*;
class Solution {
    public int solution(int n, int[][] vertex) {
        List<List<Integer>> graph = buildGraph(n, vertex);

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); 
        q.offer(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int curNode = info[0], curCost = info[1];

            if (curCost > distance[curNode]) continue;

            for (int neighbor : graph.get(curNode)) {
                int newDist = curCost + 1;
                if (newDist < distance[neighbor]) {
                    distance[neighbor] = newDist;
                    q.offer(new int[]{neighbor, newDist});
                }
            }
        }
        int maxDist = 0, answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] > maxDist) {
                maxDist = distance[i];
                answer = 1;
            } else if (distance[i] == maxDist) {
                answer++;
            }
        }

        return answer;
    }

    public List<List<Integer>> buildGraph(int n, int[][] vertex) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] edge : vertex) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

}