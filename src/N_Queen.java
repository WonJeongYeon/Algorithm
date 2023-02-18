import java.io.*;
import java.util.Arrays;

public class N_Queen {

    public static int[] line; //boolean 배열 쓰고싶은데 대각선 검증때문에 안됨
    public static int N;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        line = new int[N];
            recursion(0);
//        }

        bw.write(answer + "");
        bw.flush();
    }

    public static void recursion(int queen) {
        if (queen == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {

            line[queen] = i;
            boolean isPossible = true;
            for (int j = 0; j < queen; j++) {
                if (line[queen] == line[j]) { //가로세로
                    isPossible = false;
                    break;
                } else if (Math.abs(queen - j) == Math.abs(line[queen] - line[j])) { //대각선?
                    isPossible = false;
                    break;
                }
                //System.out.println(i + " " + j + "가능");
            }

            if (isPossible) {
                recursion(queen + 1);
            }
        }

    }

}