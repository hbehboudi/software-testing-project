package edu.sharif;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimePathFinderTests {

    @Test
    public void LinearGraphTest() {
        var nodes = List.of("1", "2", "3");
        var edges = Map.of(
                "1", List.of("2"),
                "2", List.of("3"));

        var graph = new Graph(nodes, edges);
        var primePathFinder = new PrimePathFinder(graph);
        var primePaths = primePathFinder.findPrimePaths();

        assertEquals(1, primePaths.size());
        assertTrue(primePaths.contains(List.of("1", "2", "3")));
    }

    @Test
    public void LinearWithLoopGraphTest() {
        var nodes = List.of("1", "2", "3");
        var edges = Map.of(
                "1", List.of("2"),
                "2", List.of("2", "3"));

        var graph = new Graph(nodes, edges);
        var primePathFinder = new PrimePathFinder(graph);
        var primePaths = primePathFinder.findPrimePaths();

        assertEquals(2, primePaths.size());
        assertTrue(primePaths.contains(List.of("2", "2")));
        assertTrue(primePaths.contains(List.of("1", "2", "3")));
    }

    @Test
    public void CircularGraphTest() {
        var nodes = List.of("1", "2", "3");
        var edges = Map.of(
                "1", List.of("2"),
                "2", List.of("3"),
                "3", List.of("1"));

        var graph = new Graph(nodes, edges);
        var primePathFinder = new PrimePathFinder(graph);
        var primePaths = primePathFinder.findPrimePaths();

        assertEquals(3, primePaths.size());
        assertTrue(primePaths.contains(List.of("1", "2", "3", "1")));
        assertTrue(primePaths.contains(List.of("2", "3", "1", "2")));
        assertTrue(primePaths.contains(List.of("3", "1", "2", "3")));
    }

    @Test
    public void NonlinearGraphTest() {
        var nodes = List.of("1", "2", "3", "4");
        var edges = Map.of(
                "1", List.of("2", "3"),
                "3", List.of("2", "4"),
                "4", List.of("3"));

        var graph = new Graph(nodes, edges);
        var primePathFinder = new PrimePathFinder(graph);
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
