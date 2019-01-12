package matocham.graph;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Graph {
    void loadGraph(String path) throws IOException;
    void bfs(int startingVertex);
    void dfs(int startingVertex);
}
