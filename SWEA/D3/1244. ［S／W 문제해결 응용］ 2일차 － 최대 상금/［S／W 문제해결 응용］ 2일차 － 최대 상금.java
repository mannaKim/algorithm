import java.io.*;
import java.util.*;

public class Solution {
	static int T, N;
	static int[] arr;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
        	N = Integer.parseInt(st.nextToken());
        	result = 0;
        	arr = new int[str.length()];
        	for (int i=0; i<str.length(); i++) {
        		arr[i] = str.charAt(i) - '0';
        	}
        	
        	if (N > arr.length) N = arr.length;
        	
        	dfs(0, 0);
        	
        	System.out.printf("#%d %d\n", t, result);
        }
		br.close();
	}
	public static void dfs(int s, int e) {
		if (e == N) {
			result = Math.max(result, Integer.parseInt(Arrays.toString(arr).replaceAll("[^0-9]", "")));
			return;
		}
		
		for (int i=s; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length; j++) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				dfs(i, e+1);
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
}