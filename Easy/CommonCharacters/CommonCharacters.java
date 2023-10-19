import java.util.*;

// Time: O(N * M), n is number of strings and m is the length of the longest string
// Space: O(c), number of unique characters across all strings
class Program {
    public String[] commonCharacters(String[] strings) {
        HashMap<Character, Integer> characterCounts = new HashMap<Character, Integer>();
        for (String string : strings) {
            HashSet<Character> uniqueStringCharacters = new HashSet<Character>();
            for (int i = 0; i < string.length(); i++) {
                uniqueStringCharacters.add(string.charAt(i));
            }

            for (char character : uniqueStringCharacters) {
                if (!characterCounts.containsKey(character)) {
                    characterCounts.put(character, 0);
                }
                characterCounts.put(character, characterCounts.get(character) + 1);
            }
        }

        ArrayList<Character> finalCharacters = new ArrayList<Character>();
        for (Map.Entry<Character, Integer> characterCount : characterCounts.entrySet()) {
            Character character = characterCount.getKey();
            Integer count = characterCount.getValue();
            if (count == strings.length) {
                finalCharacters.add(character);
            }
        }

        String[] finalCharactersArr = new String[finalCharacters.size()];
        for (int i = 0; i < finalCharactersArr.length; i++) {
            finalCharactersArr[i] = finalCharacters.get(i).toString();
        }
        return finalCharactersArr;
    }
}
