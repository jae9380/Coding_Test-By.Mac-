import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = func(files);
        return answer;
    }
    private String[] func(String[] files) {
        List<String[]> fileList = new ArrayList<>();
        for(String file : files) {
            
            int index_s = 0, n = file.length();
            
            for(int i=0; i<n; i++) {
                if(Character.isDigit(file.charAt(i))) {
                    index_s = i;
                    break;
                }
            }
            String head = file.substring(0, index_s);
            int index_e = index_s;
            
            while(index_e < n && Character.isDigit(file.charAt(index_e))) {
                index_e++;
            }
            
            boolean hasTail = n==index_e ? false : true;
            
            String number = hasTail ? 
                file.substring(index_s, index_e) : file.substring(index_s);
            String tail = hasTail ?
                file.substring(index_e) : "";
        
            fileList.add(new String[]{head, number, tail});
        }
        
        fileList.sort(new Comparator<String[]>() {
           @Override
            public int compare(String[] o1, String[] o2) {
                int head = o1[0].compareToIgnoreCase(o2[0]);
                if(head != 0) return head;
                
                int number = Integer.compare(
                    Integer.parseInt(o1[1]), Integer.parseInt(o2[1])
                );
                if(number!=0) return number;
                
                return 0;
            }
        });
        
        List<String> list = new ArrayList<>();
        for (String[] array : fileList) {
            StringBuilder sb = new StringBuilder();
            for (String element : array) {
                sb.append(element);
            }
            list.add(sb.toString());
        }

        String[] result = list.toArray(new String[0]);
        
        return result;
    }
}