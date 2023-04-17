package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bubble_sort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();



        for (int i = 0; i<arr.length-1; i++) {
            for (int j = 0; j<arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int num = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = num;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
