package matocham.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacencyListsGraph implements Graph {
    List<List<Edge>> graph = new ArrayList<>();
    List<String> questions = new ArrayList<>();

    @Override
    public void loadGraph(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        String propertyLine = reader.readLine();
        String[] properties = propertyLine.split(" ");
        int vertexCount = Integer.parseInt(properties[0]);
        int edgeCount = Integer.parseInt(properties[1]);
        int questionsCount = Integer.parseInt(properties[2]);
        for (int i = 0; i < vertexCount; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edgeCount; i++) {
            String line = reader.readLine();
            String[] edgeDesc = line.split(" ");
            List<Edge> edges = graph.get(Integer.parseInt(edgeDesc[0]));
            edges.add(new Edge(Integer.parseInt(edgeDesc[1]), Integer.parseInt(edgeDesc[2])));
        }
        questions = new ArrayList<>();
        for (int i = 0; i < questionsCount; i++) {
            questions.add(reader.readLine());
        }
        reader.close();
    }

    @Override
    public void bfs(int startingVertex) {
        int[] color = new int[graph.size()];
        int[] distance = new int[graph.size()];
        int[] parent = new int[graph.size()];
        parent[startingVertex] = -1;
        Arrays.fill(distance, Integer.MAX_VALUE);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        color[startingVertex] = 1;
        distance[startingVertex] = 0;
        queue.addLast(startingVertex);
        while(!queue.isEmpty()){
            int currentVertex = queue.pop();
            List<Edge> edges = graph.get(currentVertex);
            for (Edge edge : edges) {
                if(color[edge.vertex] == 0){
                    System.out.println("visiting " + edge.vertex);
                    color[edge.vertex] = 1;
                    distance[edge.vertex] = distance[currentVertex] + 1;
                    parent[edge.vertex] = currentVertex;
                    queue.addLast(edge.vertex);
                }
                color[currentVertex] = 3;
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println("Distance from " + startingVertex + " to " + i + " is " + distance[i]);
            System.out.println("Path is " + getPathBetween(startingVertex, i, parent));
        }
    }

    private String getPathBetween(int startingVertex, int i, int[] parent) {
        if(startingVertex == i){
            return "";
        }
        StringBuilder path = new StringBuilder("From ").append(startingVertex);
        ArrayDeque<Integer> pathQueue = new ArrayDeque<>();
        int parentV = parent[i];
        pathQueue.addFirst(i);
        while(parentV != -1 && parentV != startingVertex){
            pathQueue.addFirst(parentV);
            parentV = parent[parentV];
        }
        if(parentV == -1){
            return "";
        }
        while(!pathQueue.isEmpty()){
            path.append("->").append(pathQueue.pop());
        }
        return path.toString();
    }

    @Override
    public void dfs(int startingVertex) {
        int[] color = new int[graph.size()];
        int[] distance = new int[graph.size()];
        int[] parent = new int[graph.size()];
        parent[startingVertex] = -1;
        Arrays.fill(distance, Integer.MAX_VALUE);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        color[startingVertex] = 1;
        distance[startingVertex] = 0;
        queue.addFirst(startingVertex);
        while(!queue.isEmpty()){
            int currentVertex = queue.pop();
            List<Edge> edges = graph.get(currentVertex);
            for (Edge edge : edges) {
                if(color[edge.vertex] == 0){
                    color[edge.vertex] = 1;
                    System.out.println("visiting " + edge.vertex);
                    distance[edge.vertex] = distance[currentVertex] + 1;
                    parent[edge.vertex] = currentVertex;
                    queue.addFirst(edge.vertex);
                }
                color[currentVertex] = 3;
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println("Distance from " + startingVertex + " to " + i + " is " + distance[i]);
            System.out.println("Path is " + getPathBetween(startingVertex, i, parent));
        }
    }

    private static class Edge {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge to:" + vertex + " W:" + weight;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int vertex = 0;
        for (List<Edge> edges : graph) {
            result.append("Vertex:").append(vertex++).append(", ").append(edges.toString()).append("\n");
        }
        return result.toString();
    }
}
