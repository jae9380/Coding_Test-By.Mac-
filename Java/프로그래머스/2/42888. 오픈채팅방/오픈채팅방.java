import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        return func(record);
    }
    
    private static String[] func(String[] record) {
        List<String> status = new ArrayList<>();
        Map<String, String>user = new HashMap<>();
        for(String part : record) {
            String[] info = part.split(" ");
            if(!info[0].equals("Leave"))user.put(info[1],info[2]);
            if(!info[0].equals("Change")) status.add(info[1]+" "+info[0]);
        }
        String[] answer = new String[status.size()];
        for(int i=0; i<status.size(); i++) {
            String part[] = status.get(i).split(" ");
            String nickName = user.get(part[0]); 
            String command = part[1].equals("Enter") ? "들어왔습니다." : "나갔습니다.";
            answer[i]=nickName+"님이 "+command;
        }
        return answer;
    }
}