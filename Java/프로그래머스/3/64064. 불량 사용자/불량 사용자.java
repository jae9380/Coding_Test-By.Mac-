import java.util.*;
import java.util.stream.Collectors;
class Solution {
    private Set<Set<String>> results = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> candidates = Arrays.stream(banned_id)
                .map(pattern -> {
                    String regex = pattern.replace("*", ".*");
                    return Arrays.stream(user_id)
                            .filter(id -> id.length()==pattern.length())
                            .filter(id -> id.matches(regex))
                            .collect(Collectors.toList());
                })
                .collect(Collectors.toList());
        dfs(candidates, new HashSet<>(), 0, banned_id.length);
        return results.size();
    }

    private void dfs(List<List<String>> candidates, Set<String> current, int index, int totalBanned) {
        if (index == totalBanned) {
            results.add(new HashSet<>(current));
            return;
        }
        for (String user : candidates.get(index)) {
            if (!current.contains(user)) {
                current.add(user);
                dfs(candidates, current, index + 1, totalBanned);
                current.remove(user);
            }
        }
    }
}