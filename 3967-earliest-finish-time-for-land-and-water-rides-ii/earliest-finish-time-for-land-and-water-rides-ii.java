class Solution {
    class RideHelper {
        
        int start[];
        int prefixMinDur[];
        int suffixMinFinish[];
        int n;

        RideHelper(int startTime[], int duration[]) {
            n = startTime.length;
            int rides[][] = new int[n][2];
            for(int i = 0; i < n; i++){
                rides[i][0] = startTime[i];
                rides[i][1] = duration[i];
            }
            Arrays.sort(rides, (a, b) -> a[0] - b[0]);

            start = new int[n];
            prefixMinDur = new int[n];
            suffixMinFinish = new int[n];

            for(int i = 0; i < n; i++){
                start[i] = rides[i][0];
            }
            prefixMinDur[0] = rides[0][1];
            for(int i = 1; i < n; i++){

                prefixMinDur[i] =
                    Math.min(prefixMinDur[i - 1], rides[i][1]);
            }

            suffixMinFinish[n - 1] =
                rides[n - 1][0] + rides[n - 1][1];

            for(int i = n - 2; i >= 0; i--){

                suffixMinFinish[i] = Math.min(
                    suffixMinFinish[i + 1],
                    rides[i][0] + rides[i][1]
                );
            }
        }

        int getEarliestFinish(int time){

            int idx = upperBound(start, time) - 1;

            int ans = Integer.MAX_VALUE;

            if(idx >= 0){

                ans = Math.min(ans,
                               time + prefixMinDur[idx]);
            }

            if(idx + 1 < n){

                ans = Math.min(ans,
                               suffixMinFinish[idx + 1]);
            }

            return ans;
        }

        int upperBound(int arr[], int target){

            int low = 0;
            int high = arr.length;

            while(low < high){

                int mid = low + (high - low) / 2;

                if(arr[mid] <= target){

                    low = mid + 1;
                }
                else{

                    high = mid;
                }
            }

            return low;
        }
    }

    public int earliestFinishTime(int[] landStartTime,int[] landDuration,int[] waterStartTime,int[] waterDuration) {

        RideHelper water =new RideHelper(waterStartTime, waterDuration);

        RideHelper land =new RideHelper(landStartTime, landDuration);

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < landStartTime.length; i++){
            int landFinish = landStartTime[i] + landDuration[i];

            ans = Math.min(ans,water.getEarliestFinish(landFinish));
        }
        for(int i = 0; i < waterStartTime.length; i++){

            int waterFinish = waterStartTime[i] + waterDuration[i];

            ans = Math.min(ans, land.getEarliestFinish(waterFinish));
        }
        return ans;
    }
}