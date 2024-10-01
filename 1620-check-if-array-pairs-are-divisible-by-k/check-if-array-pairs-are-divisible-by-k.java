class Solution {
    public boolean canArrange(int[] arr, int k) {
    //   int mp[]=new int[k];
    Map<Integer,Integer> hm=new HashMap<>();
      for(int num:arr){
        int rem=(num%k+k)%k;
        hm.put(rem,hm.getOrDefault(rem,0)+1);
      }
      if(hm.getOrDefault(0,0) % 2 !=0){
        return false;
      }
      for(int i=1;i<=k/2;i++){
        int rh=k-i;
        if(!hm.getOrDefault(rh,0).equals(hm.getOrDefault(i,0))){
            return false;
        }
      }
      return true;
    }
}