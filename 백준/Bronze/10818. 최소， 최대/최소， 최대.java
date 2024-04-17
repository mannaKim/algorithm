import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int N;
        N = Integer.parseInt(scan.nextLine());

        int min, max;
        min = scan.nextInt();
        max = min;
        
        for (int i=1; i<N; i++) {
            int n = scan.nextInt();

            if (min > n) {
                min = n;
            } 
            if (max < n) {
                max = n;
            }
        }
        System.out.printf("%d %d", min, max);
    }
}