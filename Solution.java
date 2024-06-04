
import java.util.Arrays;

public class Solution {

    private static final int ALPHABET_SIZE = 26;
    private static final int VISITED = Integer.MAX_VALUE;

    public int numberOfSpecialChars(String word) {
        char[] wordArray = word.toCharArray();
        int[] lastIndexSmallLetters = createArrayLastIndexSmallLetters(wordArray);
        return findNumberOfSpecialChars(wordArray, lastIndexSmallLetters);
    }

    private int[] createArrayLastIndexSmallLetters(char[] wordArray) {
        int[] lastIndexSmallLetters = new int[ALPHABET_SIZE];
        Arrays.fill(lastIndexSmallLetters, VISITED);

        for (int i = 0; i < wordArray.length; ++i) {
            char letter = wordArray[i];
            if (letter >= 'a') {
                lastIndexSmallLetters[letter - 'a'] = i;
            }
        }

        return lastIndexSmallLetters;
    }

    private int findNumberOfSpecialChars(char[] wordArray, int[] lastIndexSmallLetters) {
        int numberOfSpecialChars = 0;

        for (int i = 0; i < wordArray.length; ++i) {
            char letter = wordArray[i];
            if (letter >= 'a') {
                continue;
            }
            if (lastIndexSmallLetters[letter - 'A'] < i) {
                ++numberOfSpecialChars;
            }
            lastIndexSmallLetters[letter - 'A'] = VISITED;
        }

        return numberOfSpecialChars;
    }
}
