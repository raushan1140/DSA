class Solution {
        class TrieNode{
        TrieNode child[] = new TrieNode[26];
        int idx = -1;
    }
    TrieNode root = new TrieNode();
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        
        for(int i=0; i<wordsContainer.length; i++){
            insert(wordsContainer[i], i, wordsContainer);
        }
        int ans[] = new int[wordsQuery.length];
        for(int i=0; i<wordsQuery.length; i++){
            ans[i] = search(wordsQuery[i]);
        }
        return ans;
    }
    private void insert(String word,int index,String wordsContainer[]){
        TrieNode node = root; update(node, index, wordsContainer);
        for(int i=word.length()-1; i>=0; i--){
            int c = word.charAt(i) - 'a';
            if(node.child[c] == null){
                node.child[c] = new TrieNode();
            }
            node = node.child[c];
            update(node, index, wordsContainer);
        }
    }
    private void update(TrieNode node,int index,String wordsContainer[]){
        if(node.idx == -1){
            node.idx = index;
        }
        else{
            int oldLen = wordsContainer[node.idx].length();
            int newLen = wordsContainer[index].length();
            if(newLen < oldLen ||
              (newLen == oldLen && index < node.idx)){
                node.idx = index;
            }
        }
    }
    private int search(String word){
        TrieNode node = root;
        int ans = root.idx;
        for(int i=word.length()-1; i>=0; i--){
            int c = word.charAt(i) - 'a';
            if(node.child[c] == null){
                break;
            }
            node = node.child[c];
            ans = node.idx;
        }
        return ans;
    }
}