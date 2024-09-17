class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String str1[]=s1.split(" ");
        String str2[]=s2.split(" ");
        
        Map<String,Integer> hm=new HashMap<>();
        
        for(String w1:str1){
            hm.put(w1,hm.getOrDefault(w1,0)+1);
        }
        for(String w2:str2){
            hm.put(w2,hm.getOrDefault(w2,0)+1);
        }

       List<String> ans=new ArrayList<>();
        for(String n: hm.keySet()){
            if(hm.get(n) == 1){
                ans.add(n);
            }
        }
        return ans.toArray(new String[0]);
        
    }
}