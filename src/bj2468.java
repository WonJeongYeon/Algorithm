import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj2468 {
    public static int N;
    public static int[][] graph;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int height = 0;
        graph = new int[N][N];
        for (int i = 0; i < N; i++) { //그래프 입력
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[i] = input;
            for (int j: input) {
                height = Math.max(height, j); //배열 요소의 최대값 저장
            }
        }

        int x, y, nx, ny;
        Queue<int[]> q = new LinkedList<>();

        int answer = 0;
        for (int l = 0; l <= height; l++) { //0부터 최대값까지의 경우의 수
            int max = 0;
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] <= l || visit[i][j]) {
                        continue;
                    }
                    visit[i][j] = true;
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) { //BFS 탐색
                        int[] data = q.poll();
                        x = data[0];
                        y = data[1];
                        for (int k = 0; k < 4; k++) {
                            nx = x + dx[k];
                            ny = y + dy[k];
                            if (check(nx, ny, l)) {
                                q.offer(new int[]{nx, ny});
                                visit[nx][ny] = true;
                            }
                        }
                    }
                    max++;
                }
            }
            answer = Math.max(max, answer);
        }
        System.out.println(answer);
    }

    public static boolean check(int nx, int ny, int l) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N && graph[nx][ny] > l && !visit[nx][ny];
    }
}
