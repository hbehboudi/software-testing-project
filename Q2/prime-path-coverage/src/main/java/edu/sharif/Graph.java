package edu.sharif;

import java.util.Collections;
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
        return edges.getOrDefault(source, Collections.emptyList());
    }

    public boolean hasEdge(String source, String target) {
        return edges.getOrDefault(source, Collections.emptyList()).contains(target);
    }
}
