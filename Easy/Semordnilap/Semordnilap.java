import java.util.*;

class Program {
    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        HashSet<String> wordHashSet = new HashSet<String>(Arrays.asList(words));
        ArrayList<ArrayList<String>> semordnilapPairs = new ArrayList<ArrayList<String>>();

        for (String word : words) {
            String reverseWord = new StringBuilder(word).reverse().toString();
            if (wordHashSet.contains(reverseWord) && !reverseWord.equals(word)) {
                ArrayList<String> semordnilapPair = new ArrayList<String>();
                semordnilapPair.add(word);
                semordnilapPair.add(reverseWord);
                semordnilapPairs.add(semordnilapPair);
                wordHashSet.remove(word);
                wordHashSet.remove(reverseWord);
            }
        }
        return semordnilapPairs;
    }
}
