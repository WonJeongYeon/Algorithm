package bj2667;

import java.util.*;
import java.io.*;

public class bj2667 {

    public static int[][] graph;
    public static boolean[][] visit;
    public static List<Integer> answer;
    public static int N;
    public static int num;
    public static int temp;
    public static int xP = 0;
    public static int yP = 0;
    public static int[] dirX = new int[]{0, 0, -1, 1};
    public static int[] dirY = new int[]{-1, 1, 0, 0};
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

        num = 0;
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {

                if (graph[i][j] == 1 && !visit[i][j]) {
                    num++;
                    temp = 0;
                    dfs(i, j);
                    System.out.println(i + " " + j + " " + temp);
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

    public static void dfs(int x, int y) {


//        if (graph[x][y] == 0 || isVisit[x][y]) {
//            temp = Math.max(temp, count-1);
//            return;
//        }

        temp++;
        visit[x][y] = true;
        graph[x][y] = num;

        for (int i = 0; i<4; i++) {
            xP = x + dirX[i];
            yP = y + dirY[i];
            if (check() && graph[xP][yP] == 1 && !visit[xP][yP]) {
                visit[xP][yP] = true;
                graph[xP][yP] = num;
                dfs(xP, yP);
            }
        }

    }

    public static boolean check() {
        return xP >= 0 && yP >= 0 && xP < N && yP < N;
    }
}
