import java.util.*;

public class Kruskal {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{0, 1, 1}, {3, 4, 1}, {1, 2, 2}, {2, 3, 4}}));
        /**
        * TestCase
        * n / costs[node1, node2, cost] / answer
        * 7 [[2, 3, 7], [3, 6, 13], [3, 5, 23], [5, 6, 25], [0, 1, 29], [1, 5, 34], [1, 2, 35], [4, 5, 53], [0, 4, 75]] 159
        * 5 [[0, 1, 5], [1, 2, 3], [2, 3, 3], [3, 1, 2], [3, 0, 4], [2, 4, 6], [4, 0, 7]] 15
        * 5 [[0, 1, 1], [3, 4, 1], [1, 2, 2], [2, 3, 4]] 8
        * 4 [[0, 1, 5], [1, 2, 3], [2, 3, 3], [1, 3, 2], [0, 3, 4]] 9
        * 5 [[0, 1, 1], [3, 1, 1], [0, 2, 2], [0, 3, 2], [0, 4, 100]] 104
        * 6 [[0, 1, 5], [0, 3, 2], [0, 4, 3], [1, 4, 1], [3, 4, 10], [1, 2, 2], [2, 5, 3], [4, 5, 4]] 11
        * 5 [[0, 1, 1], [2, 3, 1], [3, 4, 2], [1, 2, 2], [0, 4, 100]] 6
        * 5 [[0, 1, 1], [0, 4, 5], [2, 4, 1], [2, 3, 1], [3, 4, 1]] 8
        * 5 [[0, 1, 1], [0, 2, 2], [0, 3, 3], [0, 4, 4], [1, 3, 1]] 8
        * 5 [[0, 1, 1], [0, 2, 2], [1, 2, 5], [1, 3, 3], [2, 3, 8], [3, 4, 1]] 7
        * 5 [[0, 1, 1], [3, 4, 1], [1, 2, 2], [2, 3, 4]] 8
        * 4 [[0, 1, 1], [0, 2, 2], [2, 3, 1]] 4
         */
    }
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2])); //비용 기준 정렬
        Set<Integer> union = new HashSet<>();
        int[] parent = new int[n];
        for (int i = 0; i<n; i++) { //부모 노드를 자기자신으로 초기화
            parent[i] = i;
        }
        boolean b = false;
        for (int[] i: costs) {
            for (int k = 0; k<n; k++) {
                if (k != 0 && parent[k] == parent[k-1]) { //사이클 없이 부모 노드가 똑같을 경우
                    b = true;
                } else {
                    b = false; //하나라도 다르면 아직 완성되지 않음
                    break;
                }
            }
            if (b && union.size() == n) { //위 조건 && n만큼 연결될 경우인데 사실 b가 true 일 경우만 고려해도 된다.
                break;
            }
            if (parent[i[0]] != parent[i[1]]) { //사이클이 발생하지 않는 간선의 경우
                //부모 노드는 내림차순으로 정렬한다.
                union.add(i[0]); //위와 마찬가지로 Set 자체가 필요하지 않을 것 같다.
                union.add(i[1]); //Set 쓰는 부분이 최종 검증 부분 하나밖에 없는데, 필요 없다.
                int a = Math.max(parent[i[0]], parent[i[1]]); //부모 노드 값이 a이면 부모 노드를 갱신해주어야 한다.
                for (int j = 0; j<n; j++) {
                    if (parent[j] == a) { //그래서 내림차순이므로 더 작은 노드로 부모 노드를 갱신한다.
                        parent[j] = Math.min(parent[i[0]], parent[i[1]]);
                    }
                }
                parent[i[0]] = Math.min(parent[i[0]], parent[i[1]]); //이 코드도
                parent[i[1]] = Math.min(parent[i[0]], parent[i[1]]); //삭제해도 될 것 같다.
                answer += i[2]; //비용 정산중
            } else { //테스트용 continue
                continue;
            }
            // System.out.println(Arrays.toString(parent)); //현재 부모 노드의 상태
            // System.out.println(Arrays.toString(i)); //실제 사용된 간선만 출력된다.
        }
        return answer;
    }
}