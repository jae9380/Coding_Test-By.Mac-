class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] positionValues = {781, 156, 31, 6, 1}; 
        char[] arr = {'A', 'E', 'I', 'O', 'U'};

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < arr.length; j++) {
                if (c == arr[j]) {
                    answer += positionValues[i] * j;
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
}