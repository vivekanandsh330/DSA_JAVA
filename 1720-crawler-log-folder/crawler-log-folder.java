class Solution {
    public int minOperations(String[] logs) {
       int count=0;
       for(String ch: logs){
        if(ch.equals("../")){
            if(count>0){
                  count--;
            }
        } 
        else if(!ch.equals("./")){
                count++;
            }
       }
       return count;   
    }
}