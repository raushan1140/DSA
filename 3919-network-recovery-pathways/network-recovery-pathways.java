class Solution {

    class Edge {

        int to;
        int cost;

        Edge(int to, int cost){

            this.to = to;
            this.cost = cost;
        }
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        List<Edge>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){

            graph[i] = new ArrayList<>();
        }

        int indegree[] = new int[n];

        int high = 0;

        for(int edge[] : edges){

            graph[edge[0]].add(new Edge(edge[1], edge[2]));

            indegree[edge[1]]++;

            high = Math.max(high, edge[2]);
        }

        List<Integer> topo = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){

            if(indegree[i] == 0){

                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){

            int node = queue.poll();

            topo.add(node);

            for(Edge e : graph[node]){

                indegree[e.to]--;

                if(indegree[e.to] == 0){

                    queue.offer(e.to);
                }
            }
        }

        int low = 0;

        int ans = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(check(mid, graph, topo, online, k)){

                ans = mid;

                low = mid + 1;
            }
            else{

                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int limit,
                          List<Edge>[] graph,
                          List<Integer> topo,
                          boolean[] online,
                          long k){

        int n = graph.length;

        long dist[] = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;

        for(int node : topo){

            if(dist[node] == Long.MAX_VALUE){

                continue;
            }

            if(node != 0 && node != n - 1 && !online[node]){

                continue;
            }

            for(Edge e : graph[node]){

                if(e.cost < limit){

                    continue;
                }

                if(e.to != n - 1 && !online[e.to]){

                    continue;
                }

                dist[e.to] = Math.min(dist[e.to],
                                      dist[node] + e.cost);
            }
        }

        return dist[n - 1] <= k;
    }
}