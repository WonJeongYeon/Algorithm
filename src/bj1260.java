import java.io.*;
import java.util.*;


/** 사용했던 중요 반례
 * input:
 * 9 8 1
 * 1 2
 * 1 3
 * 2 4
 * 2 5
 * 4 6
 * 4 7
 * 3 8
 * 3 9
 *
 *
 * output:
 * 1 2 4 6 7 5 3 8 9
 * 1 2 3 4 5 8 9 6 7
 */




public class bj1260 {

    public static List<Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String setting = br.readLine();
        int N = Integer.parseInt(setting.split(" ")[0]);
        int M = Integer.parseInt(setting.split(" ")[1]);
        int start = Integer.parseInt(setting.split(" ")[2]) - 1;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i<M; i++) {
            String input = br.readLine();
            int x = Integer.parseInt(input.split(" ")[0])-1;
            int y = Integer.parseInt(input.split(" ")[1])-1;
            if (!graph.get(x).contains(y)) {
                graph.get(x).add(y);
            }
            if (!graph.get(y).contains(x)) {
                graph.get(y).add(x);
            }
            Collections.sort(graph.get(x));
            Collections.sort(graph.get(y));
        }
        StringBuilder sb = new StringBuilder();

//        for (List<Integer> i : graph) {
//            for (int j : i) {
//                System.out.print(j+1);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
        answer = new ArrayList<>();

        answer.add(start);
        dfs(graph, start);
        for (int i: answer) {
            sb.append(i+1).append(" ");
        }
        bw.write(sb + "\n");
        sb = new StringBuilder();
        answer.clear();
        answer.add(start);
        boolean[] isVisit = new boolean[N];
        isVisit[start] = true;
        List<Integer> bfsList = graph.get(start);
        bfs(isVisit, graph, start, bfsList);
        for (int i: answer) {
            sb.append(i+1).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();


    }

    public static void dfs(List<List<Integer>> graph, int start) {
        for (int i = 0; i<graph.get(start).size(); i++) {
            if (!answer.contains(graph.get(start).get(i))) {
                answer.add(graph.get(start).get(i));
                dfs(graph, graph.get(start).get(i));
            }
        }
    }

    public static void bfs(boolean[] isVisit, List<List<Integer>> graph, int start, List<Integer> bfsList) {
        List<Integer> newBfs = new ArrayList<>();
        for (int i = 0; i<bfsList.size(); i++) {
            if (!isVisit[bfsList.get(i)]) {
                isVisit[bfsList.get(i)] = true;
                answer.add(bfsList.get(i));
            }
        }
        for (int i: bfsList) {
            for (int j = 0; j<graph.get(i).size(); j++) {
                if (!isVisit[graph.get(i).get(j)]) {
                    newBfs.add(graph.get(i).get(j));
                }
            }
        }
        //System.out.println(newBfs);
        if (!newBfs.isEmpty()) {
            bfs(isVisit, graph, 0, newBfs);
        }


    }
}
