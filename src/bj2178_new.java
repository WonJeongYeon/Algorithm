import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj2178_new {
    //ASAC 실습 문제
    public static int N;
    public static int M;
    public static char[][] graph;
    public static boolean[][] isVisit;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] init = br.readLine().split(" ");
        N = Integer.parseInt(init[0]);
        M = Integer.parseInt(init[1]);

        graph = new char[N][M];
        isVisit = new boolean[N][M];
        for (int i = 0; i<N; i++) {
            char[] input = br.readLine().toCharArray();
            graph[i] = input;
        }
        br.close();

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1}); //출발지 설정
        isVisit[0][0] = true;
        int x, y, cnt; //변수 중복 선언을 막기 위해 미리 선언 후 갱신

        while (!q.isEmpty()) { //BFS 탐색
            int[] p = q.poll();
            x = p[0];
            y = p[1];
            cnt = p[2];

            if (x == N-1 && y == M-1) { //목적지 도달 (최소 비용 보장)
                System.out.println(cnt);
                break;
            }
            cnt++;
            for (int i = 0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (check(nx, ny)) { //벽에 부딪히지 않거나 방문하지 않은 곳일 때
                    isVisit[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt});
                }
            }
        }

    }


    public static boolean check(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M && !isVisit[nx][ny] && graph[nx][ny] == '1';
    }
}
