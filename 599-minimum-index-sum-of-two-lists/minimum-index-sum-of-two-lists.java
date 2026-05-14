class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<list1.length; i++){
            map.put(list1[i], i);
        }
        ArrayList<String> ans = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for(int i=0; i<list2.length; i++){
            String s = list2[i];
            if(map.containsKey(s)){
                int sum = i + map.get(s);
                if(sum < minSum){
                    minSum = sum;
                    ans.clear();
                    ans.add(s);
                }
                else if(sum == minSum){
                    ans.add(s);
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}