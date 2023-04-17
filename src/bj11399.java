import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj11399 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, (o1, o2) -> {
            return Math.abs(o1)-Math.abs(o2);
        });
        int answer = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for (int i = 0; i<N; i++) {
            if (i != 0) {
                if (Math.abs(arr2[i]+arr2[i-1]) < answer) {
                    answer = Math.abs(arr2[i]+arr2[i-1]);
                    a = Math.min(arr2[i], arr2[i-1]);
                    b = Math.max(arr2[i], arr2[i-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(" ").append(b);
        System.out.println(sb);
    }
}
