package Special.Implementation;

public class Trie {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if(word == null || word.length() <= 0) return;
        TrieNode node = root;
        for(int i = 0; i < word.length(); ++i) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                node.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        if(word == null || word.length() <= 0)
            return false;
        TrieNode node = root;
        for(int i = 0; i < word.length(); ++i) {
            if (node.children[word.charAt(i) - 'a'] == null)
                return false;
            node = node.children[word.charAt(i) - 'a'];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() <= 0)
            return false;
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); ++i) {
            if (node.children[prefix.charAt(i) - 'a'] == null)
                return false;
            node = node.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}