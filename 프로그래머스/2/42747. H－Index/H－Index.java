import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // int[] 배열을 ArrayList<Integer>로 변환
        ArrayList<Integer> citationList = IntStream.of(citations)   // 1. int[]를 IntStream으로 변환
                .boxed()                                            // 2. IntStream을 Stream<Integer>로 변환 (박싱)
                .sorted()                                           // 3. Stream<Integer>를 오름차순 정렬
                .collect(Collectors.toCollection(ArrayList::new));  // 4. Stream<Integer>를 ArrayList로 변환

        for (int i=0; i<citationList.size(); i++) {
            // 현재 논문의 인용 횟수 >= 남은 논문 수
            if (citationList.get(i) >= citationList.size()-i) {
                answer = Math.max(answer, citationList.size()-i);
            }
        }
        
        return answer;
    }
}