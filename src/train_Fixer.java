import java.util.ArrayList;
import java.util.List;

public class train_Fixer {

    static int n; // antal stationer
    static List<List<Integer>> graph;
    static List<List<Integer>> reversedGraph;


    // Bygger grafen UDEN kanten edges[skipIndex]
    static void buildGraphWithoutEdge(int[][] edges, int skipIndex) {
        graph = new ArrayList<>();
        reversedGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == skipIndex) continue; // spring den kant over

            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            reversedGraph.get(v).add(u); // den modsatte retning
        }
    }

    // Tjekker om grafen er stærkt sammenhængende
    static boolean isStronglyConnected() {
        boolean[] visited = new boolean[n + 1];
        dfs(1, visited, graph);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return false;
        }

        visited = new boolean[n + 1];
        dfs(1, visited, reversedGraph);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return false;
        }

        return true;
    }

    static void dfs(int node, boolean[] visited, List<List<Integer>> g) {
        visited[node] = true;
        for (int neighbor : g.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, g);
            }
        }
    }
}

