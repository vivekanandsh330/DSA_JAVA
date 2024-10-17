class Solution {
    public int maximumSwap(int num) {
        char[] numArray = Integer.toString(num).toCharArray();
        int n = numArray.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{numArray[i] - '0', i});
        }

        int[] lastIndex = new int[10];
        for (int i = 0; i < n; i++) {
            lastIndex[numArray[i] - '0'] = i;
        }

        for (int j = 0; j < n; j++) {
            for (int d = 9; d > numArray[j] - '0'; d--) {
                if (lastIndex[d] > j) {
                    int swapIndex = lastIndex[d];
                    char temp = numArray[j];
                    numArray[j] = numArray[swapIndex];
                    numArray[swapIndex] = temp;
                    return Integer.parseInt(new String(numArray));
                }
            }
        }

        return num;
    }
}
