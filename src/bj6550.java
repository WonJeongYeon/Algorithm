import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj6550 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {

            if (input.equals("")) {
                break;
            }
            String s = input.split(" ")[0];
            String t = input.split(" ")[1];

            String answer = "Yes";
            Queue<Character> q = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                q.offer(s.charAt(i));
            }

            for (int i = 0; i < t.length(); i++) {
                if (q.isEmpty()) {
                    break;
                }
                if (q.peek() == t.charAt(i)) {
                    q.poll();
                }
            }
            if (!q.isEmpty()) {
                answer = "No";
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
