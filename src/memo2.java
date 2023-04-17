import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class memo2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = new int[9][9];
        int max = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i<9; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j<9; j++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(x+1).append(" ").append(y+1);
        System.out.println(sb);


    }
}
