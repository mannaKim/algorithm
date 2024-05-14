import java.io.*;
import java.util.*;

public class Solution {
	static int T, N, L;
	static int[][] arr;
	static int max;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			arr = new int[N][2];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;
			dfs(0, 0, 0);
			
			System.out.printf("#%d %d\n", t, max);
		}
		br.close();
	}
	public static void dfs(int cnt, int score, int cal) {
		if (cal > L) return;
		if (cnt == N) {
			max = Math.max(max, score);
			return;
		}
		dfs(cnt+1, score+arr[cnt][0], cal+arr[cnt][1]);
		dfs(cnt+1, score, cal);
	}
}