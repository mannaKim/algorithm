import java.util.*;

public class Main {
    static boolean[][] visited; // 방문 여부 배열 선언
    static int S; // 목표 이모티콘 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt(); // 목표 이모티콘 개수

        visited = new boolean[2001][2001]; // 최대 화면, 클립보드 개수는 2000까지 가능
        System.out.println(bfs()); // BFS 실행 및 결과 출력
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0, 0}); // 초기 상태: 화면 1개, 클립보드 0개, 시간 0초
        visited[1][0] = true; // 화면 1개, 클립보드 0개 방문 처리

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int screen = current[0]; // 화면 이모티콘 개수
            int clipboard = current[1]; // 클립보드 이모티콘 개수
            int time = current[2]; // 현재까지 소요된 시간

            // 종료 조건: 화면 이모티콘 개수가 S개일 때
            if (screen == S) {
                return time; // 최소 시간 반환
            }

            // 연산 1: 복사
            if (!visited[screen][screen]) { // 현재 화면을 클립보드에 복사
                visited[screen][screen] = true;
                queue.offer(new int[]{screen, screen, time + 1});
            }

            // 연산 2: 붙여넣기
            if (clipboard > 0 && screen + clipboard <= 2000) { // 클립보드 붙여넣기
                if (!visited[screen + clipboard][clipboard]) {
                    visited[screen + clipboard][clipboard] = true;
                    queue.offer(new int[]{screen + clipboard, clipboard, time + 1});
                }
            }

            // 연산 3: 삭제
            if (screen > 0) { // 화면에서 1개 삭제
                if (!visited[screen - 1][clipboard]) {
                    visited[screen - 1][clipboard] = true;
                    queue.offer(new int[]{screen - 1, clipboard, time + 1});
                }
            }
        }
        return -1; // 도달할 수 없는 경우 (문제에서는 발생하지 않음)
    }
}