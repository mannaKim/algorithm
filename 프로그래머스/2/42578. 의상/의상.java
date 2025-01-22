import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> categoryQuantity = new HashMap<>();
        for (String[] clothe : clothes) {
            String category = clothe[1];
            int quantity = categoryQuantity.getOrDefault(category, 0) + 1;
            categoryQuantity.put(category, quantity);
        }

        // 서로 다른 옷의 조합의 수 계산
        int answer = categoryQuantity.values().stream()
                .reduce(1, (tempAnswer, quantity) -> tempAnswer * (quantity + 1));

        // 아무것도 착용하지 않은 경우를 제외
        answer --;
        
        return answer;
    }
}