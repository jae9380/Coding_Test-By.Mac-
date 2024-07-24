class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int index_s = 0, index_e = 0, length = Integer.MAX_VALUE, sub =0;
        
        while (index_e < sequence.length) {
            if (sub < k) {
                sub += sequence[index_e++];
            }
            if (sub == k) {
                if (index_e - index_s < length) {
                    length = index_e - index_s;
                    answer[0] = index_s;
                    answer[1] = index_e - 1;
                }
                sub -= sequence[index_s++];
            }
            while (sub > k) {
                sub -= sequence[index_s++];
                if (sub == k) {
                    if (index_e - index_s < length) {
                        length = index_e - index_s;
                        answer[0] = index_s;
                        answer[1] = index_e - 1;
                    }
                }
            }
        }
        return answer;
    }
}