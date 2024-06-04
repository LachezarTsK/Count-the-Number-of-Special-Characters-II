
package main

import (
	"fmt"
	"math"
)

var ALPHABET_SIZE = 26
var VISITED int = math.MaxInt

func numberOfSpecialChars(word string) int {
	lastIndexSmallLetters := createArrayLastIndexSmallLetters(&word)
	return findNumberOfSpecialChars(&word, &lastIndexSmallLetters)
}

func createArrayLastIndexSmallLetters(word *string) []int {
	lastIndexSmallLetters := make([]int, ALPHABET_SIZE)
	for i := range lastIndexSmallLetters {
		lastIndexSmallLetters[i] = VISITED
	}

	for i := range *word {
		letter := (*word)[i]
		if letter >= 'a' {
			lastIndexSmallLetters[letter-'a'] = i
		}
	}

	return lastIndexSmallLetters
}

func findNumberOfSpecialChars(word *string, lastIndexSmallLetters *[]int) int {
	numberOfSpecialChars := 0

	for i := range *word {
		letter := (*word)[i]
		if letter >= 'a' {
			continue
		}
		if (*lastIndexSmallLetters)[letter-'A'] < i {
			numberOfSpecialChars++
		}
		(*lastIndexSmallLetters)[letter-'A'] = VISITED
	}

	return numberOfSpecialChars
}
