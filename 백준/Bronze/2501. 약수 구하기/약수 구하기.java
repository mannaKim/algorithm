import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n, k;
        n = scan.nextInt();
        k = scan.nextInt();

        ArrayList<Integer> divisor = new ArrayList<Integer>();

        for (int i=1; i<=n; i++){
            if (n%i==0) {
                divisor.add(i);
                if (divisor.size() == k) {
                    System.out.println(divisor.get(k-1));
                    break;
                }
            }
        }
        if (divisor.size() < k) {
            System.out.println(0);
        }
    }
}