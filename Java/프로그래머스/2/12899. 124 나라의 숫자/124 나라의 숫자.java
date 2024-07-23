class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] num = {"4","1","2"};
        while(n>0){
            sb.append(num[n%3]);
            
            n=n%3==0 ? n/3-1 : n/3;
            
        }
        System.out.println(sb.toString());
        return sb.reverse().toString();
    }
}