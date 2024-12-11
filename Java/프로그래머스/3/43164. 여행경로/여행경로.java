import java.util.*;
class Solution {
    private boolean[] visited;
    private ArrayList<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length+1];
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(list);
        return list.get(0).split("-");
    }
    
    private void dfs(String departure, String entry, String[][] tickets, int count) {
        if (count == tickets.length) {
            list.add(entry);
            return;
        }
        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(departure)) {
                    visited[i]=true;
                    dfs(tickets[i][1],entry+"-"+tickets[i][1], tickets, count+1);
                    visited[i]=false;
                }
            }
        }
    
}