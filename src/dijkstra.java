import java.io.*;
import java.util.*;

class Node {
    private int index;
    private int distance;

    Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }
}

public class dijkstra {

    public static List<List<Node>> graph = new ArrayList<>();
    public static int infinity = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String setting = br.readLine();

        int N = Integer.parseInt(setting.split(" ")[0]);
        int M = Integer.parseInt(setting.split(" ")[1]);

        for (int i = 0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i<M; i++) {
            String line = br.readLine();
            int index = Integer.parseInt(line.split(" ")[0]) - 1;
            int nodeIndex = Integer.parseInt(line.split(" ")[1]) - 1;
            int distance = Integer.parseInt(line.split(" ")[2]);
            Node node = new Node(nodeIndex, distance);
            graph.get(index).add(node);
        }

        boolean[] isVisit = new boolean[N];
        int[] distanceArr = new int[N];
        Arrays.fill(distanceArr, infinity);
        Arrays.fill(isVisit, false);

        int i = 2; //현재 어떤 값(i < N)을 넣어도 다익스트라 알고리즘이 잘 수행되는 상태
            distanceArr[i] = 0;
            int smallestDistance = infinity;
            int smallestIndex = 0;
            isVisit[i] = true;
            for (Node n : graph.get(i)) {
                distanceArr[n.getIndex()] = n.getDistance();
                if (smallestDistance >= n.getDistance()) {
                    smallestIndex = n.getIndex();
                    smallestDistance = n.getDistance();
                }
            }
            recursion(distanceArr, isVisit, smallestDistance, smallestIndex);
            System.out.println(Arrays.toString(distanceArr));




    }

    public static void recursion(int[] distanceArr, boolean[] isVisit, int smallestDistance, int smallestIndex) {
        boolean isEnd = false;
        System.out.println(Arrays.toString(distanceArr));
        System.out.println(smallestIndex);
        isVisit[smallestIndex] = true;
        for (boolean b : isVisit) {
            if (!b) {
                isEnd = false;
                break;
            } else {
                isEnd = true;
            }
        }
        if (isEnd) {
            return;
        }

        int newSmallIndex = 0;
        int newSmallDistance = infinity;
        List<Boolean> isPossible = new ArrayList<>();
        Set<Integer> common = new HashSet<>();
        for (Node n : graph.get(smallestIndex)) {
            if (distanceArr[n.getIndex()] > smallestDistance + n.getDistance()) {
                distanceArr[n.getIndex()] = smallestDistance + n.getDistance();
                isPossible.add(true);
            } else {
                isPossible.add(false);
            }
            if (newSmallDistance > smallestDistance + n.getDistance()) {
                newSmallIndex = n.getIndex();
                newSmallDistance = smallestDistance + n.getDistance();
            } else if (newSmallDistance == smallestDistance + n.getDistance()) {
                common.add(newSmallIndex);
                common.add(n.getIndex());
            }
        }
        for (int i = 0; i<distanceArr.length; i++) {
            if (distanceArr[newSmallIndex] == distanceArr[i] && i != newSmallIndex) {
                common.add(newSmallIndex);
                common.add(i);
            }
        }
        if (!isPossible.contains(true)) {
            isVisit[smallestIndex] = false;
            System.out.println(smallestIndex + "는 유망하지 않아 되돌아감");
            return;
        } else {
            if (common.isEmpty()) {
                System.out.println("유망한 노드가 한개라서 바로들어감");
                recursion(distanceArr, isVisit, newSmallDistance, newSmallIndex);
            } else {
                System.out.println("겹치는 애들이 있고 얘네들임" + common);
                for (int i: common) {
                    recursion(distanceArr, isVisit, newSmallDistance, i);
                }
            }
        }

    }

}
