package com.smartcloud.common.utils.leetCode.tree;

import java.util.TreeMap;

/**
 * @program: java-core-learning-example
 * @description: trie
 * @author: znq
 * @create: 2020-02-04 15:46
 **/
public class Trie {

    private class Node {

        private boolean isWord;

        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    private int size;

    public Trie() {
        this.root = new Node();
        size = 0;

    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            size++;
            cur.isWord = true;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        String abd = "abd";
        String abdd = "abdd";
        Trie trie = new Trie();
        trie.add(abd);
        trie.add(abdd);
        System.out.println(trie.contains(abd));
        System.out.println(trie.contains(abdd));
    }
}
