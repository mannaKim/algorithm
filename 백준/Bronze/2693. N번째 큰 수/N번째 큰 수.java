import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            String s = br.readLine();
            
            String[] arr = s.split(" ");
            int[] intArr = new int[arr.length];

            for (int j = 0; j < arr.length; j++){
                intArr[j] = Integer.parseInt(arr[j]);
            }

            Arrays.sort(intArr);
            System.out.println(intArr[10-3]);
        }
    }
}
