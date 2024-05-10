import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] numArr;
	static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        numArr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
        	numArr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 초기값 설정
        int sum = 0;
        for (int i=0; i<K; i++) {
        	sum += numArr[i];
        }
        max = sum;
        
        // 다음 인덱스 더하고, 이전인덱스 뺴기
        int nextK;
        for (int i=1; i<N; i++) {
        	nextK = i + K - 1;
        	if (nextK < N) {
        		sum -= numArr[i-1];
        		sum += numArr[nextK];
        		max = Math.max(max, sum);
        	}
        	else break;
        }
        
        System.out.println(max);
    }
}