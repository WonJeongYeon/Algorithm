import java.util.*;

public class Solution_1 {

    public static void main(String[] args) {
        String a = solution(2, 4, 2, 1);
        System.out.println(a);
    }
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder tube = new StringBuilder();
        int count = 1;
        int num = 0;
        while (sb.length() < t*m+p) {
            sb.append(convert(num, n).reverse());
            num++;
        }
        answer = sb.toString();
        return answer;
    }

    public static StringBuilder convert(int num, int n) {
        StringBuilder sb = new StringBuilder();
        if (num < n) {
            sb.append(num);
            return sb;
        } else {
            while (num >= n) {
                int p = num % n;
                sb.append(p);
                num /= n;
            }
        }
        //System.out.println(sb.reverse().toString());
        return sb;
    }
}