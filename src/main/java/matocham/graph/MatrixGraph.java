package matocham.graph;

import com.sun.javafx.geom.Edge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixGraph implements Graph{
    int[][] graph;
    private List<String> questions;

    @Override
    public void loadGraph(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        String propertyLine = reader.readLine();
        String[] properties = propertyLine.split(" ");
        int vertexCount = Integer.parseInt(properties[0]);
        int edgeCount = Integer.parseInt(properties[1]);
        int questionsCount = Integer.parseInt(properties[2]);
        graph = new int[vertexCount][vertexCount];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], -1);
        }
        for (int i = 0; i < edgeCount; i++) {
            String line = reader.readLine();
            String[] edgeDesc = line.split(" ");
            graph[Integer.parseInt(edgeDesc[0])][Integer.parseInt(edgeDesc[1])] = Integer.parseInt(edgeDesc[2]);
        }
        questions = new ArrayList<>();
        for (int i = 0; i < questionsCount; i++) {
            questions.add(reader.readLine());
        }
        reader.close();
    }

    @Override
    public void bfs(int startingVertex) {
        int[] color = new int[graph.length];
        int[] distance = new int[graph.length];
        int[] parent = new int[graph.length];
        parent[startingVertex] = -1;
        Arrays.fill(distance, Integer.MAX_VALUE);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        color[startingVertex] = 1;
        distance[startingVertex] = 0;
        queue.addLast(startingVertex);
        while(!queue.isEmpty()){
            int currentVertex = queue.pop();
            for (int i = 0; i < graph.length; i++) {
                if(graph[currentVertex][i] == -1){
                    continue;
                }
                if(color[i] == 0){
                    System.out.println("visiting " + i);
                    color[i] = 1;
                    distance[i] = distance[currentVertex] + 1;
                    parent[i] = currentVertex;
                    queue.addLast(i);
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
        int[] color = new int[graph.length];
        int[] distance = new int[graph.length];
        int[] parent = new int[graph.length];
        parent[startingVertex] = -1;
        Arrays.fill(distance, Integer.MAX_VALUE);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        color[startingVertex] = 1;
        distance[startingVertex] = 0;
        queue.addFirst(startingVertex);
        while(!queue.isEmpty()){
            int currentVertex = queue.pop();
            for (int i = 0; i < graph.length; i++) {
                if(graph[currentVertex][i] == -1){
                    continue;
                }
                if(color[i] == 0){
                    color[i] = 1;
                    System.out.println("visiting " + i);
                    distance[i] = distance[currentVertex] + 1;
                    parent[i] = currentVertex;
                    queue.addFirst(i);
                }
                color[currentVertex] = 3;
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println("Distance from " + startingVertex + " to " + i + " is " + distance[i]);
            System.out.println("Path is " + getPathBetween(startingVertex, i, parent));
        }
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < graph.length; i++) {
            result.append(Arrays.toString(graph[i])).append("\n");
        }
        return result.toString();
    }
}
