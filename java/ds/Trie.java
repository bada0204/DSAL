/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. 
 * There are various applications of this data structure, such as autocomplete and spellchecker.
 * 
 * Implement the Trie class:
 * 1. Trie() Initializes the trie object.
 * 2. void insert(String word) Inserts the string word into the trie.
 * 3. boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * 4. boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 */

package ds;

public class Trie {

    private Trie[] nodes;
    private boolean isEnd;

    public Trie() {
        this.nodes = new Trie[26];
        this.isEnd = false;
    }
    
    public void insert(String word) {
        Trie[] nodes = this.getNodes();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean isEnd = i == word.length() - 1;
            int index = (int) (c - 'a');
            if (nodes[index] == null) {
                nodes[index] = new Trie();
            }
            if (isEnd) {
                nodes[index].setIsEnd(isEnd);
            }
            nodes = nodes[index].getNodes();
        }
    }
    
    public boolean search(String word) {
        Trie[] nodes = this.getNodes();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean isEnd = i == word.length() - 1;
            int index = (int) (c - 'a');
            if (nodes[index] == null) {
                return false;
            } else if (isEnd) {
                return nodes[index].getIsEnd();
            }
            nodes = nodes[index].getNodes();
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Trie[] nodes = this.getNodes();
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = (int) (c - 'a');
            if (nodes[index] == null) {
                return false;
            }
            nodes = nodes[index].getNodes();
        }
        return true;
    }

    public Trie[] getNodes() { 
        return this.nodes;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }
    
}
