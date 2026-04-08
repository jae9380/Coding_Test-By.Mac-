import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] fare : fares) {
            int sNode = fare[0] - 1, eNode = fare[1] - 1, cost = fare[2];

            graph.get(sNode).add(new int[]{eNode, cost});
            graph.get(eNode).add(new int[]{sNode, cost});
        }
        int[] distance = new int[n], node = new int[] {s, a, b};
        int[][] distances = new int[3][n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < node.length; i++) {
            Arrays.fill(distance, Integer.MAX_VALUE);
            PriorityQueue<int[]> pq = new PriorityQueue<>((node1, node2) -> Integer.compare(node1[1], node2[1]));
            distance[node[i]-1] = 0;
            pq.add(new int[]{node[i]-1,0});
            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int currentNode = current[0], currentCost = current[1];
                if (currentCost > distance[currentNode]) continue;

                for (int[] ints : graph.get(currentNode)) {
                    int newDist = currentCost + ints[1];
                    if (newDist < distance[ints[0]]) {
                        distance[ints[0]] = newDist;
                        pq.add(new int[]{ints[0], newDist});
                    }
                }
            }
            distances[i] = Arrays.copyOf(distance, n);
        }
        int straight = distances[0][a-1] + distances[0][b-1], midpoint = Integer.MAX_VALUE;
        for(int i = 0; i < distances[0].length; i++){
            int totalCost = distances[0][i] + distances[1][i] + distances[2][i];
            midpoint = midpoint > totalCost ? totalCost : midpoint;
        }
        
        return midpoint < straight ? midpoint : straight;
    }
}