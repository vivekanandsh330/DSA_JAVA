class Solution {
    public int maxCount(int[] nums, int n, int maxSum) {
      Set<Integer> sh=new HashSet();
      for(int num:nums){
        sh.add(num);
      }
      int sum=0;
      int count=0;
      for(int i=1;i<=n;i++){
        if(sh.contains(i)){
            continue;
        }
        sum+=i;
        if(sum>maxSum){
            break;
        }
        count++;
      }
      return count;
    }
}