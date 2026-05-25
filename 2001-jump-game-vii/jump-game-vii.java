class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.offer(0);
        vis[0] = true;
        int far = 0;
        while(!q.isEmpty()){
            int idx = q.poll();
            if(idx == n - 1){
                return true;
            }
            int start = Math.max(idx + minJump, far);
            int end = Math.min(idx + maxJump, n - 1);
            for(int j=start; j<=end; j++){
                if(s.charAt(j) == '0' && !vis[j]){
                    vis[j] = true;
                    q.offer(j);
                }
            }
            far = end + 1;
        }
        return false;
    }
}