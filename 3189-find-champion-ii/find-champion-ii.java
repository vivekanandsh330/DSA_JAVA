class Solution {
    public int findChampion(int n, int[][] edges) {
        int indgree[] = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indgree[v]++;
        }
        int champ = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (indgree[i] == 0) {
                champ = i;
                count++;
                if (count > 1) {
                    return -1;
                }
            }
        }
        return champ;
    }
}