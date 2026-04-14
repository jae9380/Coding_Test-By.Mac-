import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;
        int target = 0;

        for (int i = 0; i < n; i++) {
            int d = Math.abs(arr[i] - s);
            int cost;
            if (d > 2 * k) {
                cost = (d - 2 * k) * l;
            }
            else {
                if (d % 2 == 0) {
                    cost = (k - d / 2) * 2;
                } else {
                    cost = (k - d / 2) * 2 - 1;
                }
            }
            if (cost < answer) {
                answer = cost;
                target = i + 1;
            }
        }

        System.out.println(answer + " " + target);
    }
}