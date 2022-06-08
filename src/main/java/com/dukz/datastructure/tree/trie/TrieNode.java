package com.dukz.datastructure.tree.trie;

/**
 * Trie字典树节点
 *
 * @author dukezheng
 * @ClassName TrieNode
 * @date 2022/5/27 16:27
 */
public class TrieNode {
    char data;
    TrieNode[] children = new TrieNode[26];
    boolean isEndingChar;

    public TrieNode() {
    }

    public TrieNode(char data) {
        this.data = data;
    }

}
