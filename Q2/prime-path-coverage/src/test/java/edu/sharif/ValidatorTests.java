package edu.sharif;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTests {
    @Test
    public void validTest() {
        var nodes = List.of("1", "2", "3", "4");
        var edges = Map.of(
                "1", List.of("2", "3"),
                "3", List.of("2", "4"),
                "4", List.of("3"));
        var initialNodes = List.of("1");
        var finalNodes = List.of("2");

        var validator = new Validator();
        validator.validate(nodes, edges, initialNodes, finalNodes);
    }

    @Test
    public void invalidSourceTest() {
        var nodes = List.of("1", "2", "3", "4");
        var edges = Map.of(
                "5", List.of("2", "3"),
                "3", List.of("2", "4"),
                "4", List.of("3"));
        var initialNodes = List.of("1");
        var finalNodes = List.of("2");

        var validator = new Validator();
        var exception = assertThrows(RuntimeException.class,
                () -> validator.validate(nodes, edges, initialNodes, finalNodes));

        assertEquals("A number of edges are wrong", exception.getMessage());
    }

    @Test
    public void invalidTargetTest() {
        var nodes = List.of("1", "2", "3", "4");
        var edges = Map.of(
                "1", List.of("5", "3"),
                "3", List.of("2", "4"),
                "4", List.of("3"));
        var initialNodes = List.of("1");
        var finalNodes = List.of("2");

        var validator = new Validator();
        var exception = assertThrows(RuntimeException.class,
                () -> validator.validate(nodes, edges, initialNodes, finalNodes));

        assertEquals("A number of edges are wrong", exception.getMessage());
    }

    @Test
    public void invalidInitialTest() {
        var nodes = List.of("1", "2", "3", "4");
        var edges = Map.of(
                "1", List.of("2", "3"),
                "3", List.of("2", "4"),
                "4", List.of("3"));
        var initialNodes = List.of("3");
        var finalNodes = List.of("2");

        var validator = new Validator();
        var exception = assertThrows(RuntimeException.class,
                () -> validator.validate(nodes, edges, initialNodes, finalNodes));

        assertEquals("A number of nodes are not connected to initial nodes", exception.getMessage());
    }

    @Test
    public void invalidFinalTest() {
        var nodes = List.of("1", "2", "3", "4");
        var edges = Map.of(
                "1", List.of("2", "3"),
                "3", List.of("2", "4"),
                "4", List.of("3"));
        var initialNodes = List.of("1");
        var finalNodes = List.of("3");

        var validator = new Validator();
        var exception = assertThrows(RuntimeException.class,
                () -> validator.validate(nodes, edges, initialNodes, finalNodes));

        assertEquals("A number of nodes are not connected to final nodes", exception.getMessage());
    }
}
