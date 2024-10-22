class Solution {
    boolean canEatAll(int [] piles,int k,int h){
        int currh=0;
        for(int pile:piles){
            currh +=Math.ceil((double)pile/k);
        }
        return currh<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int i=1;
        int j=Arrays.stream(piles).max().getAsInt();
        while(i<j){
            int mid=i+(j-i)/2;
            if(canEatAll(piles,mid,h)){
                j=mid;
            }else{
                i = mid+1;
            }
        }
        return i;
    }
}