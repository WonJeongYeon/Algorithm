import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj9935 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<String> stk = new Stack<>();
        for (int i = 0; i<str.length(); i++) {
            if (stk.isEmpty()) {
                stk.push(Character.toString(str.charAt(i)));
            }
        }
    }
}
