class Solution {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long mod = 1000000007;
        
        long[] pow = new long[n];
        pow[0] = 1;
        
        for(int i=1; i<n; i++){
            pow[i] = (pow[i-1]*2)%mod;
        }
        long res = 0;
        
        for(int i=0; i<n; i++){
            long max = pow[i];
            long min = pow[n-i-1]; 
            res = (res+nums[i]*(max-min))%mod;
        }   
        return(int)((res+mod)%mod);
    }
}