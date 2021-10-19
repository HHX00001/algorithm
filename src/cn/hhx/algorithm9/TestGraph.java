package cn.hhx.algorithm9;

/**
 * @author hhxStellar
 * @date 2021/10/18-18:23
 */
public class TestGraph {
    public static void main(String[] args) {
        Graph graph = getGraph();
        graph.showGraph();
        System.out.println("-------深度优先----------");
        graph.DFS();
        System.out.println();
        System.out.println("-------广度优先----------");
        graph.BFS();
    }

    public static Graph getGraph() {
        String[] vertexes = {"v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8"};
        Graph graph = new Graph(vertexes.length);
        for (int i = 0; i < vertexes.length; i++) {
            graph.insertVertex(vertexes[i]);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(5, 6, 1);

        return graph;
    }
}
