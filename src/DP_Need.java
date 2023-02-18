import java.io.*;

public class DP_Need {

    public static int answer = 0;
    public static void main(String[] args) throws IOException {

        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int size = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        recursion(N, 0);
        System.out.println(answer);


    }

    public static void recursion(int N, int count) {
        if (answer != 0 && count >= answer) {
            return;
        }
        if (N == 1) {
            if (answer > count || answer == 0) {
                answer = count;
            }
            return;
        }
        if (N % 3 == 0) {
            recursion(N/3, count+1);
        }
        if (N % 2 == 0) {
            recursion(N/2, count+1);
        }
        recursion(N-1, count+1);
    }

}