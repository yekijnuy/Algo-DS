import java.util.*;

// Time: O(2^n)
// Space: O(n)
class Program {
    public static int getNthFib(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2 || n == 3) {
            return 1;
        }

        return getNthFib(n - 2) + getNthFib(n - 1);
    }
}

// Time: O(n)
// Space: O(n), using memoization which is passing a hashmap
class Program {
    public static int getNthFib(int n) {
        Map<Integer, Integer> memoize = new HashMap<Integer, Integer>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        return getNthFib(n, memoize);
    }

    public static int getNthFib(int n, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        } else {
            memoize.put(n, getNthFib(n - 1, memoize) + getNthFib(n - 2, memoize));
            return memoize.get(n);
        }
    }
}

// Time: O(n)
// Space: O(1), just use an array to track and kick out values
class Program {
    public static int getNthFib(int n) {
        int[] lastTwo = { 0, 1 };
        int counter = 3;
        while (counter <= n) {
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return n > 1 ? lastTwo[1] : lastTwo[0];
    }
}
