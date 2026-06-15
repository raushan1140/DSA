class Solution {
    public String mapWordWeights(String[] words, int[] weights) {

        StringBuilder ans = new StringBuilder();
        for(String word : words){
            long sum = 0;
            for(int i = 0; i < word.length(); i++){
                sum += weights[word.charAt(i) - 'a'];
            }
            int rem = (int)(sum % 26);
            char ch = (char)('z' - rem);
            ans.append(ch);
        }
        return ans.toString();
    }
}