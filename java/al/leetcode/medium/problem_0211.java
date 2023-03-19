/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * 
 * Implement the WordDictionary class:
 * 1. WordDictionary() Initializes the object.
 * 2. void addWord(word) Adds word to the data structure, it can be matched later.
 * 3. bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. 
 *    word may contain dots '.' where dots can be matched with any letter.
 */

package al.leetcode.medium;

import ds.Trie;

public class problem_0211 {

    private Trie dictionary;

    public problem_0211() {
        this.dictionary = new Trie();
    }
    
    public void addWord(String word) {
        this.dictionary.insert(word);
    }
    
    public boolean search(String word) {
        return search(this.dictionary, word, 0);
    }

    private boolean search(Trie node, String word, int index) {
        boolean result = false;
        if (index == word.length() && node.getIsEnd()) {
            return true;
        } else if (index >= word.length()) {
            return false;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Trie t : node.getNodes()) {
                if (t != null) {
                    result = result || search(t, word, index + 1);
                }
            }
        } else {
            int i = (int) (c - 'a');
            if (node.getNodes()[i] != null) {
                result = result || search(node.getNodes()[i], word, index + 1);
            }
        }
        return result;
    }
    
}
