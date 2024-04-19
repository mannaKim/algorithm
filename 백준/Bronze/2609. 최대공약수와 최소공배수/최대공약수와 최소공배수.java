import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int min = a < b ? a : b;

        int divisor = 1, multiple;

        for (int i = min; i > 0; i--){
            if(a%i == 0 && b%i == 0){
                divisor = i;
                break;
            }
        }
        
        multiple = a * b / divisor;

        System.out.println(divisor);
        System.out.println(multiple);
    }
}
