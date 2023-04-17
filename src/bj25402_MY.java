
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.acmicpc.net/problem/25402
//정올 2022 2차 2번문제
public class bj25402_MY {

    public static int[][] graph;
    public static int answer = 0;
    public static List<String> answerarr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for (int i = 0; i<N-1; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = input[0]-1;
            int y = input[1]-1;
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<M; i++) {
            answer = 0;
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = input[0];
//            int[] nodes = new int[k];
            List<Integer> nodes = new ArrayList<>();
            for (int j = 1; j<=k; j++) {
                nodes.add(input[j]-1);
            }
//            System.out.println(nodes);
            if (k == 1) {
                sb.append(0).append("\n");
                continue;
            }

            for (int j: nodes) {
                for (int l: nodes) {
                    boolean[] isVisit = new boolean[N];
                    if (l == j) {
                        continue;
                    }
                    if (graph[j][l] == 1) {
//                        System.out.println(j + " " + l + "in normal");
                        answer++;
                    } else {
                        //System.out.println(j + " start");
                        dfs(j, nodes, isVisit, l);
                    }
                }
            }
            sb.append(answer/2).append("\n");

        }

//        System.out.println(answerarr);
        System.out.println(sb);

    }

    public static void dfs(int start, List<Integer> nodes, boolean[] isVisit, int end) {



        isVisit[start] = true;
         for (int i : nodes) {
            if (isVisit[i] || i == start) {
                continue;
            }
//            System.out.println(start + " " + end + "임 중간다리는" + i);
            if (graph[start][i] == 1 && graph[i][end] == 1) {
//                System.out.println(start + " " + i +" "+end + "in dfs");
                answer++;
                break;
            } else if (graph[start][i] == 1) {
                dfs(i, nodes, isVisit, end);
            }
        }

    }
}
/*
7
1 2
1 3
1 5
2 7
4 6
4 7
3
1 1
2 1 2
4 1 2 3 4
 */
