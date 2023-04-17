import java.util.*;
import java.io.*;

public class bj10026 {

    public static int N;
    public static char[][] graph;
    public static boolean[][] visit;
    public static int answer_normal;
    public static int answer_color;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i<N; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        answer_color = 0;
        answer_normal = 0;

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (!visit[i][j]) {
                    dfs_normal(i, j, graph[i][j]);
                    answer_normal++;
                }
            }
        }

        visit = new boolean[N][N];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (!visit[i][j]) {
                    dfs_color(i, j, graph[i][j]);
                    answer_color++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer_normal).append(" ").append(answer_color);
        System.out.println(sb);

    }

    public static void dfs_normal(int x, int y, char color) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return;
        }
        if (visit[x][y]) {
            return;
        }
        if (graph[x][y] != color) {
            return;
        }
        visit[x][y] = true;

        dfs_normal(x+1, y, color);
        dfs_normal(x-1, y, color);
        dfs_normal(x, y+1, color);
        dfs_normal(x, y-1, color);
    }

    public static void dfs_color(int x, int y, char color) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return;
        }
        if (visit[x][y]) {
            return;
        }
        if (color == 'R' || color == 'G') {
            if (graph[x][y] == 'B') {
                return;
            }
        } else {
            if (graph[x][y] != 'B') {
                return;
            }
        }
        visit[x][y] = true;

        dfs_color(x+1, y, color);
        dfs_color(x-1, y, color);
        dfs_color(x, y+1, color);
        dfs_color(x, y-1, color);
    }


}
