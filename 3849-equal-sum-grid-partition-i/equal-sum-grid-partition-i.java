class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                total += grid[i][j];
            }
        }
        long prefix = 0;
        for(int i = 0; i < m - 1; i++){
            long rowSum = 0;
            for(int j = 0; j < n; j++){
                rowSum += grid[i][j];
            }
            prefix += rowSum;
            if(prefix == total - prefix){
                return true;
            }
        }
        prefix = 0;
        for(int j = 0; j < n - 1; j++){
            long colSum = 0;
            for(int i = 0; i < m; i++){
                colSum += grid[i][j];
            }
            prefix += colSum;
            if(prefix == total - prefix){
                return true;
            }
        }
        return false;
    }
}