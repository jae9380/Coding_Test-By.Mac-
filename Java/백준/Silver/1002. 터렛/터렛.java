import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        int result = 0;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
    
            int d = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
            int sum = (r1 + r2) * (r1 + r2);
            int diff = (r1 - r2) * (r1 - r2);

            if (d == 0 && r1 == r2) {
                System.out.println(-1);
                continue;
            }else if(d > sum || d < diff){
                System.out.println(0);
                continue;                
            }else if(d == sum || d == diff){
                System.out.println(1);
                continue;                   
            }else {
                System.out.println(2);
            }
        }
    }
}