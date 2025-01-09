import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> sizeCount = new HashMap<>();
        for (int size : tangerine) {
            sizeCount.put(size, sizeCount.getOrDefault(size, 0) + 1);
        }

        ArrayList<Integer> sortedCount = new ArrayList<>(sizeCount.values());
        sortedCount = (ArrayList<Integer>) sortedCount.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        
        for (int cnt : sortedCount) {
            k -= cnt;
            answer ++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}