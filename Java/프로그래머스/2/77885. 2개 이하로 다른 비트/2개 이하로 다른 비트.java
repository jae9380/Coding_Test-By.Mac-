import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        List<Long> list = new ArrayList<>();
        Long numberPlusOne = 0L;
        for(Long number : numbers) {
            if(number%2==0) {
                list.add(number+1L);
            }else{
                numberPlusOne = number+1L;
                Long shiftResult  = (number ^ numberPlusOne)>> 2;
                list.add(numberPlusOne+shiftResult);
            }
        }
         long[] answer = list.stream()
                           .mapToLong(Long::longValue)
                           .toArray();

        return answer;
    }
}