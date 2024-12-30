import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n; // 테스트 케이스의 개수

    static int l; // 체스판의 한 변의 길이 (4<=l<=300)
    static Node currentPos; // 나이트가 현재 있는 칸
    static Node targetPos; // 나이트가 이동하려고 하는 칸

    static boolean[][] visited; // 방문 여부
    static Queue<Node> queue;

    // 이동 방향
    static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 }; // x축 이동
    static int[] dy = { 2, 1, -1, -2, -2, -1, 1, 2 }; // y축 이동

    // 이동 횟수
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            // 이동 횟수 초기화
            cnt = 0;
            // 큐 초기화
            queue = new LinkedList<>();

            // 체스판 한 변의 길이 l
            l = Integer.parseInt(br.readLine());

            // 방문 여부 배열 초기화 (0 ~ l-1)
            visited = new boolean[l][l];

            // 나이트가 현재 있는 좌표
            st = new StringTokenizer(br.readLine(), " ");
            currentPos = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            // 현재 좌표에 대해 방문 표시 및 inqueue
            visited[currentPos.x][currentPos.y] = true;
            queue.offer(currentPos);

            // 나이트의 목표 좌표
            st = new StringTokenizer(br.readLine(), " ");
            targetPos = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs();
            System.out.println(cnt);
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size(); // 같은 탐색 레벨의 노드 개수

            // 해당 레벨의 노드를 처리
            for (int i = 0; i < size; i++) {
                Node tempPos = queue.poll();

                // 목표 노드에 도달할 경우 리턴 (탐색 종료)
                if (tempPos.x == targetPos.x && tempPos.y == targetPos.y)
                    return;

                for (int j = 0; j < dx.length; j++) {
                    int nextX = tempPos.x + dx[j];
                    int nextY = tempPos.y + dy[j];

                    if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l) {
                        if (!visited[nextX][nextY]) {
                            queue.offer(new Node(nextX, nextY));
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
            // 레벨 탐색이 끝난 경우 이동 횟수 증가
            cnt++; // 현재 큐에 있는 노드들을 모두 탐색한 후, 그 다음 단계로 가면서 cnt 증가
        }
    }
}
