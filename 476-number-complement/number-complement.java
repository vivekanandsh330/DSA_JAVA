class Solution {
    public int findComplement(int num) {
        int k=(1<<(int)(Math.floor(Math.log(num)/Math.log(2))+1))-1;
        return num^k;
    }
}