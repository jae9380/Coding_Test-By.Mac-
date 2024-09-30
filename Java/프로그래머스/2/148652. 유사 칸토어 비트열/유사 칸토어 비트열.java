class Solution {
    public int solution(int n, long l, long r) {
        int answer=0;
        for(long i=l-1; i < r; i++) {
            if (func(i)) answer++;
        }
        return answer;
    }

    boolean func(long l) {
        if (l < 5 && l != 2) return true;
        if ((l - 2) % 5 == 0) return false;
        return func(l / 5);
    }
}