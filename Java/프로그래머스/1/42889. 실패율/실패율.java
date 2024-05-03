import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] currentSta = new int[N+1];
        for(int i=0;i<stages.length;i++){
            currentSta[stages[i]-1]++;
        }
        int size = stages.length;
        HashMap<Integer,Double> map = new HashMap<>();
        for(int i=0;i<currentSta.length-1;i++){
            if(currentSta[i]==0) {
                map.put(i+1,0.0);
            }else{
            map.put(i+1,(double)currentSta[i]/size);
            size-= currentSta[i];   
            }
        }
        List<Integer> result = new ArrayList<>(map.keySet());
        result.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        return result.stream().mapToInt(i -> i).toArray();
    }
}