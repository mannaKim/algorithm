class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0; // 기준 문자와 같은 문자 개수
        int diff = 0; // 기준 문자와 다른 문자 개수
        char x = s.charAt(0); // 기준 문자 초기값 설정

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == x) same++;
            else diff++;

            // 같은 수와 다른 수가 같아지면 문자열 분리
            if (same == diff) {
                answer++;
                same = 0;
                diff = 0;
                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1); // 다음 기준 문자 설정
                }
            }
        }

        // 마지막 분리되지 않은 문자열도 카운트
        if (same != 0 || diff != 0) {
            answer++;
        }

        return answer;
    }
}