class ProductOfNumbers {
    List<Integer> arr;
    int n;
    public ProductOfNumbers() {
        arr=new ArrayList<>();
        n=0;
    }
    
    public void add(int num) {
        arr.add(num);
    }
    
    public int getProduct(int k) {
        int n=arr.size();
        int p=1;
        for(int i=n-k;i<n;i++){
         p *=arr.get(i);
        }
        return p;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */