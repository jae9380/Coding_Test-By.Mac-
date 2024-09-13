class Solution {
    public int solution(int n) {
        int d = 1000000007;
        int[] map = new int[n+1];
        map[1] = 2;
        map[2] = 3;
        for(int i = 3; i <= n; i++){
            if(i%2 == 0){
                map[i] = map[i-1]%d + map[i-2]%d;
            } else {
                map[i] = map[i-1]*2%d + map[i-2]%d;
            }
            map[i] = map[i]%d;
        }
        return map[n];
    }
}