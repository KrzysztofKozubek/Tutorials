package cBeanWithoutConstructor;

import java.util.Arrays;
import java.util.List;

public class ConnectionManager {

    private List<String> connections;

    private ConnectionManager(){}

    private ConnectionManager(String... connections) {
        this.connections = Arrays.asList(connections);
    }

    static ConnectionManager getInstance(String... connections) {
        return new ConnectionManager(connections);
    }

    public List<String> getConnections() {
        return connections;
    }
}
