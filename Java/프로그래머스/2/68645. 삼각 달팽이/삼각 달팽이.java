class Solution {
    public int[] solution(int n) {
        int[][] nav = {{1,0},{0,1},{-1,-1}};
        int x=0,y=0,num=1,navIndex=0,size=n*(n+1)/2;
        int[][]pyramid = new int[n][n];
        
        while(num<=size) {
            pyramid[x][y]=num;
            num++;
            
            int next_x=x+nav[navIndex][0];
            int next_y=y+nav[navIndex][1];
            
            if(next_x<0||next_x>=n||
               next_y<0||next_y>=n||
               pyramid[next_x][next_y]!=0) {
                navIndex=(navIndex+1)%3;
                next_x=x+nav[navIndex][0];
                next_y=y+nav[navIndex][1];
            }
            
            x=next_x;
            y=next_y;
        }
        
        int[] answer = new int[size];
        num=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                if (pyramid[i][j]==0) break;

                answer[num]=pyramid[i][j];
                num++;
            }
        }
        
        
        
        return answer;
    }
}