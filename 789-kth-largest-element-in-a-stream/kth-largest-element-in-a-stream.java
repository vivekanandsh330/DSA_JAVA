class KthLargest {
    PriorityQueue<Integer> hp=new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(var v:nums){
            add(v);
        }
    }
    public int add(int val) {
        hp.add(val);
        if(hp.size()>k){
            hp.poll();
        }
        return hp.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */