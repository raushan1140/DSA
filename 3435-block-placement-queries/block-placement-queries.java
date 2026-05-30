class Solution {

    class SegmentTree {

        int tree[];
        int n;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int node, int start, int end, int idx, int val) {

            if(start == end){
                tree[node] = val;
                return;
            }

            int mid = (start + end) / 2;

            if(idx <= mid){
                update(node * 2, start, mid, idx, val);
            }
            else{
                update(node * 2 + 1, mid + 1, end, idx, val);
            }

            tree[node] = Math.max(tree[node * 2],
                                  tree[node * 2 + 1]);
        }

        int query(int node, int start, int end,
                  int left, int right) {

            if(right < start || end < left){
                return 0;
            }

            if(left <= start && end <= right){
                return tree[node];
            }

            int mid = (start + end) / 2;

            return Math.max(
                query(node * 2, start, mid, left, right),
                query(node * 2 + 1, mid + 1, end, left, right)
            );
        }
    }

    public List<Boolean> getResults(int[][] queries) {

        int MAX = 50000;

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);

        SegmentTree seg = new SegmentTree(MAX + 1);

        List<Boolean> ans = new ArrayList<>();

        for(int q[] : queries){

            if(q[0] == 1){

                int x = q[1];

                Integer prev = obstacles.lower(x);
                Integer next = obstacles.higher(x);

                obstacles.add(x);

                seg.update(1, 0, MAX, x, x - prev);

                if(next != null){

                    seg.update(1, 0, MAX, next,
                               next - x);
                }
            }
            else{

                int x = q[1];
                int sz = q[2];

                Integer prev = obstacles.floor(x);

                int maxGap =
                    seg.query(1, 0, MAX, 0, x);

                maxGap = Math.max(maxGap,
                                  x - prev);

                ans.add(maxGap >= sz);
            }
        }

        return ans;
    }
}