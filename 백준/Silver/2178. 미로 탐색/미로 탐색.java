import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] dist;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static class Pos {
        int y, x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
                dist[i][j] = -1;
            }
        }

        dist[0][0] = 1;
        bfs(0, 0);

        // for (int i=0; i<n; i++) {
        //     for (int j=0; j<m; j++) {
        //         System.out.printf("%d\t", dist[i][j]);
        //     }
        //     System.out.printf("\n");
        // }

        System.out.println(dist[n-1][m-1]);
    }
    public static void bfs(int y, int x) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(y, x));

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int i=0; i<4; i++) {
                int tempY = now.y + dy[i];
                int tempX = now.x + dx[i];

                if (tempY<0 || tempY>=n || tempX<0 || tempX>=m) 
                    continue;
                
                if (map[tempY][tempX] == 0 || dist[tempY][tempX] != -1)
                    continue;

                queue.add(new Pos(tempY, tempX));
                dist[tempY][tempX] = dist[now.y][now.x] + 1;
            }
        }
    }
}