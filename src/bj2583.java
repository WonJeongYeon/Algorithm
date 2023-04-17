import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2583 {
    public static int[][] graph;

    public static int N;
    public static int M;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = init[0];
        M = init[1];
        int K = init[2];
        graph = new int[N][M];

        for (int i = 0; i<K; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = input[0]; j<input[2]; j++) {
                for (int k = input[1]; k<input[3]; k++) {
                    graph[k][j]++;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int x, y;
        int nx, ny;


        for (int i = 0; i<N; i++) {
            for (int j = 0; j<M; j++) {
                if (graph[i][j] != 0) {
                    continue;
                }
                int count = 1;
                graph[i][j]++;
                q.offer(new int[]{i, j});
                while (!q.isEmpty()) {
                    int[] data = q.poll();
                    x = data[0];
                    y = data[1];

                    for (int k = 0; k<4; k++) {
                        nx = x+dx[k];
                        ny = y+dy[k];
                        if (check(nx, ny)) {
                            q.offer(new int[]{nx, ny});
                            graph[nx][ny]++;
                            count++;
                        }
                    }
                }
                pq.offer(count);

            }
        }
        System.out.println(pq.size());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);

    }

    public static boolean check(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M && graph[nx][ny] == 0;
    }
}
