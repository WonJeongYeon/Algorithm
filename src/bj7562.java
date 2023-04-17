import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj7562 {

    public static int answer = 0;
    public static int length = 0;
    public static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    public static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
    public static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<N; i++) {
            answer = 0;
            length = Integer.parseInt(br.readLine());
            int[] cur = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] des = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph = new int[length][length];
            graph[cur[0]][cur[1]] = 1;
            Queue<int[]> q = new LinkedList<>();
            int x, y;
            q.offer(new int[]{cur[0], cur[1], 0});
            while (!q.isEmpty()) {
                int[] pos = q.poll();
                x = pos[0];
                y = pos[1];
                if (x == des[0] && y == des[1]) {
                    answer = pos[2];
                    break;
                }

                int nx, ny;
                for (int j = 0; j<8; j++) {

                    nx = x + dx[j];
                    ny = y + dy[j];
                    if (check(nx, ny)) {
                        q.offer(new int[]{nx ,ny, pos[2]+1});
                        graph[nx][ny] += pos[2]+1;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < length && y < length && graph[x][y] == 0;
    }
}
