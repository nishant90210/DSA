package Trie;

/**
 * Created by NISHANT on 4/4/18.
 */
// https://www.geeksforgeeks.org/trie-insert-and-search/

// Java implementation of search and insert operations
// on Trie
public class Trie {

    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode{

        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        public TrieNode() {

            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    static void insert(String key)
    {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    static boolean search(String key){

        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null){
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    public static void main(String[] args) {

        TrieNode trieNode = new TrieNode();
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
        root = new TrieNode();
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);

        System.out.println(trieNode);
    }
}
