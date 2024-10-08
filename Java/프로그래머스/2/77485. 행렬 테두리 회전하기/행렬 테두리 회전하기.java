class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];		
		int[][] map = new int[rows][columns];
		for (int i=0;i<rows;i++) {
			for (int j=0;j<columns;j++) {
				map[i][j]=i*columns+j+1;
			}
		}
		for (int i=0;i<queries.length;i++) {
			int[] minPos={queries[i][0]-1,queries[i][1]-1},
            maxPos={queries[i][2]-1,queries[i][3]-1};
			
			int start = map[minPos[0]][minPos[1]];
			int min = Integer.MAX_VALUE;
			for (int j=minPos[0];j<maxPos[0];j++) {
				min = Math.min(min,map[j][minPos[1]]);
				map[j][minPos[1]]=map[j+1][minPos[1]];
			}
			for (int j=minPos[1];j<maxPos[1];j++) {
				min=Math.min(min,map[maxPos[0]][j]);
				map[maxPos[0]][j]=map[maxPos[0]][j+1];
			}
			for (int j=maxPos[0];j>minPos[0];j--) {
				min=Math.min(min,map[j][maxPos[1]]);
				map[j][maxPos[1]]=map[j-1][maxPos[1]];
			}
			for (int j=maxPos[1];j>minPos[1];j--) {
				min=Math.min(min,map[minPos[0]][j]);
				map[minPos[0]][j]=map[minPos[0]][j-1];
			}
			map[minPos[0]][minPos[1] + 1]=start;
			answer[i] = min;
		}
		
		return answer;
    }
}