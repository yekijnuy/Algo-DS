import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    int[] cpArrSorted = Arrays.copyOf(array, array.length);
    Arrays.sort(cpArrSorted);
    int lowPt = 0;
    int highPt = cpArrSorted.length - 1;

    while(lowPt <= highPt) {
      int lowVal = cpArrSorted[lowPt];
      int highVal = cpArrSorted[highPt];
      int arrSum = lowVal + highVal;
      
      if (arrSum == targetSum) {
        int[] foundArr = {lowVal, highVal};
        return foundArr;
      }
      
      if (arrSum < targetSum) {
        ++lowPt;
      } else {
        --highPt;
      }
    }
    
    return new int[0];
  }
}
