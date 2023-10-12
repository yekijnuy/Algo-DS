import java.util.*;

// Time: O(n log(n))
// Space: O(1)
class Program {
    public int tandemBicycle(
            int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if (!fastest) {
            // Reverse redShirtSpeeds without sorting it again
            int i = 0;
            int j = redShirtSpeeds.length - 1;
            while (i < j) {
                int temp = redShirtSpeeds[i];
                redShirtSpeeds[i] = redShirtSpeeds[j];
                redShirtSpeeds[j] = temp;
                i++;
                j--;
            }
        }

        int totalSpeed = 0;
        for (int idx = 0; idx < redShirtSpeeds.length; idx++) {
            int rider1 = redShirtSpeeds[idx];
            int rider2 = blueShirtSpeeds[blueShirtSpeeds.length - idx - 1];
            totalSpeed += Math.max(rider1, rider2);
        }
        return totalSpeed;
    }
}
