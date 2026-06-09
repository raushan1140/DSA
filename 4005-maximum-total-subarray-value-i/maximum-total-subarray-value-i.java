class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long minVal = Integer.MAX_VALUE;
        long maxVal = Integer.MIN_VALUE;

        for(int num : nums){
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }
        long best = maxVal - minVal;
        return best * k;
    }
}