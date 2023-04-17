import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int size = Integer.parseInt(br.readLine());

        String str = br.readLine();


        Stack<Character> stk = new Stack<>();
        for (int i = 0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (stk.isEmpty()) {
                stk.push(c);
                continue;
            }
            if (stk.peek().equals('P') && c == 'P') {
                stk.pop();
                stk.push('p');
            } else if (stk.peek().equals('p')) {
                if (c == 'P') {
                    stk.pop();
                    stk.push('P');
                    stk.push('p');
                }
                else if (c == 'A') {
                    stk.pop();
                    stk.push('a');
                } else {
                    stk.push(c);

                }
            } else if (stk.peek() == 'a' && c == 'P') {
                stk.pop();
                if (!stk.isEmpty()) {
                    if (stk.peek() == 'P') {
                        stk.pop();
                        stk.push('p');
                    } else if (stk.peek() == 'a') {
                        stk.pop();
                        stk.push('P');
                    } else {
                        stk.push('P');
                    }
                } else {
                    stk.push('P');
                }
            } else {
                stk.push(c);
            }
            System.out.println(stk);
        }
        if (stk.size() == 1 && stk.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }


    }


}