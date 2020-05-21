package Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    // Initialize your data structure here.
    char c;
    boolean isLeaf;
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode() {}
    public TrieNode(char c) { this.c = c; }
}

public class TrieHashMap {
    private TrieNode root;

    public TrieHashMap() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!children.containsKey(c))
                children.put(c, new TrieNode(c));

            TrieNode t = children.get(c);

            if (i == word.length() - 1)
                t.isLeaf = true;

            children = t.children;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchLastNode(word);

        return t != null && t.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchLastNode(prefix) != null;
    }

    // Returns the last TrieNode of word
    private TrieNode searchLastNode(String word) {
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!children.containsKey(c)) break;

            TrieNode t = children.get(c);

            if (i == word.length() - 1)
                return t;

            children = t.children;
        }

        return null;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /** Accept words **/
        System.out.println("Trie UniqueString\n");
        System.out.println ("Enter words to be entered into trie");
        String input = br.readLine();
        String[] s = input.split(" ");
        /** Create Trie with accepted words **/
//        TrieHashMap t = new TrieHashMap(s);
        /** Trie UniqueString **/
        char ch = 'n';
        do
        {
            System.out.println("\nEnter word to search ");
            String key = br.readLine();
//            System.out.println("Search status : "+ t.contains(key));

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = br.readLine().charAt(0);
        }
        while (ch == 'Y'|| ch == 'y');
    }
}

