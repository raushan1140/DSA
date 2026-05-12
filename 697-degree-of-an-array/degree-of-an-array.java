class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();

        int degree = 0;
        int minLen = nums.length;
        
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(!first.containsKey(num)){
                first.put(num, i);
            }
            count.put(num, count.getOrDefault(num, 0) + 1);
            int freq = count.get(num);
            if(freq > degree){
                degree = freq;
                minLen = i - first.get(num) + 1;
            }
            else if(freq == degree){
                minLen = Math.min(minLen,
                i - first.get(num) + 1);
            }
        }
        return minLen;
    }
}