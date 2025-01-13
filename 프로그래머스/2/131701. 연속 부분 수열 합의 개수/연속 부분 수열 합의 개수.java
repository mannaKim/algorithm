import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        
        for (int i = 0; i < elements.length; i++) {
            // 인덱스가 i일 때
            int result = 0;
            for (int j = i; j < i + elements.length; j++) {
                // 길이가 j일 때
                result += elements[j % elements.length];
                answer.add(result);
            }
        }
        
        return answer.size();
    }
}