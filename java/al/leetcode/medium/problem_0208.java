package al.leetcode.medium;

import ds.Trie;

public class problem_0208 {

    public boolean solution() {
        // solution is in ds.Trie
        boolean success = true;
        Trie trie = new Trie();
        trie.insert("apple");
        success = success && trie.search("apple");   // return True
        success = success && !trie.search("app");     // return False
        success = success && trie.startsWith("app"); // return True
        trie.insert("app");
        success = success && trie.search("app");     // return True
        return success;
    }

}
