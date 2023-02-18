import java.util.*;
import java.io.*;

public class bj11866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] setting = br.readLine().split(" ");

        int N = Integer.parseInt(setting[0]);
        int K = Integer.parseInt(setting[1]);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i<=N; i++) {
            q.offer(i);
        }
        List<Integer> answer = new ArrayList<>();

        int count = 0;
        while (count != N) {
            for (int i = 0; i<K-1; i++) {
                q.offer(q.poll());
            }
            answer.add(q.poll());
            count++;

        }
        bw.write("<" + answer.toString().replace("[", "").replace("]", "") + ">");
        bw.flush();

    }
}
