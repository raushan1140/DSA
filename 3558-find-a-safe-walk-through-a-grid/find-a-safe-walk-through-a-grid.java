class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int dist[][] = new int[m][n];

        for(int i = 0; i < m; i++){

            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[0][0] = grid.get(0).get(0);

        pq.offer(new int[]{dist[0][0], 0, 0});

        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){

            int cur[] = pq.poll();

            int cost = cur[0];
            int x = cur[1];
            int y = cur[2];

            if(cost > dist[x][y]){

                continue;
            }

            for(int d[] : dir){

                int nx = x + d[0];
                int ny = y + d[1];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n){

                    continue;
                }

                int newCost = cost + grid.get(nx).get(ny);

                if(newCost < dist[nx][ny]){

                    dist[nx][ny] = newCost;

                    pq.offer(new int[]{newCost, nx, ny});
                }
            }
        }

        return dist[m - 1][n - 1] < health;
    }
}