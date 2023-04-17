import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class bj1987 {

    public static int N;
    public static int M;
    public static char[][] graph;
    public static boolean[][] visit;
    public static int answer;
    public static Set<Character> set;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] setting = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = setting[0];
        M = setting[1];

        set = new HashSet<>();
        graph = new char[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i<N; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        answer = 0;

        dfs(0, 0, 1);




        System.out.println(answer);

    }

    public static void dfs(int x, int y, int count) {
//        System.out.println(set);
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return;
        }
        if (set.contains(graph[x][y]) || visit[x][y]) {
//            System.out.println(aSet);
            answer = Math.max(answer, count-1);
            return;
        }
        set.add(graph[x][y]);
        visit[x][y] = true;

        dfs(x, y+1, count+1);
        dfs(x+1, y, count+1);
        dfs(x-1, y, count+1);

        dfs(x, y-1, count+1);

        visit[x][y] = false;
        set.remove(graph[x][y]);
    }


}
