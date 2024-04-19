import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int fibo = 0;
        int f1 = 0;
        int f2 = 1;

        if (n == 0) {
            fibo = 0;
        }
        else if (n == 1) {
            fibo = 1;
        }
        else {
            for (int i=2; i<=n; i++){
                fibo = f1 + f2;
                f1 = f2;
                f2 = fibo;
            }
        }
    
        System.out.print(fibo);
    }
}
