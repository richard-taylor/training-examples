package com.ukcloud.booleans;

import java.util.*;

/**
 * A circuit is a collection of connections between logic units.
 */
public class Circuit {

    public static final int DEFAULT_PROPAGATION_LIMIT = 1000;

    private final List<Connection> connections = new ArrayList<>();
    private final Map<Connection,Boolean> states = new HashMap<>();
    private final int propagationLimit;

    public Circuit() {
        this(DEFAULT_PROPAGATION_LIMIT);
    }

    public Circuit(int propagationLimit) {
        this.propagationLimit = propagationLimit;
    }

    public void add(final Connection connection) {
        connections.add(connection);
    }

    public void add(final Circuit other) {
        connections.addAll(other.connections);
    }

    public int propagate() {

        // We do not know the "right" order to evaluate the connections in.
        // So randomise the order and keep propagating until nothing changes.
        // Or we get bored...

        int changes = iterate();
        int iterations = 1;

        while (changes > 0 && iterations < propagationLimit) {
            changes = iterate();
            iterations++;
        }

        if (changes > 0) {
            throw new NoSteadyStateException(String.format("After %d iterations.", iterations));
        }
        return iterations;
    }

    private int iterate() {
        Collections.shuffle(connections);
        int changes = 0;

        for (final Connection connection : connections) {
            final Boolean newState = connection.propagate();
            final Boolean oldState = states.getOrDefault(connection, Boolean.FALSE);

            if (!newState.equals(oldState)) {
                changes++;
                states.put(connection, newState);
            }
        }
        return changes;
    }
}
