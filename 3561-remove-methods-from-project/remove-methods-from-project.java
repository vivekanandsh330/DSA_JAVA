import java.util.*;

class Solution {
    Set<Integer> suspicious = new HashSet<>();
    private void dfs(int node, int[] visited, Map<Integer,List<Integer>> graph) {
        suspicious.add(node);
        visited[node] = 1;

        for (int neighbor : graph.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(neighbor,visited, graph);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,Set<Integer>> invoked_by = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            invoked_by.putIfAbsent(i, new HashSet<>());
        }

        for (int[] invocation : invocations) {
            int u = invocation[0];
            int v = invocation[1];
            graph.computeIfAbsent(u,a-> new ArrayList<>()).add(v);
            invoked_by.computeIfAbsent(v,a->new HashSet<>()).add(u);
        }
        int[] visited = new int[n];
        dfs(k, visited, graph);

        boolean canRemove = true;

        for (int method : suspicious) {
            for (int invoker : invoked_by.get(method)) {
                if (!suspicious.contains(invoker)) {
                    canRemove = false;
                    break;
                }
            }
            if (!canRemove) break;
        }
        List<Integer> result = new ArrayList<>();
        if (canRemove) {
            for (int i = 0; i < n; i++) {
                if (!suspicious.contains(i)) {
                    result.add(i);
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
        }

        return result;
    }
}
