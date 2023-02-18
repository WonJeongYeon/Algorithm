import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class bj18258 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            switch (input.substring(0, 3)) {
                case "pop" : if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.get(0) + "\n");
                    queue.remove(0);
                }
                    break;
                case "siz" : bw.write(queue.size() + "\n");
                    break;
                case "emp" : if (queue.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
                    break;
                case "fro" :
                    if (queue.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(queue.get(0) + "\n");
                    }
                    break;
                case "bac" : if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.get(queue.size() - 1) + "\n");
                }
                    break;
                case "pus" :
                    int num = Integer.parseInt(input.split(" ")[1]);
                    queue.add(num);
                    break;
            }
//            if (input.equals("pop")) {
//                if (queue.isEmpty()) {
//                    bw.write(-1 + "\n");
//                } else {
//                    bw.write(queue.get(0) + "\n");
//                    queue.remove(0);
//                }
//            }
//            if (input.equals("size")) {
//                bw.write(queue.size() + "\n");
//            }
//            if (input.equals("empty")) {
//                if (queue.isEmpty()) {
//                    bw.write(1 + "\n");
//                } else {
//                    bw.write(0 + "\n");
//                }
//            }
//            if (input.equals("front")) {
//                if (queue.isEmpty()) {
//                    bw.write(-1 + "\n");
//                } else {
//                    bw.write(queue.get(0) + "\n");
//                }
//            }
//            if (input.equals("back")) {
//                if (queue.isEmpty()) {
//                    bw.write(-1 + "\n");
//                } else {
//                    bw.write(queue.get(queue.size() - 1) + "\n");
//                }
//            }
//            if (input.contains("push")) {
//                int num = Integer.parseInt(input.split(" ")[1]);
//                queue.add(num);
//            }
        }
        bw.flush();
    }
}
