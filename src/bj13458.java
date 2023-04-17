import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class bj13458 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] students = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] setting = br.readLine().split(" ");
        int B = Integer.parseInt(setting[0]);
        int C = Integer.parseInt(setting[1]);

        long answer = N;
        for (int i: students) {
            int rest = i-B;
            if (rest <= 0) {
                continue;
            }
            if (rest % C != 0) {
                answer += rest/C + 1;
            } else {
                answer += rest/C;
            }
        }
        System.out.println(answer);
    }
}
