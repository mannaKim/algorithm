import java.io.*;
import java.util.*;
 
public class Solution {
    static int T, N;
    static int[] price;
    static int cnt;
    static long result, max, cost;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
         
        for (int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
             
            price = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }
             
            cnt = 0;
            max = 0;
            result = 0;
            cost = 0;
            for (int j=price.length-1; j>=0; j--) {
                if (price[j] > max) {
                    result += (max*cnt - cost);
                    max = price[j];
                    cost = 0;       
                    cnt = 0;
                }
                else {
                    cnt ++;
                    cost += price[j];
                }
            }
             
            result += (max*cnt - cost);
             
            System.out.printf("#%d %d\n", i+1, result);
        }
    }
}