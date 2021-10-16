package core.trie;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie data structure.
     * @param word
     */
    public void insertWord(String word) {
        var currentNode = root;

        for(int i = 0; i < word.length(); i++) {
            var ch = word.charAt(i);

            var node = currentNode.getChildren().get(ch);

            if(node == null) {
                node = new TrieNode();
                currentNode.getChildren().put(ch, node);
            }

            currentNode = node;
        }

        currentNode.setLastLetterOfWord(true);
    }

    public List<String> advanceSearch(String prefix){
        var result = new ArrayList<String>();

        var currentNode= root;

        for(int i = 0; i < prefix.length(); i++) {
            currentNode = currentNode.getChildren().get(prefix.charAt(i));

            if(currentNode == null)
                return result;
        }

        searchWords(prefix, currentNode, result);

        return result;
    }

    /**
     * Depth First Search recursive function.
     * @param targetWord
     * @param currentNode
     * @param dictionary
     */
    private void searchWords(String targetWord, TrieNode currentNode, List<String> dictionary) {
        if(currentNode == null)
            return;

        if(currentNode.isLastLetterOfWord())
            dictionary.add(targetWord);

        var map =  currentNode.getChildren();

        map.forEach((key, value) -> {
            searchWords(targetWord + key, map.get(key), dictionary);
        });
    }
}
