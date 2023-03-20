package radixsort;

import java.util.Arrays;

public class RadixSort {

    private static int getMax(int myarray[], int n) {
        int mx = myarray[0];
        for (int i = 1; i < n; i++)
            if (myarray[i] > mx)
                // get always the greatest
                mx = myarray[i];
        return mx;
    }

    private static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // new array of n positions
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // map inside the bucket
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10] = count[(arr[i] / exp) % 10] + 1;
        }

        // Calculate cumulative count
        for (int j = 1; j < 10; j++) {

            count[j] = count[j] + count[j - 1];
        }

        // placing elements in sorted order
        for (int k = n - 1; k >= 0; k--) {
            // printing
            // for(int l = 0; l < count.length; l++){
            //     System.out.print(count[l]);
            // }
            // System.out.println("-----");
            // for(int l = 0; l < output.length; l++){
            //     System.out.print(output[l]);
            // }
            output[count[(arr[k] / exp) % 10] - 1] = arr[k];
            count[(arr[k] / exp) % 10]--;
            // System.out.println("");
            // System.out.println("");
        
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }

    }

    private static void radixsort(int arr[], int n) {
        int max = getMax(arr, n);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    private static void printing(int[] arr){
        for(int el : arr){
            System.out.print(el+", ");
        }
    }

    public static void main(String[] args) {
        int myarray[] = { 1, 5, 4 };
        int n = myarray.length;

        // function call
        radixsort(myarray, n);

        printing(myarray);
        // printing
        // for (int l = 0; l < myarray.length; l++) {
        //     System.out.println(myarray[l]);
        // }
    }
}