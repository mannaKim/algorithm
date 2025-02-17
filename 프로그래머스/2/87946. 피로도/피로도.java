import java.util.*;
class Solution {
    static int n;   // 던전 개수
    static boolean[] visited;   // 방문 여부
    static List<int[]> orderList = new ArrayList<>();  // 던전 방문 순서
    static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        
        dfs(k, dungeons);
        
        return answer;
    }
    private static void dfs(int k, int[][] dungeons) {
        // 던전 순서를 모두 뽑으면 종료
        if (orderList.size() == n) {
            /*for (int[] order : orderList) {
                System.out.print(Arrays.toString(order) + "\t");
            }
            System.out.println();*/

            int fatigue = k;  // 현재 피로도
            int count = 0;     // 탐험한 던전 수

            for (int[] dungeon : orderList) {
                int minRequiredFatigue = dungeon[0];    // 최소 필요 피로도
                int consumeFatigue = dungeon[1];        // 소모 피로도

                if (fatigue >= minRequiredFatigue) {
                    fatigue -= consumeFatigue;
                    count ++;
                } else {
                    break;
                }
            }

            // 최대 던전 수 갱신
            answer = Math.max(count, answer);

            return;
        }

        // 던전 하나씩 선택
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                orderList.add(dungeons[i]); // 현재 던전을 순서에 추가

                dfs(k, dungeons); // 다음 던전 뽑으러 가기

                // 원상 복구
                orderList.remove(orderList.size() - 1); // 마지막에 추가한 던전 제거
                visited[i] = false; // 방문 여부 되돌리기
            }
        }
    }
}