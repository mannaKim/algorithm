import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int t, m, n, k;
    static int[] result;

    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static public class Pos {
        int y, x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        t = Integer.parseInt(br.readLine());
        result = new int[t];

        for (int test=0; test<t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int count = 0;

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count ++;
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }

            result[test] = count;
        }

        for (int i=0; i<t; i++) {
            System.out.println(result[i]);
        }
    }

    public static void bfs(int y, int x) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(y, x));

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int i=0; i<4; i++) {
                int tempY = now.y + dy[i];
                int tempX = now.x + dx[i];
                if (tempY>=0 && tempY<n && tempX>=0 && tempX<m) {
                    if (map[tempY][tempX] == 1 && !visited[tempY][tempX]) {
                        visited[tempY][tempX] = true;
                        queue.add(new Pos(tempY, tempX));
                    }
                }
            }
        }
    }
}