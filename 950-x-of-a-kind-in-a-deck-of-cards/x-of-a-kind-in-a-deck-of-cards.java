class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : deck){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int gcd = 0;
        for(int freq : map.values()){
            gcd = findGCD(gcd, freq);
        }

        return gcd >= 2;
    }
    private int findGCD(int a, int b){
        if(b == 0) return a;
        return findGCD(b, a % b);
    }
}