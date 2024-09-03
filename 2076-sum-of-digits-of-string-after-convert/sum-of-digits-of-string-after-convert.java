class Solution {
    public int getLucky(String s, int k) {
        StringBuilder num=new StringBuilder();
        for(char ch: s.toCharArray()){
            num.append(ch-'a'+1);
        }
        int sum=0;
        while(k-- > 0){
            sum=0;
            for(char ch: num.toString().toCharArray()){
                sum+=ch-'0';
            }
            num=new StringBuilder(Integer.toString(sum));
        }
        return Integer.parseInt(num.toString());   
    }
}