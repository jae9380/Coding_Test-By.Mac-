import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> completedAssignments = new ArrayList<>();
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                return a[1].compareTo(b[1]);
            }
        });

        Stack<Assignment> stack = new Stack<>();
        int currentTime = timeToMinutes(plans[0][1]);

        for (int j = 0; j < plans.length; j++) {
            String name = plans[j][0];
            int start = timeToMinutes(plans[j][1]);
            int playtime = Integer.parseInt(plans[j][2]);

            while (!stack.isEmpty() && currentTime + stack.peek().time <= start) {
                Assignment finishedAssignment = stack.pop();
                currentTime += finishedAssignment.time;
                completedAssignments.add(finishedAssignment.className);
            }

            if (!stack.isEmpty()) {
                stack.peek().time -= (start - currentTime);
            }

            stack.push(new Assignment(name, start, playtime));
            currentTime = start;
        }

        while (!stack.isEmpty()) {
            completedAssignments.add(stack.pop().className);
        }

        return completedAssignments.toArray(new String[0]);
    }

    public static class Assignment {
        String className;
        int start, time;

        public Assignment(String className, int start, int time) {
            this.className = className;
            this.start = start;
            this.time = time;
        }
    }

    static int timeToMinutes(String start) {
        String[] parts = start.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
