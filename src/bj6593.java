import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj6593 {

    public static int L, R, C;
    public static char[][][] graph;
    public static boolean[][][] visit;
    public static int[] dx = {0, 0, 1, -1, 0, 0};
    public static int[] dy = {1, -1, 0, 0, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0")) {
                break;
            }
            int[] init = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            L = init[0];
            R = init[1];
            C = init[2];
            graph = new char[L][R][C];

            visit = new boolean[L][R][C];

            int[] start = new int[4];
            for (int i = 0; i<L; i++) {
                for (int j = 0; j<R; j++) {
                    graph[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k<C; k++) {
                        if (graph[i][j][k] == 'S') {
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                            start[3] = 0;
                            visit[i][j][k] = true;
                            break;
                        }
                    }
                }
                br.readLine();
            }


            boolean b = false;
            Queue<int[]> q = new LinkedList<>();
            q.offer(start);
            int x, y, z;
            while (!q.isEmpty()) {
                int[] pos = q.poll();
                x = pos[0];
                y = pos[1];
                z = pos[2];
                if (graph[x][y][z] == 'E') {
                    answer = pos[3];
                    b = true;
                    System.out.println("Escaped in " + answer + " minute(s).");
                    break;
                }
                int nx, ny, nz;
                for (int i = 0; i<6; i++) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                    nz = z + dz[i];

                    if (check(nx, ny, nz)) {
                        q.offer(new int[]{nx, ny, nz, pos[3]+1});
                        visit[nx][ny][nz] = true;
                    }
                }
            }
            if (!b) {
                System.out.println("Trapped!");
            }

        }
    }

    public static boolean check(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < L && y < R && z < C && (graph[x][y][z] == '.'|| graph[x][y][z] == 'E') && !visit[x][y][z];
    }
}
