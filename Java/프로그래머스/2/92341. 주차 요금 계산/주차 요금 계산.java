import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        ParkingFeeCalculator calculator = new ParkingFeeCalculator(fees);

        HashMap<String,Integer> timeMap = new HashMap<>();
        HashMap<String,Boolean> statusMap = new HashMap<>();

        for (String record : records) {
            String[] el = record.split(" ");

            if (el[2].equals("IN")){
                if (!timeMap.containsKey(el[1])) {
                    timeMap.put(el[1],getTime(el[0]));
                    statusMap.put(el[1],true);
                }else {
                    timeMap.replace(el[1],getTime(el[0])-timeMap.get(el[1]));
                    statusMap.put(el[1],true);
                }
            }else {
                timeMap.replace(el[1], getTime(el[0])-timeMap.get(el[1]));
                statusMap.replace(el[1],false);
            }
        }

        int endTime = getTime("23:59");
        for (String s : statusMap.keySet()) {
            if (statusMap.get(s)) {
                timeMap.replace(s,endTime-timeMap.get(s));
            }
        }
        
        int[] answer = timeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .mapToInt(entry -> calculator.calculateFee(entry.getValue()))
                .toArray();

    return answer;

    }
    private static int getTime(String str) {
        String[] part = str.split(":");
        return Integer.parseInt(part[1])+(Integer.parseInt(part[0])*60);
    }
}
class ParkingFeeCalculator {
    private final int baseTime;
    private final int baseFee;
    private final int unitTime;
    private final int unitFee;

    public ParkingFeeCalculator(int[] fees) {
        this.baseTime = fees[0];
        this.baseFee = fees[1];
        this.unitTime = fees[2];
        this.unitFee = fees[3];
    }

    public int calculateFee(int totalTime) {
        return totalTime <= baseTime ?
                baseFee : (totalTime-baseTime)%unitTime ==0?
                    baseFee+((totalTime-baseTime)/unitTime)*unitFee : baseFee+((totalTime-baseTime)/unitTime+1)*unitFee;
    }
}