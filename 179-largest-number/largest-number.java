class Solution {
    public String largestNumber(int[] nums) {
        String str[]=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i]=Integer.toString(nums[i]);
        }
        // Arrays.sort(str,new Comparator<String>(){
        // public int compare(String a,String b){
        //         String f=a+b;
        //         String s=b+a;
        //         return s.compareTo(f);
        //     }
        // });
        Arrays.sort(str,(a,b)->(b+a).compareTo(a+b));
        if(str[0].equals("0")){
            return "0";
        }
        StringBuilder ans=new StringBuilder();
        for(String s:str){
            ans.append(s);
        }
        return ans.toString();
        
    }
}