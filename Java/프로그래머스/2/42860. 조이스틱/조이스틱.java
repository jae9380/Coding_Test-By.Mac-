class Solution {
    public int solution(String name) {
        char[] target = name.toCharArray();
        boolean[] map = new boolean[target.length];
        int count=0,minMove=target.length-1;
        for (int i = 0; i < target.length ; i++) {
            if (target[i]=='A') {
                map[i]=true;
                continue;
            }
            count+= target[i]-'A'<'['-target[i]?target[i]-'A':'['-target[i];
        }
        if(count==0) return 0;
        for (int i = 0; i < target.length; i++) {
            if (!map[i]) {
                int next = i + 1;
                while (next < target.length && target[next] == 'A') {
                    next++;
                }
                minMove = (minMove < i + target.length - next + (i < target.length - next ? i : target.length - next))
                        ? minMove : i + target.length - next + (i < target.length - next ? i : target.length - next);
            }
        }
        return count + minMove;
    }
}