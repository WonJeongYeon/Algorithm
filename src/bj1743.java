import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj1743 {

    public static int N, M, K;
    public static int[][] graph;
    public static boolean[][] visit;
    public static int answer = 0;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] init = br.readLine().split(" ");
        N = Integer.parseInt(init[0]);
        M = Integer.parseInt(init[1]);
        K = Integer.parseInt(init[2]);
        graph = new int[N][M];
        visit = new boolean[N][M];

        int x, y;
        for (int i = 0; i < K; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            x = input[0] - 1;
            y = input[1] - 1;
            graph[x][y]++;
        }
        Queue<int[]> q = new LinkedList<>();
        int nx, ny;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != 1 || visit[i][j]) {
                    continue;
                }
                q.offer(new int[]{i, j});
                visit[i][j] = true;
                while (!q.isEmpty()) {
                    int[] p = q.poll();
                    for (int k = 0; k < 4; k++) {
                        nx = p[0] + dx[k];
                        ny = p[1] + dy[k];
                        if (check(nx, ny)) {
                            q.offer(new int[]{nx, ny});
                            visit[nx][ny] = true;
                            cnt++;
                        }
                    }
                }
                answer = Math.max(answer, cnt);
                cnt = 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean check(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M && graph[nx][ny] == 1 && !visit[nx][ny];
    }
}
