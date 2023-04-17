import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class bj1012 {

    public static int[][] graph;
    public static boolean[][] visit;
    public static int answer;
    public static int N;
    public static int M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());



        StringBuilder sb = new StringBuilder();
        for (int c = 0; c<count; c++) {
            answer = 0;
            int[] setting = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            M = setting[0];
            N = setting[1];
            int K = setting[2];
            graph = new int[N][M];
            visit = new boolean[N][M];
            for (int i = 0; i<K; i++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                graph[input[1]][input[0]] = 1;
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if (graph[i][j] == 1 && !visit[i][j]) {

                        dfs(i, j);
//                        System.out.println(i + " " + j + " " + temp);
                        answer++;
                    }
                }
            }

            sb.append(answer).append("\n");

        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return;
        }
        if (graph[x][y] == 0 || visit[x][y]) {
            return;
        }

        visit[x][y] = true;
        dfs(x+1, y);
        dfs(x-1, y);
        dfs(x, y+1);
        dfs(x, y-1);

    }
}

