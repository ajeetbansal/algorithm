/**
 * Trie is an efficient information reTrieval data structure. Using Trie, search complexities can be brought to optimal limit (key length). If we store keys in binary search tree, a well balanced BST will need time proportional to M * log N, where M is maximum string length and N is number of keys in tree. Using Trie, we can search the key in O(M) time. However the penalty is on Trie storage requirements
 * Every node of Trie consists of multiple branches. Each branch represents a possible character of keys. We need to mark the last node of every key as end of word node. A Trie node field isEndOfWord is used to distinguish the node as end of word node.
 *  root
 /   \    \
 t   a     b
 |   |     |
 h   n     y
 |   |  \  |
 e   s  y  e
 /  |   |
 i  r   w
 |  |   |
 r  e   e
 |
 r
 * https://www.geeksforgeeks.org/trie-insert-and-search/
 */
package aj.algorithm.trie;

/**
 * Created by ajeet on 3/30/2019.
 */
public class Trie {
    static final int TOKEN_DOMAIN_SIZE = 26;

    TrieNode root = new TrieNode();

    class TrieNode {
        TrieNode children[] = new TrieNode[TOKEN_DOMAIN_SIZE];
        boolean isEndofWord = false;

        TrieNode() {
            for (int i = 0; i < TOKEN_DOMAIN_SIZE; i++)
                children[i] = null;
        }
    }

    public void insert(String key) {
        TrieNode currNode = root;
        for (int i = 0; i < key.length(); i++) {
            int currChar = key.charAt(i) - 'a';
            if (currNode.children[currChar] == null) {
                currNode.children[currChar] = new TrieNode();
            }
            currNode = currNode.children[currChar];
        }
        currNode.isEndofWord = true;
    }

    public boolean search(String key) {
        TrieNode currNode = root;
        for (int i = 0; i < key.length(); i++) {
            int currChar = key.charAt(i) - 'a';
            if (currNode.children[currChar] == null) {
                return false;
            }
            currNode = currNode.children[currChar];
        }
        return (currNode != null && currNode.isEndofWord);
    }

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};

        Trie trie = new Trie();

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++)
            trie.insert(keys[i]);

        // Search for different keys
        if (trie.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if (trie.search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if (trie.search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if (trie.search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }
}
