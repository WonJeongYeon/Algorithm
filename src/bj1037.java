import java.io.*;
import java.util.Arrays;

public class bj1037 {

    public static void main(String[] args) throws IOException {


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int answer = 0;
        if (n == 1) {
            answer = arr[0] * arr[0];
        } else {
            answer = arr[0] * arr[n - 1];
        }
        bw.write(answer + "");
        bw.flush();
    }
}

