class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        vis[start] = true;

        while(!q.isEmpty()){
            int idx = q.poll();
            if(arr[idx] == 0){
                return true;
            }

            int fwd = idx + arr[idx];
            int bwd = idx - arr[idx];

            if(fwd < n && !vis[fwd]){
                vis[fwd] = true;
                q.offer(fwd);
            }
            if(bwd >= 0 && !vis[bwd]){
                vis[bwd] = true;
                q.offer(bwd);
            }
        }
        return false;
    }
}