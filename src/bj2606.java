import com.sun.source.tree.UsesTree;

import java.util.*;
import java.io.*;


public class bj2606 {

    public static Set<Integer> virus;
    public static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            graph.get(Integer.parseInt(input[0])-1).add(Integer.parseInt(input[1])-1);
            graph.get(Integer.parseInt(input[1])-1).add(Integer.parseInt(input[0])-1);

        }

//        for (List<Integer> i: graph) {
//            System.out.println(i);
//        }

        virus = new HashSet<>();
        virus.add(0);

        bfs(0);
        //System.out.println(virus);
        bw.write(virus.size()-1 + "");
        bw.flush();
    }

    public static void bfs(int index) {

        for (int i = 0; i<graph.get(index).size(); i++) {
//            System.out.println(virus);
//            System.out.println(index);
//            System.out.println(graph.get(index).get(i));
//            System.out.println();
            if (virus.contains(graph.get(index).get(i))) {
                continue;
            }
            virus.add(graph.get(index).get(i));
            bfs(graph.get(index).get(i));
        }

    }


}
