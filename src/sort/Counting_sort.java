package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Counting_sort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int[] count = new int[arr.length];

        for (int i = 0; i<arr.length; i++) {
            count[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i<count.length; i++) {
            while (count[i] != 0) {
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
