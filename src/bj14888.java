import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14888 {

    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static int[] operators = new int[4];
    public static int[] numbers;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void dfs(int num, int index) {
        if (index == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0:	dfs(num + numbers[index], index + 1);	break;
                    case 1:	dfs(num - numbers[index], index + 1);	break;
                    case 2:	dfs(num * numbers[index], index + 1);	break;
                    case 3:	dfs(num / numbers[index], index + 1);	break;
                }
                operators[i]++;
            }
        }
    }

}