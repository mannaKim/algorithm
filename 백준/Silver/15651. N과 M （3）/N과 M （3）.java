import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;       // 출력할 수열을 담을 배열(길이가 m인 수열)
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m+1];     // 길이가 2인 수열일 경우 arr[1]과 arr[2]에 수열을 저장하도록 m+1 길이의 배열로 선언

        recur(1);   // 깊이를 1부터 시작하여 1부터 탐색하도록 함.

        System.out.println(result);
    }
    public static void recur(int depth) {
        // 재귀 호출을 멈추는 조건 : 재귀 깊이가 m보다 커진 경우
        if (depth > m) { 
            // j는 1~m까지 수열 길이만큼 반복 실행
            for (int j=1; j<=m; j++) {
                result.append(arr[j]).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i=1; i<=n; i++) {
            arr[depth] = i;
            recur(depth + 1);
        }
    }
}