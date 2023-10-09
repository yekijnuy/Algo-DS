import java.util.*;

// Since the input array is sorted, we can use pointer
// Time: O(N)
// Space: O(N)
class Program {
    public int[] sortedSquaredArray(int[] array) {
        int[] newArr = new int[array.length];
        int startIdx = 0;
        int endIdx = array.length - 1;
        int i = newArr.length - 1;

        while (startIdx != endIdx) {
            int startIdxSq = array[startIdx] * array[startIdx];
            int endIdxSq = array[endIdx] * array[endIdx];
            if (startIdxSq > endIdxSq) {
                newArr[i] = startIdxSq;
                ++startIdx;
            } else {
                newArr[i] = endIdxSq;
                --endIdx;
            }
            --i;
        }

        newArr[i] = array[startIdx] * array[startIdx];
        return newArr;
    }
}
