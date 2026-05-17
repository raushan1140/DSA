class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
         int target[] = new int[26];
        for(char ch : licensePlate.toCharArray()){
            if(Character.isLetter(ch)){
                ch = Character.toLowerCase(ch);
                target[ch - 'a']++;
            }
        }
        String ans = "";
        for(String word : words){
            int freq[] = new int[26];
            for(char ch : word.toCharArray()){
                freq[ch - 'a']++;
            }
            boolean ok = true;
            for(int i=0; i<26; i++){
                if(freq[i] < target[i]){
                    ok = false;
                    break;
                }
            }
            if(ok){
                if(ans.equals("") || word.length() < ans.length()){
                    ans = word;
                }
            }
        }
        return ans;
    }
}