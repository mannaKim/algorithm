import java.io.*;
import java.util.*;

public class Main {
    static int n;
    
    static int[][] map;
    static boolean[][] visited;
    
    static int count = 0;
    static ArrayList<Integer> resultArr;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Pos {
        int y, x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<n; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        resultArr = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        //resultArr.sort(Comparator.naturalOrder());
        Collections.sort(resultArr);
        
        System.out.println(count);
        for (int i=0; i<resultArr.size(); i++) {
            System.out.println(resultArr.get(i));
        }
    }

    public static void bfs(int y, int x) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(y, x));
        int numOfHouse = 1;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int i=0; i<4; i++) {
                int tempY = now.y + dy[i];
                int tempX = now.x + dx[i];

                if (tempY>=0 && tempX>=0 && tempY<n && tempX<n) {
                    if (map[tempY][tempX] == 1 && !visited[tempY][tempX]) {
                        visited[tempY][tempX] = true;
                        numOfHouse ++;
                        queue.add(new Pos(tempY, tempX));
                    }
                }
            }
        }

        resultArr.add(numOfHouse);
    }
}