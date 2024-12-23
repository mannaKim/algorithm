import java.io.*;
import java.util.*;

public class Main {
        // true: 소수 아님, false: 소수
        public static boolean[] prime;

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        prime = new boolean[N+1];   // 0~N까지의 인덱스를 가진 boolean 배열 초기화
        getPrime();
        
        for (int i=M; i<=N; i++) {
            if (!prime[i]) bw.write(i+"\n");    // false일 경우 출력
        }
        bw.close();
    }
    
    // 에라토스테네의 체
    public static void getPrime() {
        prime[0] = prime[1] = true;

        // 2 부터 √N 이하까지 반복하여
        for (int i=2; i<=Math.sqrt(prime.length); i++) {
            
            if (prime[i]) continue; // 이미 체크한 인덱스면 continue

            // i의 배수
            for (int j=i*i; j<prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }  
}