import java.util.*;

class DFS_Test {

    public static void main(String[] args) {
        int[] e = {1, 2, 3, 4, 5};
        System.out.println(solution(e));
    }
    public static int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i<= elements.length; i++) {
            for (int j = 0; j<elements.length; j++) {
                int num = 0;
                for (int k = 0; k<i; k++) {
                    if (j + k < elements.length) {
                        num += elements[j+k];
                    } else {
                        num += elements[j+k-elements.length];
                    }
                }
                set.add(num);
            }
        }
        answer = set.size();
        return answer;
    }

    public void dfs() {

    }
}