class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int dp[] = new int[n];
        int ans = 1;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dfs(i, arr, d, dp));
        }
        return ans;
    }

    private int dfs(int idx, int arr[], int d, int dp[]){
        if(dp[idx] != 0){
            return dp[idx];
        }
        int best = 1;
        for(int i=idx+1; i<=Math.min(arr.length-1, idx+d); i++){
            if(arr[i] >= arr[idx]){
                break;
            }
            best = Math.max(best,1 + dfs(i, arr, d, dp));
        }
        for(int i=idx-1; i>=Math.max(0, idx-d); i--){
            if(arr[i] >= arr[idx]){
                break;
            }
            best = Math.max(best,1 + dfs(i, arr, d, dp));
        }
        return dp[idx] = best;
    }
}