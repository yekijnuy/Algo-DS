import java.util.*;

// Time: O(N log N)
// Space: O(N)
class Program {
    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int[] arrCp = Arrays.copyOf(array, array.length);
        for (int i = 0; i < arrCp.length; ++i) {
            arrCp[i] = arrCp[i] * arrCp[i];
        }
        Arrays.sort(arrCp);
        return arrCp;
    }
}
