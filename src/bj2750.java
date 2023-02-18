import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class bj2750 {
    public static void main(String[] args) throws IOException {

        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int size = Integer.parseInt(br.readLine());

        int size = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<size; i++) {
            int num = Integer.parseInt(br.readLine());
            if (list.isEmpty()) {
                list.add(num);
            } else if (list.get(0) > num) {
                list.add(0, num);
            } else if (list.get(list.size()-1) < num) {
                list.add(num);
            } else {
                for (int j = 0; j<list.size(); j++) {
                    if (list.get(j) > num) {
                        list.add(j, num);
                        break;
                    }
                }
            }
        }

        for (int i:list) {
            bw.write(i+"\n");
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