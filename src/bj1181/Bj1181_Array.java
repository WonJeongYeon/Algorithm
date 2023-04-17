package bj1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj1181_Array {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i<N; i++) {
            arr[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr, ((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length()-o2.length();
        }));

        for (int i = 0; i<N; i++) {
            if (i != 0 && arr[i].equals(arr[i-1])) {
                continue;
            }
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
