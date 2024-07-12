class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr = new char[m][n];
        boolean[][] chkBoard = new boolean[m][n];

        for(int i=0;i<m;i++) {
            arr[i]=board[i].toCharArray();
        }
        int count=0;
        while(true) {
            count=answer;
            for(int i=0;i<m-1;i++) {
                for(int j=0;j<n-1;j++) {
                    if(arr[i][j]=='0') continue;
                    if(arr[i][j]==arr[i][j+1]&&
                            arr[i][j]==arr[i+1][j]&&
                            arr[i][j]==arr[i+1][j+1]) {
                        for(int x=i;x<i+2;x++) {
                            for(int y=j;y<j+2;y++) {
                                chkBoard[x][y]=true;
                            }
                        }
                    }
                }
            }

            for(int i=0; i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(chkBoard[i][j]) {
                        answer++;
                        arr[i][j]='0';
                        chkBoard[i][j]=false;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (arr[i][j] == '0') {
                        int k = i;
                        while (k > 0 && arr[k][j] == '0') {
                            k--;
                        }
                        if (k != i) {
                            arr[i][j] = arr[k][j];
                            arr[k][j] = '0';
                        }
                    }
                }
            }
            if(count==answer) break;
        }
        return answer;
    }
}