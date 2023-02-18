import java.util.*;
import java.io.*;

public class bj2178_ing {

    public static int[][] matrix;
    public static int[][] map;
    public static int N;
    public static int M;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] setting = br.readLine().split(" ");
        N = Integer.parseInt(setting[0]);
        M = Integer.parseInt(setting[1]);

        matrix = new int[N][M];
        map = new int[N][M];

        for (int i = 0; i<N; i++) {
            matrix[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        boolean[][] isVisit = new boolean[N][M];
        recursion(0, 0, 1, isVisit);
        bw.write(answer + "");
        bw.flush();



    }

    public static void recursion(int x, int y, int count, boolean[][] isVisit) {

        System.out.println(x + ", " + y + " " + count);
        if (answer != 0 && answer < count) { //이전 정답보다 크면 검증이고 뭐고 리턴
            //isVisit[x][y] = false;
            return;
        }
        if (x < 0 || y < 0 || x >= N || y >= M) { //IndexOutOfBound
            //isVisit[x][y] = false;
            return;
        }
        if (matrix[x][y] == 0) { //벽
            isVisit[x][y] = false;
            return;
        }
        if (isVisit[x][y]) { //이미 방문한 곳
            return;
        }
        isVisit[x][y] = true; //방문 했음
        if (x == N-1 && y == M-1) { //목표 도착
            //System.out.println(count);
            if (answer == 0) { //기존 정답이 없으면
                answer = count;
            }
//            if (count == 17) { //예제 2에서 17이 왜 나올까? 왜 한붓그리기를 쳐 하고 있을까?
//                for (boolean[] b : isVisit) {
//                    System.out.println(Arrays.toString(b));
//                }
//            }
            return;
        }
        //모든 방향으로 재귀
            recursion(x + 1, y, count + 1, isVisit);
            recursion(x - 1, y, count + 1, isVisit);
            recursion(x, y + 1, count + 1, isVisit);
            recursion(x, y - 1, count + 1, isVisit);
    }
}
