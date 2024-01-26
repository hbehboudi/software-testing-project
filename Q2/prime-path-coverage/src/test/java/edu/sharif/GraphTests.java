package edu.sharif;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTests {

    @Test
    public void getNodesTest() {
        var nodes = List.of("1", "2", "3");
        var edges = Map.of(
                "1", List.of("2"),
                "2", List.of("3"));

        var graph = new Graph(nodes, edges);

        assertEquals(nodes, graph.getNodes());
    }

    @Test
    public void getTargetsTest() {
        var nodes = List.of("1", "2", "3");
        var edges = Map.of(
                "1", List.of("2", "3"),
                "2", List.of("3"));

        var graph = new Graph(nodes, edges);

        assertEquals(List.of("2", "3"), graph.getTargets("1"));
        assertEquals(List.of("3"), graph.getTargets("2"));
        assertEquals(List.of(), graph.getTargets("3"));
    }

    @Test
    public void hasEdgeTest() {
        var nodes = List.of("1", "2", "3");
        var edges = Map.of(
                "1", List.of("2", "3"),
                "2", List.of("3"));

        var graph = new Graph(nodes, edges);

        assertTrue(graph.hasEdge("1", "2"));
        assertTrue(graph.hasEdge("1", "3"));
        assertTrue(graph.hasEdge("2", "3"));
        assertFalse(graph.hasEdge("2", "1"));
        assertFalse(graph.hasEdge("3", "1"));
        assertFalse(graph.hasEdge("3", "2"));
    }
}
