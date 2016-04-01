import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Hide Company Tags Google
Hide Tags Depth-first Search Breadth-first Search Graph Union Find
Hide Similar Problems (M) Number of Islands (M) Graph Valid Tree
*/
public class NumberOfConnectedComponentsInAnUndirectedGraph323 {
	/*
    4
[[2,3],[1,2],[1,3]]
return 2;
1. 0
2. 1->2->3
*/
/*
    //DFS
    public int countComponents(int n, int[][] edges) {
        if(n <= 1)
        return n;
        
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
           //2  [[1,0]] 
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                System.out.println(i);
                count++;
                dfs(visited,adjList, i);
            }
        }
        return count;
    }
    
    public void dfs(boolean[] visited, ArrayList<ArrayList<Integer>> adjList, int index){
        visited[index] = true;
        
        for(int i : adjList.get(index)){
            if(!visited[i]){
                dfs(visited,adjList, i);
            }
            
        }
    }
    */
    
    //BFS
    public int countComponents(int n, int[][] edges) {
        if(n <= 1)
        return n;
        
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
           //2  [[1,0]] 
        }
         
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                Queue<Integer> queue=new LinkedList<Integer>();
                queue.offer(i);
                while(!queue.isEmpty()){
                    int cur=queue.poll();
                    visited[cur] = true;
                    for (int next : adjList.get(cur)) {
                        if (!visited[next]) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        
        return count;
    }
}
