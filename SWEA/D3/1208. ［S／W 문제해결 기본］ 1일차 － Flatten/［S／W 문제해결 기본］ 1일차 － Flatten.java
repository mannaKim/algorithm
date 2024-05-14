import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t=1; t<=10; t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[100];
			st = new StringTokenizer(br.readLine(), " ");
        	for (int i=0; i<100; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	Arrays.sort(arr);
        	for (int i=0; i<N; i++) {
        		if (arr[99]-arr[0] == 0 || arr[99]-arr[0] == 1) break;
        		arr[0] ++;
        		arr[99] --;
        		Arrays.sort(arr);
        	}
        	
        	System.out.printf("#%d %d\n", t, arr[99]-arr[0]);
        }
		br.close();
	}
}