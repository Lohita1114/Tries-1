class TrieNode {
   boolean isEndOfWord;
   TrieNode[] children;
   public TrieNode() {
       children = new TrieNode[26];
   }
}
public class Trie{
   private TrieNode root;
   public Trie() {
       root = new TrieNode();
   }
public void insert(String word) {
       TrieNode cursor = root;
       char c;
       for (int i = 0; i < word.length(); i++) { 
           c = word.charAt(i);
           if (cursor.children[c - 'a'] == null) { 
               cursor.children[c - 'a'] = new TrieNode();
           }
           cursor = cursor.children[c - 'a']; 
       }
       cursor.isEndOfWord = true; 
   }
    
   public boolean search(String word) {
       TrieNode cur = root;
       char c;
       for (int i = 0; i < word.length(); i++) { 
           c = word.charAt(i);
           if (cur.children[c - 'a'] == null) { 
               return false;
           }
           cur = cur.children[c - 'a']; 
       }
       return cur.isEndOfWord;
   }

   public boolean startsWith(String prefix) {
       TrieNode cur = root;
       char c;
       for (int i = 0; i < prefix.length(); i++) { 
           c = prefix.charAt(i);
           if (cur.children[c - 'a'] == null) { 
               return false;
           }
           cur = cur.children[c - 'a'];
       }
       return true;
   }
}

//Time complexity : O(m) where m is the key length
//Space complexity : insert is O(m), search, startsWith is O(1)
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
