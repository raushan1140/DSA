class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int res = 0;
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[res]==nums[i]){
                cnt++;
            }
            else{
                cnt--;
            }
            if(cnt == 0){
                res = i; 
                cnt = 1;
            }
        }
        cnt = 0;
        for(int i=0; i<n; i++){
            if(nums[res] == nums[i]){
                cnt++;
            }
        }
        if(cnt>n/2){
            return nums[res];
        }
        return -1;
    }
}