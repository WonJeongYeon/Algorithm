import java.io.*;
import java.math.BigInteger;
import java.util.Objects;

public class bj4375 {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "a";
        while (!(input = br.readLine()).equals("")) {
            BigInteger n = new BigInteger(input);
            //long n = Long.parseLong(input);
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            while (!Objects.equals(new BigInteger(sb.toString()).mod(n).toString(), "0")) {
                sb.append(1);
            }
            bw.write(sb.length() + "\n");
        }
        bw.flush();
    }
}
