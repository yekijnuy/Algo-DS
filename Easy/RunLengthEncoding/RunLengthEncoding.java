import java.util.*;

// Time: O(N)
// Space: O(N)
class Program {
    public String runLengthEncoding(String string) {
        StringBuilder encodedStringCharacters = new StringBuilder();
        int currentRunLength = 1;

        for (int i = 1; i < string.length(); i++) {
            char currentCharacter = string.charAt(i);
            char previousCharacter = string.charAt(i - 1);

            if ((currentCharacter != previousCharacter) || (currentRunLength == 9)) {
                encodedStringCharacters.append(Integer.toString(currentRunLength));
                encodedStringCharacters.append(previousCharacter);
                currentRunLength = 0;
            }

            currentRunLength += 1;
        }

        // Handle last run
        encodedStringCharacters.append(Integer.toString(currentRunLength));
        encodedStringCharacters.append(string.charAt(string.length() - 1));

        return encodedStringCharacters.toString();
    }
}
