
using System;

public class Solution
{
    private static readonly int ALPHABET_SIZE = 26;
    private static readonly int VISITED = int.MaxValue;

    public int NumberOfSpecialChars(string word)
    {
        char[] wordArray = word.ToCharArray();
        int[] lastIndexSmallLetters = CreateArrayLastIndexSmallLetters(wordArray);
        return FindNumberOfSpecialChars(wordArray, lastIndexSmallLetters);
    }

    private int[] CreateArrayLastIndexSmallLetters(char[] wordArray)
    {
        int[] lastIndexSmallLetters = new int[ALPHABET_SIZE];
        Array.Fill(lastIndexSmallLetters, VISITED);

        for (int i = 0; i < wordArray.Length; ++i)
        {
            char letter = wordArray[i];
            if (letter >= 'a')
            {
                lastIndexSmallLetters[letter - 'a'] = i;
            }
        }

        return lastIndexSmallLetters;
    }

    private int FindNumberOfSpecialChars(char[] wordArray, int[] lastIndexSmallLetters)
    {
        int numberOfSpecialChars = 0;

        for (int i = 0; i < wordArray.Length; ++i)
        {
            char letter = wordArray[i];
            if (letter >= 'a')
            {
                continue;
            }
            if (lastIndexSmallLetters[letter - 'A'] < i)
            {
                ++numberOfSpecialChars;
            }
            lastIndexSmallLetters[letter - 'A'] = VISITED;
        }

        return numberOfSpecialChars;
    }
}
