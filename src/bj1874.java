import java.io.*;
import java.util.*;

public class bj1874 {
    public static void main(String[] args) throws IOException {

        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int size = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        int index = 0;
        boolean b = true;
        for (int i = 0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > index) {
                for (int j = index+1; j<= num; j++) {
                    stk.push(j);
//                    sb.append("+").append("\n");
                    bw.write("+\n");
                }
                index = num;
            } else if (stk.peek() != num) {
                bw.close();
                System.out.println("NO");
                break;
            }

            stk.pop();
//            sb.append("-").append("\n");
            bw.write("-\n");

        }

//        System.out.println(sb);

        bw.flush();

    }

}