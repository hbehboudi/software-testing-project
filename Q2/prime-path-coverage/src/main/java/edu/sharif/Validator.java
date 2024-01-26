package edu.sharif;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Validator {

    public void validate(List<String> nodes, Map<String, List<String>> edges,
                         List<String> initialNodes, List<String> finalNodes) {
        for (var source : edges.keySet()) {
            for (var target : edges.get(source)) {
                if (!nodes.contains(source) || !nodes.contains(target)) {
                    throw new RuntimeException("A number of edges are wrong");
                }
            }
        }

        if (!canReachAllNodes(nodes, edges, initialNodes)) {
            throw new RuntimeException("A number of nodes are not connected to initial nodes");
        }

        if (!canBeReachedAllNodes(nodes, edges, finalNodes)) {
            throw new RuntimeException("A number of nodes are not connected to final nodes");
        }
    }

    private boolean canReachAllNodes(List<String> nodes, Map<String, List<String>> edges, List<String> initialNodes) {
        var visited = new HashSet<String>();

        for (var initialNode : initialNodes) {
            dfsUtil(initialNode, visited, edges);
        }

        return visited.containsAll(nodes);
    }

    private boolean canBeReachedAllNodes(List<String> nodes, Map<String, List<String>> edges, List<String> finalNodes) {
        var invertedEdges = new HashMap<String, List<String>>();

        for (var node : nodes) {
            invertedEdges.put(node, new ArrayList<>());
        }

        for (var source : edges.keySet()) {
            for (var target : edges.get(source)) {
                invertedEdges.get(target).add(source);
            }
        }

        return canReachAllNodes(nodes, invertedEdges, finalNodes);
    }

    private void dfsUtil(String node, Set<String> visited, Map<String, List<String>> edges) {
        visited.add(node);

        for (var target : edges.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(target)) {
                dfsUtil(target, visited, edges);
            }
        }
    }
}
