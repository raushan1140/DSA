class Solution {
    public int minOperations(String s) {
        int startZ = 0;
        int startOne = 0;
        for(int i=0; i<s.length(); i++){
            char expZero = (i % 2 == 0) ? '0' : '1';
            char expOne = (i % 2 == 0) ? '1' : '0';
            if(s.charAt(i) != expZero){
                startZ++;
            }
            if(s.charAt(i) != expOne){
                startOne++;
            }
        }
        return Math.min(startZ, startOne);
    }
}