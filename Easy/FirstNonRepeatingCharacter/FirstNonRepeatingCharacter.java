import java.util.*;

// Time: O(N)
// Space: O(1)
class Program {
    public int firstNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> lookupMap = new HashMap<Character, Integer>();

        for (int i = 0; i < string.length(); i++) {
            if (lookupMap.get(string.charAt(i)) != null) {
                lookupMap.put(string.charAt(i), lookupMap.get(string.charAt(i)) + 1);
            } else {
                lookupMap.put(string.charAt(i), 1);
            }
        }

        for (int i = 0; i < string.length(); i++) {
            if (lookupMap.get(string.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
