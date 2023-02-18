import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class floyd_Warshall {

    public static int infinity = Integer.MAX_VALUE - 100;
    //점화식 계산을 위한 설정, 최대 비용 < 100이라고 가정

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String setting = br.readLine();
        int N = Integer.parseInt(setting.split(" ")[0]);
        int M = Integer.parseInt(setting.split(" ")[1]);

        int[][] matrix = new int[N][N];

        for (int i = 0; i<M; i++) {
            String input = br.readLine();
            int start = Integer.parseInt(input.split(" ")[0]) - 1;
            int end = Integer.parseInt(input.split(" ")[1]) - 1;
            int cost = Integer.parseInt(input.split(" ")[2]);
            matrix[start][end] = cost;
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (i != j && matrix[i][j] == 0) {
                    matrix[i][j] = infinity;
                }
            }
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (matrix[i][j] == infinity) {
                    continue;
                }
                for (int k = 0; k<N; k++) {
                    if (matrix[j][k] == infinity) {
                        continue;
                    }
                    matrix[i][k] = Math.min(matrix[i][k], matrix[i][j] + matrix[j][k]);
                }
            }
        }

        for (int[] i: matrix) {
            System.out.println(Arrays.toString(i));
        }


    }
}
