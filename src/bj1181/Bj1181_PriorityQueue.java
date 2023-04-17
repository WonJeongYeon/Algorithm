package bj1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Bj1181_PriorityQueue {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<String> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length()-o2.length();
        }));

        for (int i = 0; i<N; i++) {
            String input = br.readLine();
            pq.offer(input);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            String str = pq.poll();
            if (str.equals(pq.peek())) {
                continue;
            }
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}
