package edu.sharif;

import java.util.ArrayList;
import java.util.List;

public class PrimePathFinder {

    private final Graph graph;

    public PrimePathFinder(Graph graph) {
        this.graph = graph;
    }

    public List<List<String>> findPrimePaths() {
        var expectedPaths = new ArrayList<List<String>>();

        for (var node : graph.getNodes()) {
            expectedPaths.add(List.of(node));
        }

        var result = new ArrayList<List<String>>();
        findSimplePath(expectedPaths, result);
        return result;
    }

    private void findSimplePath(List<List<String>> expectedPaths, List<List<String>> paths) {
        paths.addAll(expectedPaths.stream().filter(this::isPrimePath).toList());
        expectedPaths = expectedPaths.stream().filter(this::isExtendable).toList();

        var newExpectedPaths = new ArrayList<List<String>>();

        for (var expectedPath : expectedPaths) {
            for (var nextNode : graph.getTargets(expectedPath.getLast())) {
                if (!expectedPath.contains(nextNode) || nextNode.equals(expectedPath.getFirst())) {
                    var newPath = new ArrayList<>(expectedPath);
                    newPath.add(nextNode);
                    newExpectedPaths.add(newPath);
                }
            }
        }

        if (!newExpectedPaths.isEmpty()) {
            findSimplePath(newExpectedPaths, paths);
        }
    }

    private boolean isExtendable(List<String> path) {
        return !isPrimePath(path) && !reachEnd(path);
    }

    private boolean isPrimePath(List<String> path) {
        if (path.size() >= 2 && path.getFirst().equals(path.getLast())) {
            return true;
        }

        return reachHead(path) && reachEnd(path);
    }

    private boolean reachHead(List<String> path) {
        var formerNodes = graph.getNodes().stream().filter(n -> graph.hasEdge(n, path.getFirst())).toList();

        for (var formerNode : formerNodes) {
            if (!path.contains(formerNode) || formerNode.equals(path.getLast())) {
                return false;
            }
        }

        return true;
    }

    private boolean reachEnd(List<String> path) {
        var laterNodes = graph.getTargets(path.getLast());

        for (var laterNode : laterNodes) {
            if (!path.contains(laterNode) || laterNode.equals(path.getFirst())) {
                return false;
            }
        }

        return true;
    }
}
