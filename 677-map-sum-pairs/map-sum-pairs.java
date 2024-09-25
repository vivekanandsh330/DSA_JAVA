class MapSum {
    HashMap<String,Integer> hm=null;
    public MapSum() {
        hm=new HashMap<>();
    }
    public void insert(String key, int val) {
        hm.put(key,val);
    }
    int ans=0;
    public int sum(String prefix) {
        int ans=0;
        for(String pre:hm.keySet()){
            if(pre.startsWith(prefix)){
                ans += hm.get(pre);
            }
        }
        return ans;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */