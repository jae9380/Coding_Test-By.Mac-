import java.util.Arrays;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int x=-1;
        for(int i=0;i<A.length;i++){
            for(int j=x+1;j<B.length;j++){
                if(A[i]<B[j]){
                    x = j;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}