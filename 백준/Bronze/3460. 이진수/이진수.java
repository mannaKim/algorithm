import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int T;
        T = Integer.parseInt(scan.nextLine());
        
        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(scan.nextLine());
            int index = 0;

            while (n>0) {
                if (n%2==1) {
                    System.out.printf("%d ", index);
                }
                n /= 2;
                index ++;
            }
            System.out.println();
        }
    }
}