package KruskalPath;

import java.util.*;

public class KruskalPath {
    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    static class Edge implements Comparable<Edge> {
        public int weight;
        public String nodeV;
        public String nodeU;

        public Edge(int weight, String nodeV, String nodeU) {
            this.weight = weight;
            this.nodeV = nodeV;
            this.nodeU = nodeU;
        }

        // System.out.println() 으로 객체 자체 출력시, 다음 메서드를 호출하여, 원하는 attribute등을 출력할 수 있음
        public String toString() {
            return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
        }

        @Override
        public int compareTo(Edge edge)
        {
            return this.weight - edge.weight;
        }
    }

    public String find(String node) {
        // path compression 기법: 루트를 찾는 도중에 만나는 노드들은 부모로 묶는다
        if (!this.parent.get(node).equals(node)) {
            this.parent.put(node, this.find(this.parent.get(node)));
        }

        return this.parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = this.find(nodeV);
        String root2 = this.find(nodeU);

        // union-by-rank 기법: 각 노드의 랭크를 비교하고 높은 쪽 밑으로 붙인다.
        if (this.rank.get(root1) > this.rank.get(root2)) {
            this.parent.put(root2, root1);
        } else {
            this.parent.put(root1, root2);
            if (this.rank.get(root1).equals(this.rank.get(root2))) {
                this.rank.put(root2, this.rank.get(root2) + 1);
            }
        }
    }

    public void makeSet(String node) {      // 초기화 함수
        this.parent.put(node, node);
        this.rank.put(node, 0);
    }

    public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<Edge>();
        Edge currentEdge;

        // 1. 초기화
        for (int index = 0; index < vertices.size(); index++) {
            this.makeSet(vertices.get(index));
        }

        // 2. 간선 weight 기반 sorting
        Collections.sort(edges);

        // 탐욕 알고리즘에 기초하여 가중치가 적은 순으로 코드를 돌린다
        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (!this.find(currentEdge.nodeV).equals(this.find(currentEdge.nodeU))) {
                this.union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        KruskalPath kObject = new KruskalPath();
        System.out.println(kObject.kruskalFunc(vertices, edges));
    }
}
