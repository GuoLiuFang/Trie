package com.funcoming.trie;

/**
 * Created by LiuFangGuo on 5/18/16.
 */
public class TrieNode {
    private TrieNode parent;
    private TrieNode[] children;
    private boolean isLeaf;//Quick way to check if any children exist是否有子节点。。叶子节点是没有子节点的。
    private boolean isWord;//Does this node represent the last character of a word
    private char character;//The character this node represents

    /*
    * Constructor for top level root node.========parent is null;Trie树的root 节点为null。。
    * */

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isLeaf = true;//构造新的root节点时,构建所有节点时,默认都是终端节点,即构造时都是没有子节点的。。
        this.isWord = false;//是终端节点但是不是一个完整的单词。因为。根节点。根本不存单词。。
    }
    /*
    * Constructor for child node
    * */

    public TrieNode(char character) {
        this();//调用当前具有相同形参的构造函数。。说白了就是调用无参构造函数
        this.character = character;//把存的字符,加上。这是初始化一个节点时唯一的不同。
    }

    protected void addWord(String word) {
        //增加一个节点时,该节点的一个属性首先发生变化。那就是终端节点的属性。显然已经不再是,叶子节点啦。
        this.isLeaf = false;
        int charPos = word.charAt(0) - 'a';//字符所谓位置。都是相对于a的位置而言。
        if (this.children[charPos] == null) {//如果子节点孩子列表中没有该节点。。那么就把他加入。
            this.children[charPos] = new TrieNode(word.charAt(0));
            this.children[charPos].parent = this;//该节点的父母节点指向当前节点。
        }
        if (word.length() > 1) {
            this.children[charPos].addWord(word.substring(1));//子节点也调用添加函数。那么递归关系建立。
        } else {
            this.children[charPos].isWord = true;
        }

    }

}
