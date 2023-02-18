import java.util.*;
import java.io.*;

public class bj2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            String[] setting = br.readLine().split(" ");
            int count = Integer.parseInt(setting[0]);
            int location = Integer.parseInt(setting[1]);
            int[] priority = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            LinkedList<Integer> q = new LinkedList<>();
            for (int j = 0; j < count; j++) {
                q.offer(j);
            }
            int answer = 0;
            List<Integer> list = new ArrayList<>();
            while (!q.isEmpty()) {
                int max = 0;
                for (int num : q) {
                    if (max <= priority[num]) {
                        max = priority[num];
                    }
                }

                while (priority[q.peek()] != max) {
                    q.offer(q.poll());
                }
                list.add(q.poll());

            }
            answer = list.indexOf(location) + 1;
            bw.write(answer + "\n");
        }
        bw.flush();

    }
}
