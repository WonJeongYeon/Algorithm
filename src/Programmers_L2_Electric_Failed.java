import java.util.*;

class Programmers_L2_Electric_Failed {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        List<Integer> size = new ArrayList<>();

        for (int i = 0; i<wires.length; i++) { //wires[i]는 끊을 전선
            Set<Integer> left = new HashSet<>(); //분리된 트리 1
            Set<Integer> right = new HashSet<>(); //분리된 트리 2
            for (int j = 0; j<wires.length; j++) {
                if (j == 0) {
                    left.clear();
                    right.clear();
                }
                if (i != j) { //끊어진 전선 제외하고 반복
                    if (left.isEmpty()) { //첫 반복이면 일단 left에  추가
                        left.add(wires[j][0]);
                        left.add(wires[j][1]);
                    } else if (left.contains(wires[j][0]) || left.contains(wires[j][1])) { //left와 연결된 전선이면 송전탑들 추가
                        left.add(wires[j][0]);
                        left.add(wires[j][1]);
                    } else { //분리된 애들이면 right에 추가
                        right.add(wires[j][0]);
                        right.add(wires[j][1]);
                    }
                }
                if (j == wires.length-1) { //반복이 끝날 때
                    if (right.isEmpty()) { // 송전탑 1개빼고 다 치우쳤을경우 리스트가 비므로 더미값 한개 추가하면 개수가 맞음
                        right.add(0);
                    }
                    System.out.println(left);
                    System.out.println(right);
                    size.add(Math.abs(left.size() - right.size())); //송전탑 개수 차이 저장
                }
            }
        }
        Collections.sort(size);
        answer = size.get(0); //최소값 반환

        return answer;
    }
}