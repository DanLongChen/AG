package L2019_7_25;

/**
 * Created by DanLongChen on 2019/7/25
 * 实现前缀树
 **/
public class L208 {
    private TrieNode root=null;
    /** Initialize your data structure here. */
    public L208() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p=root;
        for(char c:word.toCharArray()){
            if(p.child[c-'a']==null){
                p.child[c-'a']=new TrieNode();
            }
            p=p.child[c-'a'];
        }
        p.item=word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p=root;
        for(char c:word.toCharArray()){
            if(p.child[c-'a']==null){
                return false;
            }
            p=p.child[c-'a'];
        }
        return p.item.equals(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p=root;
        for(char c:prefix.toCharArray()){
            if(p.child[c-'a']==null){
                return false;
            }
            p=p.child[c-'a'];
        }
        return true;
    }
    private class TrieNode{
        public TrieNode[] child=new TrieNode[26];
        public String item="";
    }
}
