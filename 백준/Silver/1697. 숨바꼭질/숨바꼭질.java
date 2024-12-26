import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int position;   // 현재 위치
        int time;       // 걸린 시간

        public Node(int pos, int time) {
            this.position = pos;
            this.time = time;
        }
    }
    static int N;
    static int K;
    static Queue<Node> queue = new LinkedList<>();
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue.offer(new Node(N, 0));
        visited[N] = true;
        bfs();
    }
    public static void bfs() {
        // 큐가 빌때까지 반복
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int pos = currentNode.position;
            int time = currentNode.time;

            // 현재 노드의 위치가 K와 같다면 시간 반환
            if (pos == K) {
                System.out.println(time);
                break;
            }

            // 이동할 수 있는 position들을 배열로 저장하여 하나씩 queue에 넣을 조건이 되는지 판별
            int[] nextPos = {pos-1, pos+1, pos*2};
            for (int next : nextPos) {
                // position의 범위가 0 <= pos <= 100000이고, 방문한 적 없는 노드인지 확인
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;   // 방문 표시
                    queue.offer(new Node(next, time + 1));  // queue에 넣기
                }
            }
        }
    }
}