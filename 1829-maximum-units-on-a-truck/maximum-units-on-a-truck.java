class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for(int box[] : boxTypes){
            int boxes = box[0];
            int units = box[1];
            int take = Math.min(boxes, truckSize);
            ans += take * units;
            truckSize -= take;
            if(truckSize == 0){
                break;
            }
        }
        return ans;
    }
}