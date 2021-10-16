package core.trie;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isLastLetterOfWord;

    TrieNode() {
        children = new HashMap<>();
        isLastLetterOfWord = false;
    }
}
