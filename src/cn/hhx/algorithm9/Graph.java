package cn.hhx.algorithm9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hhxStellar
 * @date 2021/10/18-18:12
 */
public class Graph {
    public ArrayList<String> vertexList;
    public int[][] edges;
    public int numOfEdges;

    public Graph() {
    }

    public Graph(int numOfVertex) {
        edges = new int[numOfVertex][numOfVertex];
        vertexList = new ArrayList<>();
    }

    public void insertVertex(String vertexName) {
        vertexList.add(vertexName);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getVertexByIndex(int index) {
        return vertexList.get(index);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int i = 0; i < edges.length + 1; i++) {
            if (i == 0) {
                System.out.print("   ");
                continue;
            }
            System.out.print(vertexList.get(i - 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length + 1; j++) {
                if (j == 0) {
                    System.out.print(vertexList.get(i) + " ");
                    continue;
                }
                System.out.print(edges[i][j - 1] + "  ");
            }
            System.out.println();
        }
    }

    public void DFS() {
        boolean[] isVisited = new boolean[vertexList.size()];
        DFS(0, isVisited);
    }

    private void DFS(int i, boolean[] isVisited) {
        if (!isVisited[i]) {
            System.out.print(vertexList.get(i) + " ");
            isVisited[i] = true;
            for (int j = i + 1; j < vertexList.size(); j++) {
                if (edges[i][j] != 0) {
                    DFS(j, isVisited);
                }
            }
        }
    }

    public void BFS() {
        boolean[] isVisited = new boolean[vertexList.size()];
        Queue<Integer> vertexIndexList = new LinkedList<>();
        vertexIndexList.add(0);
        BFS(vertexIndexList, isVisited);
    }

    public void BFS(Queue<Integer> vertexQueue, boolean[] isVisited) {
//        if (vertexQueue.isEmpty()) {
//            return;
//        }

        while (!vertexQueue.isEmpty()) {

            int[] vertexIndexes = new int[vertexQueue.size()];
            for (int i = 0; i < vertexIndexes.length; i++) {
                vertexIndexes[i] = vertexQueue.remove();
                System.out.print(vertexList.get(vertexIndexes[i]) + " ");
                isVisited[vertexIndexes[i]] = true;
            }

            for (int i = 0; i < vertexIndexes.length; i++) {
                for (int j = 0; j < vertexList.size(); j++) {
                    if (!isVisited[j] && edges[vertexIndexes[i]][j] != 0 && !vertexQueue.contains(j)) {
                        vertexQueue.add(j);
                    }
                }
            }

        }

//        BFS(vertexQueue, isVisited);
    }
}
