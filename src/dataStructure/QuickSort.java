package dataStructure;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(final int[] data, int start, int end) {
        if (start < end) {
            int low = start;
            int high = end;
            int pivot = data[(low + high) / 2];
            while (low < high) {
                while (data[low] < pivot) low++;
                while (data[high] > pivot) high--;
                if (low < high) {
                    int tmp = data[low];
                    data[low] = data[high];
                    data[high] = tmp;
                }
            }
            System.out.println(Arrays.toString(data));
            quickSort(data, start, low - 1);
            quickSort(data, low,+1);
        }
    }
}
