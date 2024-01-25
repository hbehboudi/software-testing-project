package edu.sharif;

import java.util.List;
import java.util.Map;

public class Graph {

    private final List<String> nodes;
    private final Map<String, List<String>> edges;

    public Graph(List<String> nodes, Map<String, List<String>> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<String> getNodes() {
        return nodes;
    }

    public List<String> getTargets(String source) {
        return edges.get(source);
    }

    public boolean hasEdge(String source, String target) {
        return edges.get(source).contains(target);
    }
}