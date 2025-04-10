class Solution {
    public int solution(int n, int[] money) {
        int[] c = new int[n + 1];
        c[0] = 1;
        for(int coin : money) {
            for(int i = coin; i <= n; i++) {
                c[i] += (c[i-coin]) % 1000000007;
            }
        }
        return c[n];
    }
}