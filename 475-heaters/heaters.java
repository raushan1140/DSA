class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int maxRadius = 0;
        
        for(int house : houses){
            int idx = Arrays.binarySearch(heaters, house);
            if(idx >= 0){
                continue; 
            }
            idx = -(idx + 1); 
            int leftDist = Integer.MAX_VALUE;
            int rightDist = Integer.MAX_VALUE;
            if(idx - 1 >= 0){
                leftDist = house - heaters[idx - 1];
            }
            if(idx < heaters.length){
                rightDist = heaters[idx] - house;
            }
            int minDist = Math.min(leftDist, rightDist);
            maxRadius = Math.max(maxRadius, minDist);
        }
        return maxRadius;
    }
}