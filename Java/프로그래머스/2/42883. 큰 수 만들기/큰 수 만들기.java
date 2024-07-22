class Solution {
    public String solution(String number, int k) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < number.length() - k; i++) {
            char num = 0;
            for(int j = index; j < i + k+1; j++) {
                if(num < number.charAt(j)) {
                    num = number.charAt(j);
                    index = j + 1;
                }
            }
            sb.append(num);
        }
        return sb.toString();
    }
}