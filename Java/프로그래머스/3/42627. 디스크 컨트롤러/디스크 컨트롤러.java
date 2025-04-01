import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        Stack<int[]> stack = new Stack<>();
        PriorityQueue<int[]> jobList = new PriorityQueue<>((o1, o2) -> {
           if (o1[0] != o2[0]) return o1[0]- o2[0];
           return o1[1] - o2[1];
        }),
                pq = new PriorityQueue<>(((o1, o2) -> {
                    if (o1[1] != o2[1]) return o1[1]- o2[1];
                    return o1[0] - o2[0];
                }));

        for (int[] job : jobs) {
            jobList.add(job);
        }

        int count = 0, time = 0;

        while (!jobList.isEmpty() || !pq.isEmpty()) {
            int[] job;
            if (pq.isEmpty()) {
                job = jobList.poll();
                count += job[1];
            }else {
                job = pq.poll();
                count += job[1] + time - job[0];
            }
            time = time + job[1] > job[0] + job[1] ? time + job[1] : job[0] + job[1];
            int size = jobList.size();

            for (int i = 0; i < size; i++) {
                if(jobList.peek()[0] <= time) pq.add(jobList.poll());
                else stack.add(jobList.poll());
            }
            while (!stack.isEmpty()) jobList.add(stack.pop());
        }

        answer = count / jobs.length;

        return answer;
    }
}