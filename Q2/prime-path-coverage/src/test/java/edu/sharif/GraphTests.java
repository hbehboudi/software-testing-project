package edu.sharif;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTests {

    @Test
    public void getNodesTest() {
        var nodes = new ArrayList<String>();
        var edges = new HashMap<String, List<String>>();

        nodes.add("1");
        nodes.add("2");
        nodes.add("3");

        edges.put("1", List.of("2"));
        edges.put("2", List.of("3"));

        var graph = new Graph(nodes, edges);

        assertEquals(nodes, graph.getNodes());
    }

    @Test
    public void getTargetsTest() {
        var nodes = new ArrayList<String>();
        var edges = new HashMap<String, List<String>>();

        nodes.add("1");
        nodes.add("2");
        nodes.add("3");

        edges.put("1", List.of("2", "3"));
        edges.put("2", List.of("3"));

        var graph = new Graph(nodes, edges);

        assertEquals(List.of("2", "3"), graph.getTargets("1"));
        assertEquals(List.of("3"), graph.getTargets("2"));
        assertEquals(List.of(), graph.getTargets("3"));
    }

    @Test
    public void hasEdgeTest() {
        var nodes = new ArrayList<String>();
        var edges = new HashMap<String, List<String>>();

        nodes.add("1");
        nodes.add("2");
        nodes.add("3");

        edges.put("1", List.of("2", "3"));
        edges.put("2", List.of("3"));

        var graph = new Graph(nodes, edges);

        assertTrue(graph.hasEdge("1", "2"));
        assertTrue(graph.hasEdge("1", "3"));
        assertTrue(graph.hasEdge("2", "3"));
        assertFalse(graph.hasEdge("2", "1"));
        assertFalse(graph.hasEdge("3", "1"));
        assertFalse(graph.hasEdge("3", "2"));
    }
}
