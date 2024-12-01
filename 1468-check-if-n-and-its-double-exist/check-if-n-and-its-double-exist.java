class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hm=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(hm.contains(2*arr[i]) || ((arr[i] % 2 == 0) && hm.contains(arr[i]/2))){
                return true;
            }
            hm.add(arr[i]);
        }
        return false;
    }
}