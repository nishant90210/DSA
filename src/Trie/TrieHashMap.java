package Trie;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class TrieHash {

    private HashMap<Character, HashMap> root;

    public TrieHash(HashMap<Character, HashMap> root) {
        this.root = root;
    }

    public TrieHash(String[] arr)
    {
        root = new HashMap<Character, HashMap>();
        for (String s: arr)
            add(s);
    }

    public void add(String str)
    {
        HashMap<Character, HashMap> node = root;
        for (int i = 0; i < str.length(); i++)
        {
            if (node.containsKey(str.charAt(i)))
                node = node.get(str.charAt(i));
            else
            {
                node.put(str.charAt(i), new HashMap<Character, HashMap>());
                node = node.get(str.charAt(i));
            }
        }
        /** end of string **/
        node.put('\0', new HashMap<Character, HashMap>(0));
    }

    public boolean contains(String str)
    {
        HashMap<Character, HashMap> currentNode = root;
        for (int i = 0; i < str.length(); i++)
        {
            if (currentNode.containsKey(str.charAt(i)))
                currentNode = currentNode.get(str.charAt(i));
            else
                return false;
        }
        return currentNode.containsKey('\0') ? true : false;
    }

}


public class TrieHashMap {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /** Accept words **/
        System.out.println("Trie UniqueString\n");
        System.out.println ("Enter words to be entered into trie");
        String input = br.readLine();
        String[] s = input.split(" ");
        /** Create Trie with accepted words **/
        TrieHash t = new TrieHash(s);
        /** Trie UniqueString **/
        char ch = 'n';
        do
        {
            System.out.println("\nEnter word to search ");
            String key = br.readLine();
            System.out.println("Search status : "+ t.contains(key));

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = br.readLine().charAt(0);
        }
        while (ch == 'Y'|| ch == 'y');
    }
}
