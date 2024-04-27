import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        int sum = 0, min = 0, cnt = 0;

        for (int i = m; i <= n; i++) {
            int divisorCnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) divisorCnt ++;

                if (j == i && divisorCnt == 2) {
                    cnt ++;
                    sum += i;
                    if (cnt == 1) min = i;
                }
            }
        }
        
        if (cnt == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}