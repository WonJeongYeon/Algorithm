import java.util.*;
import java.io.*;

public class bj2667 {

    public static int[][] graph;
    public static boolean[][] visit;
    public static List<Integer> answer;
    public static int N;
    public static int temp;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visit = new boolean[N][N];
        answer = new ArrayList<>();

        for (int i = 0; i<N; i++) {
            int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            graph[i] = input;
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                temp = 0;
                if (graph[i][j] == 1 && !visit[i][j]) {
                    dfs(i, j, 1, new boolean[N][N]);
                    answer.add(temp);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        Collections.sort(answer);
        for (int i: answer) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int x, int y, int count, boolean[][] isVisit) {
        if (graph[x][y] == 0 || isVisit[x][y]) {
            return;
        }

        temp++;
        visit[x][y] = true;
        isVisit[x][y] = true;
        int nx, ny;
        for (int i = 0; i<4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (check(nx, ny)) {
                dfs(nx, ny, count + 1, isVisit);
            }
        }

    }

    public static boolean check(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N && graph[nx][ny] != 0;
    }
}

