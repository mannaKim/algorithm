import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] chk;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m+1];
        chk = new boolean[n+1];

        recur(1);
        System.out.println(result);
    }
    public static void recur(int depth) {
        if (depth == m+1) {
            for (int i=1; i<=m; i++) {
                result.append(arr[i]).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i=1; i<=n; i++) {
            if (!chk[i]) {
                chk[i] = true;
                arr[depth] = i;
                recur(depth+1);
                chk[i] = false;
            }
        }
    }
}