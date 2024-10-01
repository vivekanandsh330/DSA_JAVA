class Solution {
    public boolean canArrange(int[] arr, int k) {
      int mp[]=new int[k];
      for(int num:arr){
        int rem=(num%k+k)%k;
        mp[rem]++;
      }
      if(mp[0] % 2 !=0){
        return false;
      }
      for(int i=1;i<=k/2;i++){
        int rh=k-i;
        if(mp[rh] != mp[i]){
            return false;
        }
      }
      return true;
    }
}