import java.util.*;
class Solution {
    public int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; 
        }
        
        int count = 0;
        for (int[] cost : costs) {
            int node1 = cost[0];
            int node2 = cost[1];
            int weight = cost[2];
            if (find(node1) != find(node2)) {
                answer += weight;
                union(node1, node2);
                count++;
            }
            if (count == n - 1) break;
        }
        
        return answer;
    }
    
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}