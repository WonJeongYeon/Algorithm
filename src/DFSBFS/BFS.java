package DFSBFS;

import java.util.*;

class BFS {

    public List<List<Integer>> graph = new ArrayList<>();
    public int[] distance;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        for (int i = 0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] i: edge) {
            graph.get(i[0]-1).add(i[1]-1);
            graph.get(i[1]-1).add(i[0]-1);
        }

        distance = new int[n];
        bfs(0, 0);

        // System.out.println(Arrays.toString(distance));
        int max = 0;
        for (int i: distance) {
            if (max < i) {
                max = i;
                answer = 1;
            } else if (max == i) {
                answer++;
            }
        }
        return answer;
    }

    public void bfs(int index, int count) {
        if (distance[index] != 0 && distance[index] < count) {
            return;
        }
        // System.out.println(Arrays.toString(distance));

        // distance[index] = count;
        count++;
        List<Integer> list = new ArrayList<>();
        for (int i: graph.get(index)) {
            if (distance[i] <= count && distance[i] != 0) {
                continue;
            }
            if (i != 0) {
                list.add(i);
                distance[i] = count;

            }
        }
        for (int i: list) {
            bfs(i, count);
        }
    }
}
