import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arrN, arrM;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arrN = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
        	arrN[i] = Integer.parseInt(st.nextToken());
        }
        
        M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<M; i++) {
        	arrM[i] = Integer.parseInt(st.nextToken());
        }
        
        // 탐색할 배열(arrN)을 오름차순 정렬
        Arrays.sort(arrN);
        
        // arrN에 arrM의 각요소가 존재하는지 이진탐색하여 결과 출력
        for (int i=0; i<M; i++) {
        	System.out.println(binarySearch(arrN, 0, N-1, arrM[i]));
        }
        
    }
    public static int binarySearch(int[] arr, int low, int high, int key) {
        // 1. 높은 인덱스가 낮은 인덱스보다 크거나 같은지 확인합니다.
        if (high >= low) {

            // 2. 중간 값을 구합니다.
            int mid = low + (high - low) / 2;

            // 3. 배열의 요소 값이 찾는 값과 동일하면 1을 반환합니다.
            if (arr[mid] == key) {
                return 1;
            }
            // 4. 중간 값이 키보다 큰 경우 : 낮은 인덱스와 중간 인덱스에서 1을 뺀 값을 가지고 함수를 재귀적으로 호출합니다.
            else if (arr[mid] > key) {
                return binarySearch(arr, low, mid - 1, key);
            }
            // 5. 중간 값이 키보다 작은 경우 : 중간 인덱스에 1을 더하고 높은 인덱스와 함께 함수를 재귀적으로 호출합니다
            else {
                return binarySearch(arr, mid + 1, high, key);
            }
        }

        // 6. 높은 인덱스가 낮은 인덱스보다 작으면 배열에서 키를 찾지 못했음을 나타내기 위해 0을 반환합니다.
        return 0;
    }
}