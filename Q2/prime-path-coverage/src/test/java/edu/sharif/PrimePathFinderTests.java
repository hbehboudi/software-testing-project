package edu.sharif;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimePathFinderTests {

    @Test
    public void LinearGraphTest() {
        var nodes = new ArrayList<String>();
        var edges = new HashMap<String, List<String>>();

        nodes.add("1");
        nodes.add("2");
        nodes.add("3");

        edges.put("1", List.of("2"));
        edges.put("2", List.of("3"));

        var graph = new Graph(nodes, edges);

        PrimePathFinder primePathFinder = new PrimePathFinder(graph);
        var primePaths = primePathFinder.findPrimePaths();

        assertEquals(1, primePaths.size());
        assertTrue(primePaths.contains(List.of("1", "2", "3")));
    }

    @Test
    public void LinearWithLoopGraphTest() {
        var nodes = new ArrayList<String>();
        var edges = new HashMap<String, List<String>>();

        nodes.add("1");
        nodes.add("2");
        nodes.add("3");

        edges.put("1", List.of("2"));
        edges.put("2", List.of("2", "3"));

        var graph = new Graph(nodes, edges);

        PrimePathFinder primePathFinder = new PrimePathFinder(graph);
        var primePaths = primePathFinder.findPrimePaths();

        assertEquals(2, primePaths.size());
        assertTrue(primePaths.contains(List.of("2", "2")));
        assertTrue(primePaths.contains(List.of("1", "2", "3")));
    }

    @Test
    public void CircularGraphTest() {
        var nodes = new ArrayList<String>();
        var edges = new HashMap<String, List<String>>();

        nodes.add("1");
        nodes.add("2");
        nodes.add("3");

        edges.put("1", List.of("2"));
        edges.put("2", List.of("3"));
        edges.put("3", List.of("1"));

        var graph = new Graph(nodes, edges);

        PrimePathFinder primePathFinder = new PrimePathFinder(graph);
        var primePaths = primePathFinder.findPrimePaths();

        assertEquals(3, primePaths.size());
        assertTrue(primePaths.contains(List.of("1", "2", "3", "1")));
        assertTrue(primePaths.contains(List.of("2", "3", "1", "2")));
        assertTrue(primePaths.contains(List.of("3", "1", "2", "3")));
    }

    @Test
    public void NonlinearGraphTest() {
        var nodes = new ArrayList<String>();
        var edges = new HashMap<String, List<String>>();

        nodes.add("1");
        nodes.add("2");
        nodes.add("3");
        nodes.add("4");

        edges.put("1", List.of("2", "3"));
        edges.put("3", List.of("2", "4"));
        edges.put("4", List.of("3"));

        var graph = new Graph(nodes, edges);

        PrimePathFinder primePathFinder = new PrimePathFinder(graph);
        var primePaths = primePathFinder.findPrimePaths();

        assertEquals(6, primePaths.size());
        assertTrue(primePaths.contains(List.of("1", "2")));
        assertTrue(primePaths.contains(List.of("1", "3", "2")));
        assertTrue(primePaths.contains(List.of("1", "3", "4")));
        assertTrue(primePaths.contains(List.of("3", "4", "3")));
        assertTrue(primePaths.contains(List.of("4", "3", "2")));
        assertTrue(primePaths.contains(List.of("4", "3", "4")));
    }
}
