import java.util.*;
import java.util.Iterator;


public class BFS {
    static Map<Integer, Integer> nbrs(UndirectedGraph<Integer> G, Set<Integer> F) {
//        Set<Integer> theBigUnion = new HashSet<>();
    Map<Integer, Integer> theBigUnion = new HashMap<>();
    // Goal: if F = {v1, v2, v3, ... , vk},
    // theBigUnion = N(v1) u N(v2) u N(v3) ... N(vk)
    for (Integer src: F) {
        // find the nbrs of src and dump them into theBigUnion
        for (Integer dst: G.adj(src)) // is run deg(src) many times
            theBigUnion.put(dst, src); // O(1)
    }
    return theBigUnion;
}
    static Map<Integer, Integer> bfs(UndirectedGraph<Integer> G, int s) {
//        Set<Integer> frontier = new HashSet<>(List.of(s));  // F_i
//        Set<Integer> visited = new HashSet<>(List.of(s));   // X_i
        Map<Integer, Integer> frontier = new HashMap<>();
        Map<Integer, Integer> visited = new HashMap<>();

        // Invariant: visited[v] == how I got to v
        //                       == the "parent" through which I got to v
        visited.put(s, null); frontier.put(s, null);

        while (!frontier.isEmpty()) {
            frontier = nbrs(G, frontier.keySet());
            frontier.keySet().removeAll(visited.keySet());
            visited.putAll(frontier);
//            frontier = nbrs(G, frontier); // G.adj()
//            frontier.removeAll(visited);
//            visited.addAll(frontier);
        }
        // return all the vertices reachable from s
        return visited;

    }
    static int findShortest(UndirectedGraph<Integer> G, Integer a, Integer b){
        

        int[] parent = new int[G.numEdges()];
        boolean[] visited = new boolean[G.numEdges()];

        for(int i =0; i < G.numEdges(); i++){
            visited[i] = false;
            parent[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        visited[a] = true;
        queue.add(a);

        while(!queue.isEmpty()){

            int s = queue.peek();

            if(s == b)
                findShortestHelper(parent,s,b);
            queue.poll();

            for(int i : G.adj(s)){
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    parent[i] = s;
                }
            }
        }
        return 0;



    }

    public static int findShortestHelper(int[] parent, int s, int d){
        UndirectedGraph<Integer> G;
        int level = 0;
        if(parent[s] == -1)
            return level;
        findShortestHelper(parent, parent[s],d);
        level ++;
        return level;
    }



    static class UndirectedAdjMap<Vertex> implements UndirectedGraph<Vertex>{
        Map<Vertex, Set<Vertex>> graph = new HashMap<>();
        Set entrySet = graph.entrySet();
        Iterator<Vertex> it = entrySet.iterator();
        // vertex = key
        // set vertex = value
        private int numEdges = 0;
        @Override
        public int numEdges() {
            /*
            int count = 0;
            for (Set<Vertex> i: graph.values()){
                count += i.size();
            }

             */
            return numEdges;
        }



        @Override
        public int numVertices() {
            return graph.size();
        }

        @Override
        public void addVertex(Vertex v) {
            graph.put(v, new HashSet<>());

        }

        @Override
        public void addEdge(Vertex u, Vertex v) {
            addVertex(u);
            addVertex(v);

            graph.get(u).add(v);
            numEdges++;

        }

        @Override
        public void removeEdge(Vertex u, Vertex v) {

            graph.get(u).remove(v);
            numEdges--;


        }

        @Override
        public Iterable<Vertex> adj(Vertex v) {
            return graph.get(v);
        }

        @Override
        public int deg(Vertex v) {
            if(graph.containsKey(v))
                return graph.get(v).size();
            return 0;
        }

        @Override
        public boolean isEdge(Vertex u, Vertex v) {
            return graph.get(v).contains(u) || graph.get(u).contains(v);
        }
    }

    public static void main(String[] args) {
        UndirectedGraph<Integer> g = new UndirectedAdjMap<Integer>();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addEdge(1,3);
        g.addEdge(3,2);
        g.addEdge(3,0);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(2,0);
        g.addEdge(2,3);

        System.out.println(findShortest(g,2,1));
    }

}

