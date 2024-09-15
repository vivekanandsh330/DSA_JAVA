class Solution {
    public int findTheLongestSubstring(String s) {
        Map<String,Integer> hm=new HashMap<>();
        int vol[]=new int[5];
        String currstate="00000";
        hm.put(currstate,-1);
        int maxlen=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'a'){
                vol[0]=(vol[0]+1)%2;
            }
            else if(s.charAt(i) == 'e'){
                vol[1]=(vol[1]+1)%2;
            }
            else if(s.charAt(i) == 'i'){
                vol[2]=(vol[2]+1)%2;
            }
            else if(s.charAt(i) == 'o'){
                vol[3]=(vol[3]+1)%2;
            }
            else if(s.charAt(i) == 'u'){
                vol[4]=(vol[4]+1)%2;
            }
            currstate="";
            for(int j=0;j<5;j++){
                currstate +=vol[j];
            }
            if(hm.containsKey(currstate)){
                maxlen=Math.max(maxlen,i-hm.get(currstate));
            }
            else{
                hm.put(currstate,i);
            }
        }
        return maxlen;
    }
}