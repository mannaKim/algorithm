import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        String[] numArr = numbers.split(" ");
        int count = 0;

        for (int i = 0; i < numArr.length; i++){
            int numOfDivisor = 0;
            int num = Integer.parseInt(numArr[i]);
            for (int j = 1 ; j <= num; j++){
                if (num % j == 0) {
                    numOfDivisor++;
                }
                if (numOfDivisor > 2) {
                    break;
                }
                if (j == num && numOfDivisor == 2) {
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
}
