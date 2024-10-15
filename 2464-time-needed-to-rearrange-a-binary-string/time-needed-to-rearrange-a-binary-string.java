class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int count=0;
        StringBuilder curr=new StringBuilder(s);
       
        while(true){
            boolean flag=false;
            for(int i=0;i<s.length()-1;i++){
                if(s.charAt(i) == '0' && s.charAt(i+1) == '1'){
                    flag=true;
                    curr.setCharAt(i,'1');
                    curr.setCharAt(i+1,'0');
                }
            }
            s=curr.toString();
            if(flag){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}