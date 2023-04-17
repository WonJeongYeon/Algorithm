import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1189 {
    public static int R, C, K;
    public static char[][] graph;
    public static int answer = 0;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        R = init[0];
        C = init[1];
        K = init[2];
        graph = new char[R][C];
        for (int i = 0; i<R; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        graph[R-1][0] = 'a';
        dfs(R-1, 0, 1);

        System.out.println(answer);

    }

    public static void dfs(int x, int y, int count) {

//        for (char[] i: graph) {
//            System.out.println(Arrays.toString(i));
//
//        }
//        System.out.println(count);
//        System.out.println();

        if (x == 0 && y == C-1) {
            if (count == K) {
                answer++;
            }
            graph[x][y] = '.';
            return;
        }
        if (K < count) {
            graph[x][y] = '.';
            return;
        }
        int nx, ny;
        for (int i = 0; i<4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (check(nx, ny)) {
                graph[nx][ny] = 'a';
                dfs(nx, ny, count+1);
            }
        }
            graph[x][y] = '.';

    }

    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C && graph[x][y] == '.';
    }
}
