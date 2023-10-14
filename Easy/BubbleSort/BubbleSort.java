import java.util.*;

// Time: O(n^2) 
// Space: O(1)
class Program {
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return new int[] {};
        }
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
