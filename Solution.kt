
import java.util.Arrays

class Solution {

    private companion object {
        const val ALPHABET_SIZE = 26
        const val VISITED = Int.MAX_VALUE
    }

    fun numberOfSpecialChars(word: String): Int {
        val wordArray = word.toCharArray()
        val lastIndexSmallLetters = createArrayLastIndexSmallLetters(wordArray)
        return findNumberOfSpecialChars(wordArray, lastIndexSmallLetters)
    }

    private fun createArrayLastIndexSmallLetters(wordArray: CharArray): IntArray {
        val lastIndexSmallLetters = IntArray(ALPHABET_SIZE)
        Arrays.fill(lastIndexSmallLetters, VISITED)
        
        for (i in wordArray.indices) {
            val letter = wordArray[i]
            if (letter >= 'a') {
                lastIndexSmallLetters[letter - 'a'] = i
            }
        }

        return lastIndexSmallLetters
    }

    private fun findNumberOfSpecialChars(wordArray: CharArray, lastIndexSmallLetters: IntArray): Int {
        var numberOfSpecialChars = 0

        for (i in wordArray.indices) {
            val letter = wordArray[i]
            if (letter >= 'a') {
                continue
            }
            if (lastIndexSmallLetters[letter - 'A'] < i) {
                ++numberOfSpecialChars
            }
            lastIndexSmallLetters[letter - 'A'] = VISITED
        }

        return numberOfSpecialChars
    }
}
