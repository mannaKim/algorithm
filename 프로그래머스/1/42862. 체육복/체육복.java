import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Set<Integer> lostSet = new HashSet<>();
        for (int l : lost)
            lostSet.add(l);

        Set<Integer> reserveSet = new HashSet<>();
        for (int r : reserve)
            reserveSet.add(r);

        Set<Integer> intersection = new HashSet<>(lostSet);
        intersection.retainAll(reserveSet); // 교집합

        // 겹치는 학생 제거
        lostSet.removeAll(intersection);
        reserveSet.removeAll(intersection);

        int[] clothes = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            clothes[i] = 1;
        }

        for (int l : lostSet) {
            clothes[l]--;
        }
        for (int r : reserveSet) {
            clothes[r]++;
        }

        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0 && clothes[i - 1] == 2) {
                clothes[i]++;
                clothes[i - 1]--;
            } else if (clothes[i] == 0 && clothes[i + 1] == 2) {
                clothes[i]++;
                clothes[i + 1]--;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1)
                answer++;
        }
        
        return answer;
    }
}