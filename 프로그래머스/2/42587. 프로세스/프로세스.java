import java.util.*;

class Solution {
    class Process {
        int index;
        int priority;

        Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Deque<Process> processes = new ArrayDeque<>();
        PriorityQueue<Integer> maxPriorities = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            processes.offer(new Process(i, priorities[i]));
            maxPriorities.offer(priorities[i]);
        }

        while (!processes.isEmpty()) {
            Process currentProcess = processes.poll();
            if (currentProcess.priority != maxPriorities.peek()) {
                processes.offer(currentProcess);
                continue;
            }

            answer ++;
            maxPriorities.poll();

            if (currentProcess.index == location) break;
        }
        
        return answer;
    }
}