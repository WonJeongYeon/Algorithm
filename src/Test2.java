import java.util.*;

class Test2 {

    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmn.p"));
    }
    public static String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        for (int i = 0; i<new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (!Character.isDigit(c) && !Character.isAlphabetic(c) && !(c == '-') && !(c == '_') && !(c == '.')) {
                System.out.print(c + " ");
                new_id = new_id.replace(Character.toString(c), "");
                i--;
            }
        }
        System.out.println(new_id);
        while (true) {
            if (new_id.contains("..")) {
                new_id = new_id.replace("..", ".");
            } else {
                break;
            }
        }
        System.out.println(new_id);
        if (new_id.charAt(0) == '.') {
            new_id = new_id.replaceFirst("\\.", "");
        }
        System.out.println(new_id + "여기?");
        if (new_id.length() > 0) {
            if (new_id.charAt(new_id.length()-1) == '.') {
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        System.out.println(new_id);
        if (new_id.length() == 0) {
            new_id = "a";
        }
        System.out.println(new_id + "여기2?");
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        System.out.println(new_id);
        if (new_id.charAt(0) == '.') {
            new_id = new_id.replaceFirst("\\.", "");
        }
        System.out.println(new_id);
        if (new_id.length() > 0) {
            if (new_id.charAt(new_id.length()-1) == '.') {
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
//        StringBuilder j0j0 = new StringBuilder();
//        j0j0.
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int fwefw: map.values()) {
//
//        }

        int i = 1;
        int j = 1;
        int k = 1;
        List<Integer> fds = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int[][] asdf;
        String str = "1w3123";
        if (str.equals("12")) {

        }
        List<Integer> asdfqewr = new ArrayList<>();

        char qwerqwer = 'c';
        Object asdfg = "0000";
        int kim = 6;
        Object kimm = (Object) kim;
        int q2e3 = Integer.parseInt((String) asdfg);
//        str.replace()
        System.out.println(new_id);
        if (new_id.length() <= 2) {
            while (new_id.length() < 3) {
                new_id += new_id.substring(new_id.length()-1);
            }
        }
        if (str.contains("1")) {

        }
        int[][] arrr = {{1, 2}, {3, 4}, {1, 3}, {2, 4}};
        Arrays.sort(arrr);
        System.out.println(arrr);
        System.out.println("Array");
        System.out.println(new_id);
        answer = new_id;
        return answer;
    }

}