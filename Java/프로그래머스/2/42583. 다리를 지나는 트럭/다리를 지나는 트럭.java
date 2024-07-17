import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalWeight=0, time=0;
        Queue<Integer>bridge=new LinkedList<>();
        for(int truck : truck_weights) {
            while(true) {
                if(bridge.size()==bridge_length) {
                    totalWeight-=bridge.poll();
                }
                if(bridge.isEmpty()) {
                    bridge.add(truck);
                    totalWeight+=truck;
                    time++;
                    break;
                }else {
                    if(totalWeight+truck<=weight) {
                        bridge.add(truck);
                        totalWeight+=truck;
                        time++;
                        break;
                    }else {
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }
        return bridge_length+time;
    }
}