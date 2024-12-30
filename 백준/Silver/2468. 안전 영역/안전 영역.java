import java.io.*;
import java.util.*;

public class Main {
    static int N; // NxN 2차원 배열 크기 (2<=N<=100)
    static int[][] arr; // 지역의 높이를 저장할 배열
    static boolean[][] visited; // 방문여부 배열
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = { 0, 1, 0, -1 }; // x축 탐색 방향
    static int[] dy = { 1, 0, -1, 0 }; // y축 탐색 방향

    static int maxHeight = 0; // 지도에서 가장 높은 지역의 높이
    static int rainHeight; // 비의 높이

    static int cnt; // 안전한 영역의 개수
    static int maxCnt = 0; // 안전한 영역의 최대 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        // 배열 초기화
        arr = new int[N][N];

        // 지역의 높이 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                arr[i][j] = height;
                maxHeight = Math.max(maxHeight, height); // 입력된 높이 중 가장 높은 높이 저장
            }
        }

        // 비의 높이에 따라 bfs 실행
        // 비가 0 ~ maxHeight까지 내리는 경우에 대해 모두 탐색
        for (int k = 0; k < maxHeight; k++) {
            cnt = 0; // 안전한 영역 개수 초기화
            rainHeight = k; // 비의 높이
            queue = new LinkedList<>(); // 큐 초기화
            visited = new boolean[N][N]; // 방문 여부 초기화

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 물에 잠기지 않고 아직 방문하지 않은 지역
                    if (!visited[i][j] && arr[i][j] > rainHeight) {
                        queue.offer(new int[] { i, j }); // BFS 시작점 큐에 추가
                        visited[i][j] = true; // 방문 처리
                        bfs(); // BFS 탐색 시작
                        cnt++; // 새로운 안전 영역 발견 시 개수 증가
                    }
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        // 안전한 영역의 최대 개수 출력
        System.out.println(maxCnt);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (!visited[nextX][nextY] && arr[nextX][nextY] > rainHeight) {
                        queue.offer(new int[] { nextX, nextY });
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}