class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        while(q.size() >1){
            for(int c=1;c<=k-1;c++){
                q.add(q.poll());
            }
            q.poll();
        }
        return q.peek();
    }
}