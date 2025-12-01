class Solution {
    public int solution(int[] a) {
        int len = a.length;
        if(len < 3) return len;
        
        int[][] minArr = new int[2][len];
        int lMin = a[0], rMin = a[a.length-1],answer = 2;
        
        
        for(int i = 1; i < len-1; i++) {
            minArr[0][i] = lMin;
            minArr[1][len - i - 1] = rMin;
            
            if(lMin > a[i]) lMin = a[i];
            if(rMin > a[len - i - 1]) rMin = a[len - i - 1];
        }
        
        for(int i = 1; i < len - 1; i++) {
            if(a[i] < minArr[0][i] || a[i] < minArr[1][i]) 
                answer++;
        }
        
        return answer;
    }
}