package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Selection_sort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();



        for (int i = 0; i<arr.length; i++) {
            int select = arr[i];
            int min = 0;
            int index = i;
            for (int j = i+1; j<arr.length; j++) {
                if (arr[j] < select) {
                    select = arr[j];
                    index = j;
                }
            }
            if (select != min) {
                arr[index] = arr[i];
                arr[i] = select;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
