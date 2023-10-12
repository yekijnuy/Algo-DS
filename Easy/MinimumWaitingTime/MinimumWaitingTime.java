import java.util.*;

// Time: O(n log(n))
// Space: O(n)
class Program {
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);

        int querySum = 0;
        int index = 0;
        return minimumWaitingTime(queries, querySum, index);
    }

    public int minimumWaitingTime(int[] queries, int querySum, int index) {
        if (index == queries.length - 1) {
            return 0;
        }
        querySum += queries[index];
        return querySum + minimumWaitingTime(queries, querySum, ++index);
    }
}

// Time: O(n log(n))
// Space: O(1)
// Note: This is a better solution as it saves call stack space
// The intuition is in queriesLeft where we add the current query duration by
// remaininng queries left
// The last query is multiplied by zero and does not add to the total query
// duration
class Program {
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);

        int totalWaitingTime = 0;
        for (int idx = 0; idx < queries.length; idx++) {
            int duration = queries[idx];
            int queriesLeft = queries.length - (idx + 1);
            totalWaitingTime += duration * queriesLeft;
        }
        return totalWaitingTime;
    }
}
