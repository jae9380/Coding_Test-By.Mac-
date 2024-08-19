class Solution {
    public long solution(int w, int h) {
    long ref = getGCD(w, h);
		
    return ((long)w*h)-(((w/ref)+(h/ref)-1)*ref);

    }
    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}