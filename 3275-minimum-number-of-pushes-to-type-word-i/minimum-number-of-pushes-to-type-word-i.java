class Solution {
    public int minimumPushes(String word) {
        Map<Integer,Integer> hm=new HashMap<>();
        int count=0;
        int ass=2;
        for(char ch:word.toCharArray()){
            if(ass > 9){
                ass=2;
            }
            hm.put(ass,hm.getOrDefault(ass,0)+1);
            count += hm.get(ass);
            ass++;
        }
        return count;
    }
}