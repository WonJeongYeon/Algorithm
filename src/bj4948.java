import java.io.*;

public class bj4948 {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {

        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int size = Integer.parseInt(br.readLine());
        int num = 123_457;
        while (num != 0) {
            int count = 0;
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }


            prime = new boolean[num*2+1];
            for (int j = 2; j<=num*2; j++) {
                if (prime[j]) {
                    continue;
                } else if (j > num) {
                    count++;
                }

                for (int k = j+j; k<=num*2; k+=j) {
                    prime[k] = true;
                }
            }
            bw.write(count+"\n");
        }


          bw.flush();


    }

//    public static boolean isPrime(int num) {
//        boolean b = true;
//            for(int j = 2; j<=num/2; j++) {
//                if (num % j == 0) {
//                    b = false;
//                    break;
//                }
//            }
//
//        return b || num == 3 || num == 2;
//    }



}