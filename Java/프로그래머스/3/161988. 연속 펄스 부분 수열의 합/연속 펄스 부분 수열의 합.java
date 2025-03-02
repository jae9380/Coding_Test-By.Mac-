class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        if(sequence.length==1) {
            answer = sequence[0] < 0 ? -sequence[0] : sequence[0];
            return answer;
        }
        long[][] pulseSum = new long[sequence.length][2];
        pulseSum[0] = new long[]{sequence[0], -sequence[0]};
        
        for (int i = 1; i < sequence.length; i++) {
            pulseSum[i][0] = (pulseSum[i - 1][1] > 0 ? pulseSum[i - 1][1] : 0) + sequence[i];
            pulseSum[i][1] = (pulseSum[i - 1][0] > 0 ? pulseSum[i - 1][0] : 0) - sequence[i];

            answer = (pulseSum[i][0] > pulseSum[i][1] ? pulseSum[i][0] : pulseSum[i][1]) > answer
                    ? (pulseSum[i][0] > pulseSum[i][1] ? pulseSum[i][0] : pulseSum[i][1])
                    : answer;
        }
            
        return answer;
    }
}