import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj13023_graph {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputSet = br.readLine();

        int N = Integer.parseInt(inputSet.split(" ")[0]);
        int M = Integer.parseInt(inputSet.split(" ")[1]);

//        int[][] ares = new int[N][N];
        List<List<Integer>> ares = new ArrayList<>();

        for (int i = 0; i<N; i++) {
            ares.add(new ArrayList<>());
        }

        for (int i = 0; i<M; i++) {
            String inputLine = br.readLine();
            int l = Integer.parseInt(inputLine.split(" ")[0]);
            int r = Integer.parseInt(inputLine.split(" ")[1]);
            ares.get(l).add(r);
            ares.get(r).add(l);

//            ares[l][r] = 1;
//            ares[r][l] = 1;
        }

        for (int i = 0; i< N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j<ares.get(i).size(); j++) {
                sb.append(ares.get(i).get(j)).append(" ");
            }
//            for (int j = 0; j<N; j++) {
//                sb.append(ares[i][j]).append(" ");
//            }
            bw.write(sb.toString() + "\n");
        }
        bw.flush();




    }
}
