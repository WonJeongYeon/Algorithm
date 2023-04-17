import java.io.*;
import java.util.Arrays;

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

        for (int i = 0; i<N; i++) { //인접 행렬 그래프 구현
            for (int j = 0; j<N; j++) {
                if (i != j && matrix[i][j] == 0) {
                    matrix[i][j] = infinity;
                }
            }
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (matrix[j][i] == infinity) {
                    //중간 노드로 거쳐갈 수 없으면, 반복을 진행할 필요가 없다.
                    continue;
                }
                for (int k = 0; k<N; k++) {
                    if (matrix[i][k] == infinity) {
                        continue;
                    }
                    matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
                }
            }
        }

        for (int[] i: matrix) {
            //결과 출력, infinity 값을 대체해서 출력해야 한다. TODO 아직 구현하지 않았다.
            System.out.println(Arrays.toString(i));
        }


    }
}
