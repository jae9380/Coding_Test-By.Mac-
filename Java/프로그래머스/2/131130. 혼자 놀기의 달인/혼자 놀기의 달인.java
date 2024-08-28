class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visited = new boolean[cards.length];
        boolean[] visited2 = new boolean[cards.length];
        int first=0,second=0, count=0, count2=0;
        for (int i = 0; i < cards.length; i++) {
            first=i;
            count=0;
            while (!visited[first]){
                count++;
                visited[first]=true;
                first=cards[first]-1;
            }
            for (int j = 0; j < cards.length; j++) {
                count2=0;
                visited2=visited;
                if (visited2[j]) continue;
                second=j;
                while (!visited2[second]) {
                    count2++;
                    visited2[second]=true;
                    second=cards[second]-1;
                }
                answer= answer<count*count2?count*count2:answer;
            }
            visited=new boolean[cards.length];
        }
        return answer;
    }
}