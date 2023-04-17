import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2295 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        for (int i = N-1; i>=0; i--) {
            for (int j = N-1; j>=0; j--) {
                for (int k = N-1; k>=0; k--) {
                    int sum = list.get(i) + list.get(j) + list.get(k);
                    if (list.contains(sum)) {
                        System.out.println(sum);
                        return;
                    }
                }
            }
        }

    }
}
