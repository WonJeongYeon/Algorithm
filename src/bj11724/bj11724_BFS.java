package bj11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bj11724_BFS {
    //ASAC 실습문제
    public static int N;
    public static int M;
    public static boolean[] isVisit;
    public static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] init = br.readLine().split(" ");
        N = Integer.parseInt(init[0]);
        M = Integer.parseInt(init[1]);
        isVisit = new boolean[N];

        for (int i = 0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            graph.get(x-1).add(y-1);
            graph.get(y-1).add(x-1);
        }

        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i<N; i++) {
            if (isVisit[i]) {
                continue;
            }
            answer++;
            isVisit[i] = true;
            q.offer(i);
            while (!q.isEmpty()) {
                int p = q.poll();
                isVisit[p] = true;
                for (int j : graph.get(p)) {
                    if (!isVisit[j]) {
                        q.offer(j);
                    }
                }
            }


        }
        System.out.println(answer);
    }


}
