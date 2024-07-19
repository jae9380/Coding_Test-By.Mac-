class Solution {
    static int[] count=new int[2];
    public int[] solution(int[][] arr) {
        
        func(arr, 0, 0, arr.length);
        return count;
    }
    private static void func(int[][] arr, int x, int y, int range) {
        if(canMakeZip(arr, x, y, range, arr[x][y])) {
            if(arr[x][y] == 0) {
                count[0]++;
            }else count[1]++;
        }else{
            func(arr, x, y, range/2);
            func(arr, x+range/2, y, range/2);
            func(arr, x, y+range/2, range/2);
            func(arr, x+range/2, y+range/2, range/2);    
            
        }        
    }
    private static boolean canMakeZip(int[][] arr, int x, int y, int range, int target) {
        for(int i=x; i<x+range; i++) {
            for(int j=y; j<y+range; j++) {
                if(arr[i][j]!=target) return false;
            }
        }
        return true;
    }
}