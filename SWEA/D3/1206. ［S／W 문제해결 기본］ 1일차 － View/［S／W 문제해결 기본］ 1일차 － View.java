import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] arr;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        for (int t=1; t<=10; t++) {
        	N = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine(), " ");
        	arr = new int[N];
        	for (int i=0; i<N; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	result = 0;
        	for (int i=2; i<N-2; i++) {
        		// 오른쪽
        		int maxR = Math.max(arr[i+1], arr[i+2]);
        		int maxL = Math.max(arr[i-1], arr[i-2]);
        		int max = Math.max(maxR, maxL);
        		if (arr[i] > max) {
        			result += arr[i] - max;
        		}
        	}
    		
        	System.out.printf("#%d %d\n", t, result);
        }
	}
}