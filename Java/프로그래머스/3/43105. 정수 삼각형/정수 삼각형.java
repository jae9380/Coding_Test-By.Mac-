class Solution {
    public int solution(int[][] triangle) {
        for (int i=triangle.length-1; i>0; i--) {
            for (int j=0; j <triangle[i].length-1 ; j++) {
                triangle[i-1][j]+=triangle[i][j]>triangle[i][j+1]?triangle[i][j]:triangle[i][j+1];
            }
        }
        int answer = triangle[0][0];
        return answer;
    }
}