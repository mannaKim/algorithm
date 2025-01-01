import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 중복을 제거하고 저장하기 위해 Set 선언
        Set<String> strSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            strSet.add(br.readLine());
        }

        // 정렬을 하기 위해 Set을 List로 변환
        List<String> strList = new ArrayList<>(strSet);
        // List.sort()에 정렬 기준 적용
        strList.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2); // 길이가 같다면 사전순 정렬
            }
            return Integer.compare(o1.length(), o2.length()); // 길이순 정렬
        });

        // 출력
        for (String str : strList) {
            System.out.println(str);
        }
    }
}