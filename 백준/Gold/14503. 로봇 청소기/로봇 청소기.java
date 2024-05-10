import java.io.*;
import java.util.*;

public class Main {
    static int N, M, r, c, d;
    static int[][] map;
    static int cnt = 0;

    static int[] dy = {-1, 0, 1, 0};    //북 동 남 서
    static int[] dx = {0, 1, 0, -1}; 
    static int[] leftD = {3, 0, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());   //0:북, 1:동, 2:남, 3:서

        map = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            // 청소가 안돼있는 경우에만 청소
            if (map[r][c] == 0) {
                map[r][c] = 2;
                cnt ++;
            }

            // 청소 여부에 따라 스위치 할 수 있도록 boolean 변수 선언
            boolean chk = false;

            // 현재 위치에서 반시계 방향(왼쪽 방향)으로 4방향 탐색
            int tempD = d;
            for (int i=0; i<4; i++) {
                // d=0(북)일 때 3(서)를 탐색
                // d=1(동)일 때 0(북)을 탐색
                // d=2(남)일 때 1(동)을 탐색
                // d=3(서)일 때 2(남)을 탐색
                int ld = leftD[tempD];
                int ny = r + dy[ld];
                int nx = c + dx[ld]; 
                if (ny>=0 && ny<N && nx>=0 && nx<M) {
                    // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                    if (map[ny][nx] == 0) {
                        // 그 방향으로 회전한 다음 한 칸을 전진
                        d = ld;
                        r = ny;
                        c = nx;
                        
                        chk = true;
                        break;
                    }
                }
                tempD = ld; // 현재 방향에서 다시 반시계 방향으로 탐색할 수 있도록 tempD 변경
            }
            // 네 방향 모두 청소되어 있는 경우
            if (chk == false) {
                int backY = r - dy[d];
                int backX = c - dx[d];
                // 뒤쪽 방향이 막혀있는지 확인
                if (backY>=0 && backY<N && backX>=0 && backX<M) {
                    if (map[backY][backX] == 1) break;
                    else {
                        // 바라보는 방향을 유지한 채로 한 칸 후진
                        r = backY;
                        c = backX;
                    }
                }
                else break;                
            }
        }

        System.out.println(cnt);
    }
}