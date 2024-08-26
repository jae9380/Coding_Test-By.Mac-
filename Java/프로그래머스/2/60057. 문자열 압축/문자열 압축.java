class Solution {
    public int solution(String s) {
        int answer = s.length(), count=1;
        
        for(int i=1;i<=s.length()/2;i++) {
            StringBuilder sb=new StringBuilder();
            String baseStr=s.substring(0,i);
            for(int j=i;j<=s.length();j+=i) {
                
                String compare=s.substring(j,i+j>s.length()?s.length():i+j);
                if(baseStr.equals(compare)) {
                    count++;
                }else {
                    if(count>1) {
                        sb.append(count);
                    }
                    count=1;
                    sb.append(baseStr);
                    baseStr=compare;
                }
            }
            sb.append(baseStr);
            answer = answer<sb.length() ? answer : sb.length();
            
        }
        return answer;
    }
}