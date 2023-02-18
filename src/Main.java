import java.io.*;
import java.util.*;

public class Main {

    public static String[][] board;
    public static boolean answer;
    public static void main(String[] args) throws IOException {

        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int size = Integer.parseInt(br.readLine());


        int[] setting = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = setting[0];
        int M = setting[1];
        board = new String[N][M];
        answer = false;

        for (int i = 0; i<N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j<M; j++) {
                board[i][j] = input[j];
            }
        }



    }

    public static void dfs(int x, int y, String dot, int count) {
        if (answer) {
            return;
        }
        if (!dot.equals(board[x][y])) {
            count = 0;
            dot = board[x][y];
        }
    }


}