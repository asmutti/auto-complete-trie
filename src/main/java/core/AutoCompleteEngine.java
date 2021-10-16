package core;

import core.trie.Trie;

import java.util.List;
import java.util.Locale;

public class AutoCompleteEngine {

    private Trie trie;

    public AutoCompleteEngine() {
        this.trie = new Trie();
    }

    /**
     * Adds a word in to the Dictionary.
     * @param word
     *
     * @throws IllegalArgumentException if {@code word} is empty or blank.
     */
    public void addToDictionary(String word) {
        if(word.isBlank() || word.isBlank()) {
            throw new IllegalArgumentException("Word cannot be an empty or blank String.");
        }

        trie.insertWord(word.toLowerCase(Locale.ROOT));
    }

    /**
     * Search for a prefix string has any match in the dictionary
     * @param prefix
     * @return
     * @throws IllegalArgumentException if {@code prefix} is empty or blank.
     */
    public List<String> autoComplete(String prefix) throws IllegalArgumentException {
        if (prefix.isBlank() || prefix.isEmpty()) {
            throw new IllegalArgumentException("The prefix cannot be an empty or blank String.");
        }

        return trie.advanceSearch(prefix.toLowerCase(Locale.ROOT));
    }

    public void print(List<String> words) {
        words.forEach((word) -> {
            System.out.println(word);
        });
    }

    public void clearDictionary() {
        this.trie = new Trie();
    }
}
