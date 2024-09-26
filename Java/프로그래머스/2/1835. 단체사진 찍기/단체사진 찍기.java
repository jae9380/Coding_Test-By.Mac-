import java.util.*;
class Solution {
    List<Character> friends = new ArrayList<>(Arrays.asList('A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'));
    boolean[] visited;
    List<Integer> position = new ArrayList<>();
    int count=0;
    int[][] options;
    
    public int solution(int n, String[] data) {

        visited=new boolean[8];
        options=new int[n][4];

        int c1,c2,sign, distance;
        for (int i = 0; i <n; i++) {
            c1= friends.indexOf(data[i].charAt(0));
            c2= friends.indexOf(data[i].charAt(2));
            sign= data[i].charAt(3)=='='? 0 : data[i].charAt(3)=='<'? -1 : 1;
            distance=Integer.parseInt(data[i].substring(4));
            options[i]=new int[]{c1, c2, sign, distance};
        }

        combination(0);
        
        return count;
    }
    
    void combination(int index) {
        if (index==8&&check()) {
            count++;
        }else {
            for (int i = 0; i <8 ; i++) {
                if (!visited[i]) {
                    visited[i]=true;
                    position.add(i);
                    combination(index+1);
                    visited[i]=false;
                    position.remove(position.size() - 1);
                }
            }
        }
    }
    
    boolean check() {
        for (int[] option : options) {

            position.indexOf(option[1]);

            switch (option[2]) {
                case -1:
                    if (Math.abs(position.indexOf(option[0])-position.indexOf(option[1])) >= option[3]+1)
                        return false;
                    break;
                case 0:
                    if (Math.abs(position.indexOf(option[0])-position.indexOf(option[1])) != option[3]+1)
                        return false;
                    break;
                case 1:
                    if (Math.abs(position.indexOf(option[0])-position.indexOf(option[1])) <= option[3]+1)
                        return false;
                    break;
            }
        }
        return true;
    }    
}