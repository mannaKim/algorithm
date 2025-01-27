import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 남은 일수를 queue로 저장
        Deque<Integer> remainingDays = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int days = (int) Math.ceil((100 - progress) / (double) speed);
            remainingDays.offer(days);
        }

        List<Integer> answer = new ArrayList<>();
        while (!remainingDays.isEmpty()) {
            int deployDay = remainingDays.poll();
            int deployCount = 1;

            // 몇 개의 기능이 배포 가능한지 count
            while (!remainingDays.isEmpty() && remainingDays.peek() <= deployDay) {
                remainingDays.poll();
                deployCount++;
            }

            answer.add(deployCount);
        }
        
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}