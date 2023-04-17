import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2149 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String keyStr = br.readLine();
        char[] key = keyStr.toCharArray();
        String password = br.readLine();
        int n = password.length()/key.length;

        Arrays.sort(key);
        char[][] decode = new char[key.length][n+1];
        for (int i = 0; i<key.length; i++) {
            decode[i][0] = (char) (keyStr.indexOf(key[i]) + '0');
            keyStr = keyStr.replaceFirst(Character.toString(key[i]), "a");
            String str = password.substring(i*n, i*n+n);
            for (int j = 1; j<=str.length(); j++) {
                decode[i][j] = str.charAt(j-1);
            }
        }
        Arrays.sort(decode, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                int index = 1;
                int result = 0;
                while (result == 0) {
                    if (index == o1.length) {
                        break;
                    }
                    result = o1[index] - o2[index];
                    index++;
                }
                return result;
            }
            return o1[0]-o2[0];
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<=n; i++) {
            for (char[] c: decode) {
                sb.append(c[i]);
            }
        }

        System.out.println(sb);
    }
}
