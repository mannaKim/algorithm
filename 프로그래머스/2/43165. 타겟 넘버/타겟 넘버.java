import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        return bfs(target, numbers);
    }
    private static int bfs(int target, int[] numbers) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>(); // {sum, index} 형태
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int sum = current[0];
            int index = current[1];

            if (index == numbers.length) {
                if (sum == target) answer ++;
            }
            else {
                queue.offer((new int[]{sum + numbers[index], index + 1}));
                queue.offer((new int[]{sum - numbers[index], index + 1}));
            }
        }
        return answer;
    }
}