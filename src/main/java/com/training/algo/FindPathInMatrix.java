package com.training.algo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class FindPathInMatrix {

    class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return i == node.i &&
                    j == node.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public void findPathBFS(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for (int i=0; i<visited.length; i++) {
            for (int j=0; j<visited[0].length; j++) {
                visited[i][j] = false;
            }
        }

        Map<Node, Node> path = new HashMap<>();
        Queue<Node> bfs = new LinkedList<>();

        Node first = new Node(0,0);
        bfs.add(first);
        while (!bfs.isEmpty()) {
            Node node = bfs.poll();
            visited[node.i][node.j] = true;

            if (node.i == arr.length-1 && node.j == arr[0].length-1) {
                break;
            }

            if (isSafe(arr, node.i+1, node.j, visited)) {
                Node unvisitedNode = new Node(node.i+1, node.j);
                bfs.add(unvisitedNode);
                path.put(unvisitedNode, node);
            }

            if (isSafe(arr, node.i, node.j+1, visited)) {
                Node unvisitedNode = new Node(node.i, node.j+1);
                bfs.add(unvisitedNode);
                path.put(unvisitedNode, node);
            }

            if (isSafe(arr, node.i-1, node.j, visited)) {
                Node unvisitedNode = new Node(node.i-1, node.j);
                bfs.add(unvisitedNode);
                path.put(unvisitedNode, node);
            }

            if (isSafe(arr, node.i, node.j-1, visited)) {
                Node unvisitedNode = new Node(node.i, node.j-1);
                bfs.add(unvisitedNode);
                path.put(unvisitedNode, node);
            }

        }

        // filling the track
//        for (Map.Entry<Node, Node> node : path.entrySet()) {
//                arr[node.getKey().i][node.getKey().j] = 2;
//                arr[node.getValue().i][node.getValue().j] = 2;
//        }
        Node node = path.get(new Node(arr.length-1, arr[0].length-1));
        if (node != null) {
            arr[arr.length-1][arr[0].length-1] = 2;
            while (node != null) {
                arr[node.i][node.j] = 2;
                node = path.get(node);
            }
        }
    }

    private boolean isSafe(int[][] arr, int i, int j, boolean[][] visited) {
        return i >= 0 && i <= arr.length-1 && j >= 0 && j <= arr[0].length-1 && arr[i][j] == 0 && !visited[i][j];
    }

    private void printArr(int[][] arr) {
        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[0].length; j++) {
                System.out.printf("%5d ", arr[i][j]);
            }
            System.out.println();
        }

        System.out.println("*******");
    }

    public static void main(String[] args) {
        int[][] arr =
                {
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0, 1, 0},
                        {1, 0, 0, 0, 1, 0, 0},
                        {1, 1, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 0, 0, 0}
                };

        FindPathInMatrix findPathInMatrix = new FindPathInMatrix();
        findPathInMatrix.printArr(arr);
        findPathInMatrix.findPathBFS(arr);
        findPathInMatrix.printArr(arr);
    }
}
