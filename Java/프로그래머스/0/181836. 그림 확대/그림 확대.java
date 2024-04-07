import java.util.*;
class Solution {
    public String[] solution(String[] picture, int k) {
        if (k==1){
            return picture;
        }

        String a = "";
        String b = "";

        for (int i = 0; i <k ; i++) {
            a+="x";
            b+=".";

        }

        System.out.println(a +"/ "+b);
        ArrayList<String> filter = new ArrayList<>();
        for (String s : picture) {
            for (int i = 0; i <k ; i++) {
                filter.add(s.replace("x",a).replace(".",b));
            }
        }

        String[] answer = filter.toArray(filter.toArray(new String[filter.size()]));
        return answer;
    }
}