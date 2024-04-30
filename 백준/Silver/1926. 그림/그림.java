import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 좌표(position) 클래스 선언, 생성자 생성
    static class Pos {
        int y, x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    // 도화지 정보를 저장하는 2차원 배열 (그래프)
    static int[][] map;

    // 도화지 노드를 방문했는지 확인하는 2차원 배열
    static boolean[][] visited;

    // 상하좌우 y 변경 값
    static int[] dy = {-1, 1, 0, 0};

    // 상하좌우 x 변경 값
    static int[] dx = {0, 0, -1, 1};

    // 문제에서 주어진 세로크기 n, 가로크기 m, 가장 넓은 그림의 넓이 max_width
    static int n, m, max_width = 0;

    public static void main(String[] args) throws IOException {
        // 입력값 처리할 버퍼리더
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 결과값 출력할 버퍼라이터
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 문자열 토큰형식으로 다룰 스트링토커나이저
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // 입력값 저장
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        // 도화지 정보 저장
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 그림 개수 저장할 변수 선언
        int cnt = 0;

        // 방문하지 않은 칠해진 노드(값이 1)를 기준으로 BFS 탐색
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    // 값이 1이고 방문하지 않은 노드일 경우 BFS 탐색
                    visited[i][j] = true;   // 다음에는 방문하지 않도록 방문 확인
                    bfs(i,j);               // BFS 탐색 호출
                    cnt ++;                 // 그림 개수 증가
                }
            }
        }

        //그림 개수와 그림 최대 넓이 BufferedWriter 저장
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n").append(max_width);
        bw.write(sb.toString());
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }

    // BFS 탐색을 위한 함수
    static void bfs(int y, int x) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(y, x));   // 시작 위치 Queue에 저장
        int width = 1;

        // 탐색
        while (!queue.isEmpty()) {
            Pos cur = queue.poll(); // 큐의 첫번째 요소로 초기화 (큐의 첫번째 요소는 삭제 됨)
            // 상하좌우 탐색 진행
            for (int i=0; i<4; i++) {
                int tempY = cur.y + dy[i];
                int tempX = cur.x + dx[i];
                // 해당 좌표가 방문하지 않은 1일 경우
                if (inSpace(tempY, tempX) && !visited[tempY][tempX] && map[tempY][tempX] == 1) {
                    visited[tempY][tempX] = true;       // 방문 확인
                    queue.add(new Pos(tempY, tempX));   // Queue에 다음 방문 노드로 저장
                    width ++;
                }
            }
        }
        // 방금 구한 넓이가 최대 넓이인지 확인
        max_width = Math.max(max_width, width);
    }

    // (y, x)가 도화지에 존재하는지 확인하는 함수
    static boolean inSpace(int y, int x) {
        if(y >= 0 && x >= 0 && y < n && x < m)
            return true;        //도화지가 존재할 때
        else 
            return false;		//도화지에 존재하지 않을 때
    }
}