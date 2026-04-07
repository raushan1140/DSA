class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer>set = new HashSet<>();
        
        for(int n: nums){
            set.add(n);
        }
        List<Integer>list = new ArrayList<>(set);
        Collections.sort(list);

        int n = list.size();
        if(n == 0) return 0;
        if(n<3) return list.get(n-1);

        return list.get(n-3);
    }
}