import java.io.*;
import java.util.*;

public class Main {

    static int M; // 상자의 가로 칸 수 (가로)
    static int N; // 상자의 세로 칸 수 (세로)
    static int H; // 쌓아 올려지는 상자의 수 (높이)

    static int[][][] arr;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    // 방향
    static int[] dh = { -1, 1, 0, 0, 0, 0 }; // 위아래
    static int[] dn = { 0, 0, -1, 1, 0, 0 }; // 앞뒤
    static int[] dm = { 0, 0, 0, 0, -1, 1 }; // 좌우

    static int cnt = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int m = 0; m < M; m++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    if (tomato == 1) {
                        queue.offer(new int[] { h, n, m });
                        visited[h][n][m] = true;
                    }
                    arr[h][n][m] = tomato;
                }
            }
        }

        // 모든 토마토가 익어 있는 상태 확인
        boolean allRipe = true;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[h][n][m] == 0) {
                        allRipe = false;
                    }
                }
            }
        }
        if (allRipe) {
            System.out.println(0);
            return;
        }

        bfs();

        // BFS 종료 후, 익지 않은 토마토가 있는지 확인
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentTomato = queue.poll();
                int currentTomatoH = currentTomato[0];
                int currentTomatoN = currentTomato[1];
                int currentTomatoM = currentTomato[2];

                // 6방향 탐색
                for (int j = 0; j < 6; j++) {
                    int nh = currentTomatoH + dh[j];
                    int nn = currentTomatoN + dn[j];
                    int nm = currentTomatoM + dm[j];

                    if (nh >= 0 && nh < H && nn >= 0 && nn < N && nm >= 0 && nm < M) {
                        if (!visited[nh][nn][nm] && arr[nh][nn][nm] == 0) {
                            visited[nh][nn][nm] = true;
                            arr[nh][nn][nm] = 1;
                            queue.offer(new int[] { nh, nn, nm });
                        }
                    }
                }
            }
            cnt++; // 하루 경과
        }
    }
}
