package com.training.algo.uber;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>
 *      <foo>Hello</foo>
 *      <bar>world</bar>
 * </a>
 * <b>
 *      <baz>
 *      </baz>
 * </b>
 */

//***************************************
//** SOLUTION BEGIN
//***************************************

class XmlParser {

    public Node parse(Tokenizer tokenizer) {
        Node root = new Node();
        root.name = "root";
        addToNode(root, tokenizer);
        return root;
    }

    private void addToNode(Node node, Tokenizer tokenizer) {

        Node currentNode = node;
        Node parentNode = node;
        for (Token token = tokenizer.getNextToken(); token != null; token = tokenizer.getNextToken()) {
            switch (token.type) {
                case BEGIN: {
                        Node childNode = new Node();
                        childNode.name = token.value;
                        currentNode.children.add(childNode);
                        //addToNode(childNode, tokenizer);
                        parentNode = currentNode;
                        currentNode = childNode;
                    }
                    break;

                case END:
                    currentNode = parentNode;
                    break;

                case TEXT:
                    Node childNode = new Node();
                    childNode.text = token.value;
                    currentNode.children.add(childNode);
                    break;

            }
        }
    }

//***************************************
//** SOLUTION END
//***************************************

//***************************************
//** Token / Tokenizer / Node
//***************************************

    static class Token {

        enum Type {
            BEGIN, TEXT, END
        }


        public Type type;
        public String value;

        Token(Type type, String value) {
            this.type = type;
            this.value = value;
        }
    }

    interface Tokenizer {

        Token getNextToken();
    }

    class Node {

        public String name;
        public String text;
        public List<Node> children = new ArrayList<>();

        public String getName() {
            return name;
        }

        public String getText() {
            return text;
        }

        public List<Node> getChildren() {
            return children;
        }
    }

//***************************************
//** Test Runner
//***************************************


    static class NodePrinter {

        private static final String TAB = "  ";
        private int level = 0;

        void print(Node n) {
            if (n.getName() != null) {
                print("<" + n.getName() + ">");
            }
            if (n.getText() != null) {
                print(n.getText(), false);
            }
            if (n.getChildren().size() > 0) {
                level++;
                for (Node c : n.getChildren()) {
                    println();
                    print(c);
                }
                level--;
                println();
            }
            if (n.getName() != null) {
                print("</" + n.getName() + ">", n.getChildren().size() > 0);
            }
        }

        void print(String str) {
            print(str, true);
        }

        void print(String str, boolean printLevel) {
            for (int i = 0; i < level && printLevel; i++) {
                System.out.print(TAB);
            }
            System.out.print(str);
        }

        void println() {
            System.out.println();
        }
    }

    static class SimpleTokenizer implements Tokenizer {

        private int idx = 0;

        private Token[] tokens = new Token[]{
                new Token(Token.Type.BEGIN, "a"),
                new Token(Token.Type.BEGIN, "foo"),
                new Token(Token.Type.TEXT, "Hello"),
                new Token(Token.Type.END, "foo"),
                new Token(Token.Type.BEGIN, "bar"),
                new Token(Token.Type.TEXT, "world"),
                new Token(Token.Type.END, "bar"),
                new Token(Token.Type.END, "a"),
                new Token(Token.Type.BEGIN, "b"),
                new Token(Token.Type.BEGIN, "baz"),
                ///
                new Token(Token.Type.BEGIN, "baz111"),
                new Token(Token.Type.TEXT, "baz text"),
                new Token(Token.Type.END, "baz111"),
                ///
                new Token(Token.Type.END, "baz"),
                new Token(Token.Type.END, "b")
        };

        @Override
        public Token getNextToken() {
            if (idx < tokens.length) {
                return tokens[idx++];
            }
            return null;
        }
    }
}

class Solution {
    public static void main(String args[]) throws Exception {
        XmlParser.Tokenizer tokenizer = new XmlParser.SimpleTokenizer();
        XmlParser parser = new XmlParser();
        XmlParser.Node n = parser.parse(tokenizer);
        XmlParser.NodePrinter printer = new XmlParser.NodePrinter();
        printer.print(n);
    }
}
