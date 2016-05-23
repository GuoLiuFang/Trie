package com.funcoming.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuFangGuo on 5/23/16.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        this.root.addWord(word.toLowerCase());
    }

    public List getWords(String prefix) {
        //先找到前缀中最后一个字符。
        TrieNode lastNode = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getNode(prefix.charAt(i));
        }
        if (lastNode == null) {
            return new ArrayList();
        }
        return lastNode.getWords();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("Trie");
        trie.addWord("with");
        trie.addWord("the");
        trie.addWord("words");
        trie.addWord("cat");
        trie.addWord("dog");
        trie.addWord("can");
        trie.addWord("classes");
        List resultSet = trie.getWords("ca");
        for (Object s :
                resultSet) {
            System.out.println(s);
        }

    }
}
