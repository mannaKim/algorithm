import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n, k, rst, cnt = 0;
        n = scan.nextInt();
        k = scan.nextInt();

        for (int i=1; i<=n; i++){
            if (n%i==0) {
                cnt ++;
                if (cnt == k) {
                    System.out.println(i);
                    break;
                }
            }
        }
        if (cnt < k) {
            System.out.println(0);
        }
    }
}