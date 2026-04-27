class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        int sumB = 0;
        for(int a : aliceSizes) sumA += a;
        for(int b : bobSizes) sumB += b;
        
        int diff = (sumA - sumB)/2;
        
        Set<Integer>set = new HashSet<>();
        for(int a : aliceSizes) set.add(a);
        for(int b : bobSizes){
            int x = b + diff;
            if(set.contains(x)){
                return new int[]{x, b};
            }
        }  
        return new int[0];
    }
}