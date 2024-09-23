import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        ArrayList<Integer[]> intersectionPoint=new ArrayList<>();
        long denominator, numerator;
        int x, y;

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                denominator = (long)line[i][0] * line[j][1] - (long)line[i][1] * line[j][0];
                if (denominator == 0) continue;

                numerator = (long)line[i][1] * line[j][2] - (long)line[i][2] * line[j][1];
                if (numerator % denominator != 0) continue;
                x = (int)(numerator / denominator);

                numerator = (long)line[i][2] * line[j][0] - (long)line[i][0] * line[j][2];
                if (numerator % denominator != 0) continue;
                y = (int)(numerator / denominator);

                intersectionPoint.add(new Integer[]{x, y});
            }
        }
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (Integer[] point : intersectionPoint) {
            x = point[0];
            y = point[1];
            if (x < minX) minX = x;
            if (y < minY) minY = y;
            if (x > maxX) maxX = x;
            if (y > maxY) maxY = y;
        }

        int w = maxX - minX + 1;
        int h = maxY - minY + 1;

        String[] answer = new String[h];

        for (int i = 0; i < h; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < w; j++) {
                sb.append(".");
            }
            answer[i] = sb.toString();
        }

        for (Integer[] point : intersectionPoint) {
            x = point[0] - minX;
            y = point[1] - minY;

            StringBuilder sb = new StringBuilder(answer[h - 1 - y]);
            sb.setCharAt(x, '*');
            answer[h - 1 - y] = sb.toString();
        }
        return answer;
    }
}