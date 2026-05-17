class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int rank[] = new int[26];
        for(int i=0; i<order.length(); i++){
            rank[order.charAt(i) - 'a'] = i;
        }
        for(int i=0; i<words.length-1; i++){
            String a = words[i];
            String b = words[i+1];
            int len = Math.min(a.length(), b.length());
            boolean diffFound = false;
            for(int j=0; j<len; j++){
                char c1 = a.charAt(j);
                char c2 = b.charAt(j);
                if(c1 != c2){
                    if(rank[c1 - 'a'] > rank[c2 - 'a']){
                        return false;
                    }
                    diffFound = true;
                    break;
                }
            }
            if(!diffFound && a.length() > b.length()){
                return false;
            }
        }
        return true;
    }
}