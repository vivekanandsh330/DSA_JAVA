class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(int num: arr1){
            String strNum =Integer.toString(num);
            String prefix="";
            for(char ch : strNum.toCharArray()){
                prefix += ch;
                hm.put(prefix,hm.getOrDefault(prefix,0)+1);
            }
        }
        int maxl=0;
        for(int num : arr2){
            String strNum =Integer.toString(num);
            String prefix ="";
            for(char ch:strNum.toCharArray()){
                prefix += ch;
                if(hm.containsKey(prefix)){
                maxl=Math.max(maxl,prefix.length());
                }
            }
        }
        return  maxl;
    }
}