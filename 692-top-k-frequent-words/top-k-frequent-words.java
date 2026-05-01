class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }   
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a.getValue().equals(b.getValue())){
                    return b.getKey().compareTo(a.getKey()); 
                }
                return a.getValue() - b.getValue(); 
            }
        );
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }
}