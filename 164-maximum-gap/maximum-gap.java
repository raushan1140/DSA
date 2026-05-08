class Solution {
    public int maximumGap(int[] nums) {
         int n = nums.length;
        if(n < 2){
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if(min == max){
            return 0;
        }
        int buS = (int)Math.ceil((double)(max - min) / (n - 1));
        int buC = ((max - min) / buS) + 1;
        int buMin[] = new int[buC];
        int buMax[] = new int[buC];
        for(int i=0; i<buC; i++){
            buMin[i] = Integer.MAX_VALUE;
            buMax[i] = Integer.MIN_VALUE;
        }
        for(int num : nums){
            int idx = (num - min) / buS;
            buMin[idx] = Math.min(buMin[idx], num);
            buMax[idx] = Math.max(buMax[idx], num);
        }
        int maxGap = 0;
        int prev = min;

        for(int i=0; i<buC; i++){
            if(buMin[i] == Integer.MAX_VALUE){
                continue;
            }
            maxGap = Math.max(maxGap, buMin[i] - prev);
            prev = buMax[i];
        }
        return maxGap;
    }
}