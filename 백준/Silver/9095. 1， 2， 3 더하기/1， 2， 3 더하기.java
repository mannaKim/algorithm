import java.io.*;

public class Main {
    public static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수 입력

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            memo = new int[n+1]; // 1~n까지 활용하기 위해 n+1로 선언
            System.out.println(dp(n));
        }
    }
    public static int dp(int n) {
        // 계산했던 n이라면 저장된 값으로 반환 (중복 방지, 메모이제이션)
        if (memo[n] != 0) return memo[n]; 

        // 재귀 종료 조건: n이 1,2,3일 떄는 직접 반환
        if (n == 1) return 1;   // 1가지 방법) 1
        if (n == 2) return 2;   // 2가지 방법) 1+1, 2
        if (n == 3) return 4;   // 4가지 방법) 1+1+1, 1+2, 2+1, 3

        // 점화식
        memo[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);
        return memo[n];
    }
}