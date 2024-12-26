import java.io.*;
import java.util.*;

public class Main {
        public static int[] stack;
        public static int size = 0;

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        stack = new int[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            if (str.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                push(num);
            } else if (str.equals("pop")){
                bw.write(pop()+"\n");
            } else if (str.equals("size")){
                bw.write(size()+"\n");
            } else if (str.equals("empty")){
                bw.write(empty()+"\n");
            } else if (str.equals("top")){
                bw.write(top()+"\n");
            }
        }
        bw.close();
    }
    
    /* push X: 정수 X를 스택에 넣는 연산이다. */
    public static void push(int num) {
        stack[size] = num;
        size ++;
    }

    /* pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 
            만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다. */
    public static int pop() {
        
        if (size == 0) {
            // 스택 size가 0이면, 데이터가 없는 경우이므로 -1 반환
            return -1;
        } else {
            // 반환 할 값은 size-1번째 인덱스; push에서 size인덱스에 입력받은 값을 넣고, size는 ++해주기 때문에
            int result = stack[size-1]; 
            stack[size-1] = 0;  // result에 pop할 값을 넣었으므로, 0으로 초기화
            size --;
            return result;
        }
    }

    /* size: 스택에 들어있는 정수의 개수를 출력한다. */
    public static int size() {
        return size;
    }

    /* empty: 스택이 비어있으면 1, 아니면 0을 출력한다. */
    public static int empty() {
        if (size == 0) {
            // 스택 size가 0이면, 스택이 비어있는 경우이므로 1 반환
            return 1;
        } else {
            return 0;
        }
    }

    /* top: 스택의 가장 위에 있는 정수를 출력한다. 
            만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다. */
    public static int top() {
        if (size == 0) {
            // 스택 size가 0이면, 스택에 들어있는 정수가 없는 경우이므로 -1 반환
            return -1;
        } else {
            // 반환 할 값은 size-1번째 인덱스; push에서 size인덱스에 입력받은 값을 넣고, size는 ++해주기 때문에
            return stack[size-1];
        }
    }
}