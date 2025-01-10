import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if (s.length()%2 == 0) {
            for (int i=0; i<s.length(); i++) {
                Deque<Character> stack = new ArrayDeque<>();
                for (int j=0; j<s.length(); j++) {
                    char chk = s.charAt((i+j) % s.length());
                    switch (chk) {
                        case ')':
                            if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                            break;
                        case '}':
                            if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                            break;
                        case ']':
                            if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                            break;
                        default:
                            stack.push(chk);
                            break;
                    }
                }
                if (stack.isEmpty()) answer++;
            }
        }
        
        return answer;
    }
}