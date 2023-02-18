import java.util.*;

class Programmers_NumPair_Failed {
    public String solution(String X, String Y) {
        String answer = "";
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i<X.length(); i++) {
            String s = Character.toString(X.charAt(i));
            if (Y.contains(s)) {
                //X = X.replaceFirst(s, "");
                Y = Y.replaceFirst(s, "");
                //i--;
                numbers.add(Integer.parseInt(s));
            }
        }

        StringBuilder sb = new StringBuilder("");
        if (numbers.size() == 0) {
            sb.append("-1");

        } else {
            Collections.sort(numbers, Collections.reverseOrder());
            for (int j = 0; j<numbers.size(); j++) {
                if (numbers.get(0) != 0) {
                    sb.append(numbers.get(j));
                } else {
                    sb.append("0");
                    break;
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}