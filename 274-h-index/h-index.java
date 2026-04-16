class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int cnt[] = new int[n+1];
        
        for(int c:citations){
            if(c>=n)cnt[n]++;
            else cnt[c]++;
        }
        int total = 0;
        for(int i=n;i>=0;i--){
            total += cnt[i];        
            if(total>=i){
                return i;
            }
        }      
        return 0;
    }
}