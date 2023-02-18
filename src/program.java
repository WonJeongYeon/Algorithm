import java.util.*;
class Solution {

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        String str = "1231";
        if (str.contains("ayaaya")) {
            str.replaceFirst("1231", "");
        }
        System.out.println(solution(food));
    }
    public static String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for (int i =0; i< food.length; i++) {
            if (food[i] % 2 != 0 && i != 0) {
                i -= 1;
            }
            if (i != 0) {
                for (int j = 0; j<food[i]/2; j++) {
                    answer.append(Integer.toString(i));
                }
            }
        }
        answer.append("0");
        for (int k = food.length-1; k>=1; k--) {
            for (int l = 0; l<food[k]/2; l++) {
                answer.append(Integer.toString(k));
            }
        }
        return answer.toString();
    }
}