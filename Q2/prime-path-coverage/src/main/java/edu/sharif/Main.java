package edu.sharif;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        var graph = readGraph();

        var finder = new PrimePathFinder(graph);
        var paths = finder.findPrimePaths();

        System.out.println();

        for (var i = 0; i < paths.size(); i++) {
            System.out.printf("Prime path %d: %s\n", i + 1, paths.get(i));
        }
    }

    private static Graph readGraph() {
        var scanner = new Scanner(System.in);

        System.out.print("Please enter the number of nodes: ");
        var numberOfNodes = scanner.nextInt();

        System.out.print("Please enter the number of edges: ");
        var numberOfEdges = scanner.nextInt();

        var nodes = new ArrayList<String>();
        for (var i = 0; i < numberOfNodes; i++) {
            System.out.printf("Please enter the name of node %d: ", i + 1);
            nodes.add(scanner.next());
        }

        var edges = new HashMap<String, List<String>>();
        for (var node : nodes) {
            edges.put(node, new ArrayList<>());
        }
        for (var i = 0; i < numberOfEdges; i++) {
            System.out.printf("Please enter the name of the source node of edge %d: ", i + 1);
            var source = scanner.next();

            System.out.printf("Please enter the name of the target node of edge %d: ", i + 1);
            var target = scanner.next();

            edges.get(source).add(target);
        }

        return new Graph(nodes, edges);
    }
}
