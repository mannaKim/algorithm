import java.io.*;
import java.util.*;

public class Solution {
	static int T, N;
	static int[] score;
	static int max, result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
        	N = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine(), " ");
        	score = new int[100+1];
        	for (int i=0; i<1000; i++) {
        		int num = Integer.parseInt(st.nextToken());
        		score[num] ++;
        	}
        	
        	max = 0;
        	for (int i=1; i<=100; i++) {
        		if (max <= score[i]) {
        			max = score[i];
            		result = i;
        		}
        	}
        	
        	System.out.printf("#%d %d\n", N, result);
        }
	}
}