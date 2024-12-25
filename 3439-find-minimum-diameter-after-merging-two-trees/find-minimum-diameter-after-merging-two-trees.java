import java.util.*;

class Solution {
    public int initialNode(HashMap<Integer, List<Integer>> edges) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        int furthestNode = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            furthestNode = node;
            for (int neighbor : edges.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return furthestNode;
    }

    public int furthestDistance(int start, HashMap<Integer, List<Integer>> edges) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int distance = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : edges.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return distance;
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        HashMap<Integer, List<Integer>> tree1 = new HashMap<>();
        HashMap<Integer, List<Integer>> tree2 = new HashMap<>();
        for (int[] edge : edges1) {
            tree1.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            tree1.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        for (int[] edge : edges2) {
            tree2.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            tree2.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int start1 = initialNode(tree1);
        int diameter1 = furthestDistance(start1, tree1);

        int start2 = initialNode(tree2);
        int diameter2 = furthestDistance(start2, tree2);

        int combinedDiameter = (int) Math.ceil(diameter1 / 2.0) + (int) Math.ceil(diameter2 / 2.0) + 1;

        return Math.max(Math.max(diameter1, diameter2), combinedDiameter);
    }
}