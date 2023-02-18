import java.io.*;

public class CT_FutureCity {

    public static int infinity = Integer.MAX_VALUE;
    public static int[][] matrix;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String setting = br.readLine();
        int N = Integer.parseInt(setting.split(" ")[0]);
        int M = Integer.parseInt(setting.split(" ")[1]);
        matrix = new int[N][N];
        for (int i = 0; i<M; i++) {
            String input = br.readLine();
            int l = Integer.parseInt(input.split(" ")[0]) - 1;
            int r = Integer.parseInt(input.split(" ")[1]) - 1;
            matrix[l][r]++;
            matrix[r][l]++;
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (i != j && matrix[i][j] == 0) {
                    matrix[i][j] = infinity;
                }
            }
        }

        String point = br.readLine();
        int X = Integer.parseInt(point.split(" ")[0]) - 1;
        int K = Integer.parseInt(point.split(" ")[1]) - 1;

        int answer = 0;

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

        answer = matrix[0][K] + matrix[K][X];
        if (answer >= infinity) {
            bw.write(-1 + "");
        } else {
            bw.write(answer + "");
        }
        bw.flush();
    }

}
