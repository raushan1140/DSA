class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String res[] = new String[n];

        int sorted[] = score.clone();
        Arrays.sort(sorted);

        Map<Integer, String>map = new HashMap<>();
        for(int i=0; i<n; i++){
            int rank = n-i;
            int val = sorted[i];

            if(rank == 1) map.put(val, "Gold Medal");
            else if(rank == 2) map.put(val, "Silver Medal");
            else if(rank == 3) map.put(val, "Bronze Medal");
            else map.put(val, String.valueOf(rank));
        }
        for(int i=0; i<n;i++){
            res[i] = map.get(score[i]);
        }
        return res;
    }
}