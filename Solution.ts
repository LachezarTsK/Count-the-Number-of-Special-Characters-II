
function numberOfSpecialChars(word: string): number {
    this.ALPHABET_SIZE = 26;
    this.ASCII_LOWER_CASE_A = 97;
    this.ASCII_UPPER_CASE_A = 65;
    this.VISITED = Number.MAX_SAFE_INTEGER;

    const lastIndexSmallLetters = createArrayLastIndexSmallLetters(word);
    return findNumberOfSpecialChars(word, lastIndexSmallLetters);
};

function createArrayLastIndexSmallLetters(word: string): number[] {
    const lastIndexSmallLetters = new Array(this.ALPHABET_SIZE).fill(this.VISITED);

    for (let i = 0; i < word.length; ++i) {
        let letter = word.codePointAt(i);
        if (letter >= this.ASCII_LOWER_CASE_A) {
            lastIndexSmallLetters[letter - this.ASCII_LOWER_CASE_A] = i;
        }
    }

    return lastIndexSmallLetters;
}

function findNumberOfSpecialChars(word: string, lastIndexSmallLetters: number[]): number {
    let numberOfSpecialChars = 0;

    for (let i = 0; i < word.length; ++i) {
        let letter = word.codePointAt(i);
        if (letter >= this.ASCII_LOWER_CASE_A) {
            continue;
        }
        if (lastIndexSmallLetters[letter - this.ASCII_UPPER_CASE_A] < i) {
            ++numberOfSpecialChars;
        }
        lastIndexSmallLetters[letter - this.ASCII_UPPER_CASE_A] = this.VISITED;
    }

    return numberOfSpecialChars;
}
