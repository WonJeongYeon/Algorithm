import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class bj1766 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = {"119", "1110", "111119", "21", "490", "101"};
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
        String str = "23";
        String[] setting = br.readLine().split(" ");
        int N = Integer.parseInt(setting[0]);
        int M = Integer.parseInt(setting[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            graph.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
        }

    }
}
