package DijkstraPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath {

    static class Edge implements Comparable<Edge> {
        public int distance;
        public String vertex;

        public Edge(int distance, String vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }

        // System.out.println() 으로 객체 자체 출력시, 다음 메서드를 호출하여, 원하는 attribute등을 출력할 수 있음
        public String toString() {
            return "vertex: " + this.vertex + ", distance: " + this.distance;
        }

        @Override
        public int compareTo(Edge edge)
        {
            return this.distance - edge.distance;
        }
    }

    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String startNode) {
        Edge edgeNode, adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance, weight, distance;
        String currentNode, adjacent;

        HashMap<String, Integer> distances = new HashMap<String, Integer>();    // 필요한 출력 값
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }

        distances.put(startNode, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();          // 우선순위 큐 생성
        priorityQueue.add(new Edge(distances.get(startNode), startNode));   // 맨 처음 startNode로 초기화

        // 알고리즘 작성
        while ( priorityQueue.size() > 0 ) {
            edgeNode = priorityQueue.poll(); // 큐의 첫번째 노드를 삭제하고 가져옴
            currentDistance = edgeNode.distance;    // 현재 노드의 거리를 가져온다.
            currentNode = edgeNode.vertex;

            if ( currentDistance > distances.get(currentNode) ) {   // 저장되어있는 거리가 구했을 때의 길이보다 클 때
                continue;
            }

            nodeList = graph.get(currentNode);  // 현재 노드에 연결되어 있는 노드리스트를 가져오기 위함
            for ( int i = 0; i < nodeList.size(); i++ ) {
                adjacentNode = nodeList.get(i);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;

                if ( distance < distances.get(adjacent) ) { // 더한 거리가 distances의 가중치 보다 적을 때
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        DijkstraPath dObject = new DijkstraPath();
        System.out.println(dObject.dijkstraFunc(graph, "A"));
    }
}
