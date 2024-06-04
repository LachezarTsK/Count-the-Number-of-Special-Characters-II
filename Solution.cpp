
#include <span>
#include <array>
#include <ranges>
#include <limits>
#include <string>
using namespace std;

class Solution {

   static const int ALPHABET_SIZE = 26;
   static const int VISITED = numeric_limits<int>::max();

public:
    int numberOfSpecialChars(const string& word) const {
        array<int, ALPHABET_SIZE> lastIndexSmallLetters = createArrayLastIndexSmallLetters(word);
        return findNumberOfSpecialChars(word, lastIndexSmallLetters);
    }

private:
    array<int, ALPHABET_SIZE> createArrayLastIndexSmallLetters(string_view word)const {
        array<int, ALPHABET_SIZE> lastIndexSmallLetters;
        ranges::fill(lastIndexSmallLetters, VISITED);

        for (size_t i = 0; i < word.length(); ++i) {
            char letter = word[i];
            if (letter >= 'a') {
                lastIndexSmallLetters[letter - 'a'] = i;
            }
        }

        return lastIndexSmallLetters;
    }

    int findNumberOfSpecialChars(string_view word, span<int> lastIndexSmallLetters) const{
        int numberOfSpecialChars = 0;

        for (size_t i = 0; i < word.length(); ++i) {
            char letter = word[i];
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
};
