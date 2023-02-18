import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bj2309 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> heightList = new ArrayList<>();
        for (int i = 0; i<9; i++) {
            heightList.add(scanner.nextInt());
        }
        int result = 0;
        int fake1 = 0, fake2 = 1;
        int count = 0;
        int i = 0;
        while (result != 100 || count != 7) {

            if (i >= 9) {
                fake2++;
                result = 0;
                count = 0;
                i = 0;
                if (fake2 >= 9) {
                    fake1++;
                    fake2 = fake1 + 1;
                }
            }

            if (i != fake1 && i != fake2) {
                result += heightList.get(i);
                count++;
            }

            i++;
        }
        heightList.remove(fake1);
        heightList.remove(fake2-1);
        Collections.sort(heightList);
        for (int j: heightList) {
                System.out.println(j);
        }
    }
}