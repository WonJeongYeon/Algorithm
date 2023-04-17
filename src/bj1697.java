import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1697 {

    public static int N;
    public static int M;
    public static int answer = 0;
    public static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M+2];
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        int count;
        int temp;
        while (!q.isEmpty()) {
            temp = q.poll();

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    count = temp + 1;
                } else if (i == 1) {
                    count = temp - 1;
                } else {
                    count = temp * 2;
                }
                if (count == M) {
                    System.out.println(arr[temp]+1);
                    return;
                }
                if (count >= 0 && count < arr.length && arr[count] == 0) {
                    q.offer(count);
                    arr[count] = arr[temp] + 1;
                }
            }
        }


    }





}
