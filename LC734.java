import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        // Rule 1: Must have the exact same length
        if (sentence1.length != sentence2.length) {
            return false;
        }

        // Put all similar pairs into a HashSet for O(1) lookups
        Set<String> similaritySet = new HashSet<>();
        for (List<String> pair : similarPairs) {
            // Store both directions to handle symmetry easily
            similaritySet.add(pair.get(0) + "#" + pair.get(1));
            similaritySet.add(pair.get(1) + "#" + pair.get(0));
        }

        // Check word-by-word
        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            // If words are not equal AND not in our similarity set, sentences fail
            if (!word1.equals(word2) && !similaritySet.contains(word1 + "#" + word2)) {
                return false;
            }
        }

        return true;
    }
}