import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        int cnt = 0;
        int index = arr.length - 1;
        while (true) {
        	if (K == 0) break;
        	
        	if (arr[index] <= K) {
        		K -= arr[index];
        		cnt ++;
        	}
        	else {
        		index --;
        	}
        }
        
        System.out.println(cnt);
    }
}