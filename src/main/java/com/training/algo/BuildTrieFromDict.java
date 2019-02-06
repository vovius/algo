package com.training.algo;

import java.util.Arrays;

public class BuildTrieFromDict {

    private final static int ALPHABET_SIZE = 26;
    static class TrieNode {
        TrieNode[] siblings = new TrieNode[ALPHABET_SIZE];
        boolean isEnd = false;

        @Override
        public String toString() {
            return "TrieNode{" +
                    "siblings=" + Arrays.toString(siblings) +
                    ", isEnd=" + isEnd +
                    '}';
        }
    }

    public TrieNode buildTrie(String[] arr) {
        TrieNode root = new TrieNode();

        for (String string : arr) {
            TrieNode curNode = root;
            for (char c : string.toCharArray()) {
                int idx = c - 'a';
                if (curNode.siblings[idx] == null) {
                    curNode.siblings[idx] = new TrieNode();
                }
                curNode = curNode.siblings[idx];
            }

            curNode.isEnd = true;
        }

        return root;
    }

    public void printByDfs(TrieNode root) {
        doPrint(root, "");
        System.out.println();
    }

    private void doPrint(TrieNode node, String curWord) {
        if (node.isEnd) {
            System.out.println(curWord);
        }

        for (int i=0; i < ALPHABET_SIZE; i++) {
            if (node.siblings[i] != null) {
                doPrint(node.siblings[i], curWord + (char)('a'+(char)i));
            }
        }

    }

    public boolean isWordPresent(TrieNode root, String word) {
        TrieNode curNode = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curNode.siblings[idx] == null) {
                return false;
            }

            curNode = curNode.siblings[idx];
        }

        return curNode != null && curNode.isEnd;
    }

    public static void main(String[] args) {
        String[] dict = {"geek", "for", "geeks", "hui"};
        BuildTrieFromDict buildTrieFromDict = new BuildTrieFromDict();
        TrieNode root = buildTrieFromDict.buildTrie(dict);
        buildTrieFromDict.printByDfs(root);
        System.out.println(buildTrieFromDict.isWordPresent(root, "geek"));
        System.out.println(buildTrieFromDict.isWordPresent(root, "geeks"));
        System.out.println(buildTrieFromDict.isWordPresent(root, "geekshhjjj"));

    }
}
