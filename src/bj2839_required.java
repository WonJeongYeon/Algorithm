import java.io.*;
import java.util.Scanner;

public class bj2839_required {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = scanner.nextInt();
        int backUp = num;
        int result = 0;
        boolean third = false;
        int count = 1;
        if (num % 5 == 0) {
            result = num/5;
        } else {
            while (num != 0) {
                if (num % 3 == 0) {
                    third = true;
                }
                if (num >= 5) {
                    num -= 5;
                    result++;
                } else if (num>=3) {
                    num -= 3;
                    result++;
                } else if (third) {
                    num = backUp - 3*count;
                    result = count;
                    count++;

                    if (num % 3 != 0) {
                        third = false;
                    }
                }
                else {
                    result = -1;
                    break;
                }
            }
        }
        bw.write(result + "");
        bw.flush();


    }

}