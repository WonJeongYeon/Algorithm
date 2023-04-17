import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj7576 {

    public static int[][] graph;
    public static int N, M;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static int time = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = init[1];
        M = init[0];

        graph = new int[N][M];
        int require = 0;
        int tried = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i<N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j<M; j++) {
                if (input[j] == 1) {
                    q.offer(new int[]{i, j, 0});
                }
                if (input[j] == 0) {
                    require++;
                }
            }
            graph[i] = input;
        }
        int x, y, t;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            x = pos[0];
            y = pos[1];
            t = pos[2];
            int nx, ny;
            for (int i = 0; i<4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (check(nx, ny)) {
                    q.offer(new int[]{nx, ny, t+1});
                    graph[nx][ny] = 1;
                    tried++;
                }
            }
            time = t;

        }
        if (tried == require) {
            System.out.println(time);
        } else {
            System.out.println(-1);
        }


    }

    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && graph[x][y] == 0;
    }
}
