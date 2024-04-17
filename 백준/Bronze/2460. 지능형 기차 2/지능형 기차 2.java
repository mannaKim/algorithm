import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int max = 0;
        int people = 0;

        for (int i=0; i<10; i++){
            int out = scan.nextInt();
            int in = scan.nextInt();

            if (i==0) {
                max = in;
                people = in;
            }
            else {
                people = people - out + in;
                if(people > max) {
                    max = people;
                }
            }
        }
        System.out.print(max);
    }
}