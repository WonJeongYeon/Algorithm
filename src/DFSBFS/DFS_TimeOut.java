package DFSBFS;

import java.util.*;

class DFS_TimeOut {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static int[] distance;

    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        for (int i = 0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] i: edge) {
            graph.get(i[0]-1).add(i[1]-1);
            graph.get(i[1]-1).add(i[0]-1);
        }

        distance = new int[n];
        dfs(0, 0);

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

    public static void dfs(int index, int count) {
        if (distance[index] != 0 && distance[index] < count) {
            return;
        }
         System.out.println(Arrays.toString(distance));

        distance[index] = count;

        for (int i: graph.get(index)) {
            if (i != 0) {
                dfs(i, count+1);

            }
        }
    }
}