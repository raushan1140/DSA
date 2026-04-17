class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currTank = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++){
            int diff = gas[i] - cost[i];
            totalGas += diff;
            currTank += diff;
            
            if(currTank < 0){
                start = i + 1;
                currTank = 0;
            }
        }
        return totalGas >= 0 ? start : -1;
    }
}