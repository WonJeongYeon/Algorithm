import java.util.*;
import java.io.*;

public class bj1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i<N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int num = 0;
        if (pq.size() != 1) {
            while (pq.size() > 2) {
                int m = pq.poll() + pq.poll();
                num += m;
                pq.offer(m);

            }
            bw.write((pq.poll() + pq.poll() + num) + "\n");
        } else {
            bw.write(0 + "\n");
        }

        bw.flush();
    }
}
