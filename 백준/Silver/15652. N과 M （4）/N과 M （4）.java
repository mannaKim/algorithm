import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;        
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m+1];    
        recur(1); 

        System.out.println(result);
    }
    public static void recur(int depth) {
        if (depth > m) { 
            for (int j=1; j<=m; j++) {
                result.append(arr[j]).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i=1; i<=n; i++) {
            if (arr[depth-1] > i) continue;
            arr[depth] = i;
            recur(depth + 1);
        }
    }
}