import java.util.*;

class Program {
    public static boolean isValidSubsequence(
            List<Integer> array, List<Integer> sequence) {
        int mainPt = 0;
        int subPt = 0;

        while (subPt < sequence.size() && mainPt < array.size()) {
            if (array.get(mainPt) == sequence.get(subPt)) {
                ++mainPt;
                ++subPt;
            } else {
                ++mainPt;
            }

            if (subPt == sequence.size()) {
                return true;
            }
        }
        return false;
    }
}
