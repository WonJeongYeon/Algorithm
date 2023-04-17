package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Insertion_sort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();



        for (int i = 1; i<arr.length; i++) {
            int select = arr[i];
            int index = i;
            for (int j = i-1; j>=0; j--) {
                if (arr[j] > select) {
                    arr[index] = arr[j];
                    arr[j] = select;
                }
                index = index-1;

            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
