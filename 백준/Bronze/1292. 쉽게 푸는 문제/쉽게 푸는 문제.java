import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
        
        int cnt = 0; // 몇 번 반복했는지(몇 번째 순서인지) 저장
        int sum = 0; // 구간의 합을 저장

        for (int i = 1; i <= 1000; i++) { // i는 1부터 1000까지 반복(주어진 조건)
            for (int j = 1; j <= i; j++) {  // j는 1부터 i만큼 반복
                // i가 1일 때는 1번 반복, i가 2일 때는 2번 반복 ...
                cnt ++; 
                if (a <= cnt && cnt <= b) {
                    sum += i;
                }
                if (cnt == b) break; 
            }
            if (cnt == b) break;
        }

        System.out.println(sum);
    }
}