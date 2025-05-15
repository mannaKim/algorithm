import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
         Map<Character, Integer> map = new HashMap<>();

        // 각 문자별 최소 입력 횟수 저장
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                // 이미 존재하는 경우 더 작은 값으로 갱신
                map.put(c, Math.min(map.getOrDefault(c, Integer.MAX_VALUE), i + 1));
            }
        }

        int[] answer = new int[targets.length];

        // 각 target 문자열에 대해 최소 횟수 계산
        for (int i = 0; i < targets.length; i++) {
            int total = 0;
            for (char c : targets[i].toCharArray()) {
                if (!map.containsKey(c)) {
                    total = -1;
                    break;
                }
                total += map.get(c);
            }
            answer[i] = total;
        }

        return answer;
    }
}