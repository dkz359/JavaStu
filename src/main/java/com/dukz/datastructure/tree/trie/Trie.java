package com.dukz.datastructure.tree.trie;

/**
 * 字典树
 *
 * @author dukezheng
 * @ClassName Trie
 * @date 2022/5/27 16:29
 */
public class Trie {
    private TrieNode root = new TrieNode('/');

    /**
     * 往Trie树中插入一个字符串
     * @param text
     */
    public void insert(char[] text){
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if(p.children[index] == null){
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     * 在Trie树中查找一个字符串
     * @param pattern
     * @return
     */
    public boolean find(char[] pattern){
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if(p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }
        if(!p.isEndingChar){
            return false;
        }
        return false;
    }
}
