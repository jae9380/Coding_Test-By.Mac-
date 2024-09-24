import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int distance=0;
        long count=0;

        Stack<int[]> d=new Stack<>();
        Stack<int[]> p=new Stack<>();

        for (int i=0; i<n; i++) {
            if (deliveries[i]!=0) d.add(new int[]{i+1, deliveries[i]});
            if (pickups[i]!=0) p.add(new int[]{i+1, pickups[i]});
        }

        int c=0;
        while (!d.isEmpty()||!p.isEmpty()) {
            distance=0;
            c=0;

            if (!d.isEmpty()) {
                while (true) {
                    int[] current=d.peek();
                    int house=current[0];
                    int boxes=current[1];
                    
                    int deliverable=cap-c<boxes?cap-c:boxes;
                    c+=deliverable;
                    distance=distance>house?distance:house;
                    d.pop();

                    if(boxes-deliverable>0) {
                        d.push(new int[]{house, boxes-deliverable});
                        break;
                    }
                    if(d.isEmpty()) break;
                }
            }
            if(!p.isEmpty()) {
                c=0;
                while(true) {
                    int[] current=p.peek();
                    int house=current[0];
                    int boxes=current[1];

                    int pickupable=cap-c<boxes?cap-c:boxes;
                    c+=pickupable;
                    distance=distance>house?distance:house;
                    p.pop();

                    if (boxes - pickupable > 0) {
                        p.push(new int[]{house, boxes - pickupable});
                        break;
                    }
                    if (p.isEmpty()) break;
                }
            }
            count+=distance*2;
        }

        return count;
    }
}