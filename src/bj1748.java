import java.io.*;
import java.util.Scanner;

public class bj1748 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        int size = Integer.toString(count).length();
        int result_int = 0;
//        if (count < 10) {
//            result_int = count;
//        } else if (count < 99) {
//            result_int = 9 + (count-9)*2;
//        } else if (count < 999) {
//            result_int = 9 + 180 + (count-99)*3;
//        } else if (count < 9_999) {
//            result_int = 9 + 180 + 2_700 + (count-999)*4;
//        } else if (count < 99_999) {
//            result_int = 9 + 180 + 2_700 + 36_000 + (count-9_999)*5;
//        }
        String downSize = "";
        for (int i = 1; i<size; i++) {
            result_int += 9 * i * Math.pow(10, i-1);
            downSize += "9";
        }
        if (count < 10) {
            result_int = count;
        } else {
            result_int += (count - Integer.parseInt(downSize)) * size;
        }

        bw.write(result_int + "");
        bw.flush();


    }
}