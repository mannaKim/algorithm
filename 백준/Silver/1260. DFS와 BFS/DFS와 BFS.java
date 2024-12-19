import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int N;
    static int M;
    static int V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());   // 정점의 개수
        M = Integer.parseInt(st.nextToken());   // 간선의 개수
        V = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점의 번호

        arr = new int[N+1][N+1];    // 1부터 사용하기 위해 +1하여 배열 생성 (0~N-1이 아니라 1~N)

        // 간선의 개수만큼 반복문을 돌며 간선 정보 저장
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 간선이 양방향이기 때문에 [a][b]와 [b][a]를 모두 1로 저장
            arr[a][b] = arr[b][a] = 1;
        }

        visited = new boolean[N+1]; // 정점 방문 여부
        dfs(V);

        System.out.println();

        visited = new boolean[N+1]; // 정점 방문 여부 초기화 (dfs의 방문 여부가 저장되어 있기 때문에)
        bfs(V);        
    }

    // 깊이 우선 탐색 : DFS
    static void dfs(int v) {
        visited[v] = true;  // 방문 여부 true로 변경하고
        System.out.print(v + " ");  // 출력

        // 정점의 개수만큼 반복문을 돌며 v정점과 다른 정점간의 간선 유무, 방문 여부 확인
        for(int i=1; i<=N; i++) {
            if (arr[v][i] == 1 && visited[i] == false) {
                dfs(i); // 간선이 존재하고 방문하지 않은 정점이면 해당 정점으로 재귀호출
            }
        }
    }

    // 너비 우선 탐색 : BFS
    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);   // queue에 정점 추가
        visited[v] = true;  // 방문 여부 true로 변경하고
        System.out.print(v + " ");  // 출력

        // queue가 빌 때 까지 반복문을 돌며 간선 유무, 방문 여부 확인
        while(!queue.isEmpty()) {
            int temp = queue.poll();    // queue에서 꺼낸 정점을 temp에 대입
            
            // 정점의 개수만큼 반복문을 돌며 temp정점과 다른 정점의 간선 유무, 방문 여부 확인
            for (int i=1; i<=N; i++) {
                if (arr[temp][i] == 1 && visited[i] == false) {
                    // 간선이 존재하고 방문하지 않은 정점이면
                    queue.add(i);   // 해당 정점을 queue에 넣고
                    visited[i] = true;  // 방문여부를 true로 변경
                    System.out.print(i + " ");  // 출력
                }
            }
        }
    }
}