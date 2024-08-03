class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer,Integer> a=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            a.put(arr[i],a.getOrDefault(arr[i],0)+1);
        }
        Map<Integer,Integer> b=new HashMap<>();
        for(int i=0;i<target.length;i++){
            b.put(target[i],b.getOrDefault(target[i],0)+1);
        }
        return a.equals(b);
        
    }
}