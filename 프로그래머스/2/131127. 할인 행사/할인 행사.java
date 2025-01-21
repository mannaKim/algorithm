import java.util.HashMap;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> wantQuantity = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantQuantity.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> currentQuantity = new HashMap<>();
            // 10일 단위로 탐색
            for (int j = i; j < i + 10; j++) {
                currentQuantity.put(discount[j],
                        currentQuantity.getOrDefault(discount[j], 0) + 1);
            }

            // 10일 연속 부분배열 찾기
            boolean isSatisfied = true;
            for (String product : wantQuantity.keySet()) {
                // 현재 10일 단위의 HashMap(currentQuantity)에 저장된 개수가
                // 원하는 할인 상품 개수(wantQuantity)보다 작으면
                // 다음 10일을 탐색하도록 break
                if (currentQuantity.getOrDefault(product, 0) < wantQuantity.get(product)) {
                    isSatisfied = false;
                    break;
                }
            }

            if (isSatisfied) answer++;
        }
        
        return answer;
    }
}