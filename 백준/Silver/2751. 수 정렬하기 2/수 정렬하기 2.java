import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        while(num-- > 0)
            pQ.add(Integer.parseInt(br.readLine()));
        while(!pQ.isEmpty())
            bw.write(pQ.remove()+"\n");
        bw.close();
    }
}