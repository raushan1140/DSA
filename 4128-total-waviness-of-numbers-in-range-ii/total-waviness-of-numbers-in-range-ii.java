class Solution {

    class Pair {

        long cnt;
        long sum;

        Pair(long cnt, long sum) {

            this.cnt = cnt;
            this.sum = sum;
        }
    }

    String s;

    Pair memo[][][][][][];
    boolean vis[][][][][][];

    public long totalWaviness(long num1, long num2) {

        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {

        if(n < 0){

            return 0;
        }

        s = String.valueOf(n);

        int len = s.length();

        memo = new Pair[len][2][2][11][11][20];
        vis = new boolean[len][2][2][11][11][20];

        return dfs(0, 1, 0, 10, 10, 0).sum;
    }

    private Pair dfs(int pos,
                     int tight,
                     int started,
                     int last1,
                     int last2,
                     int length) {

        if(pos == s.length()){

            return new Pair(1, 0);
        }

        if(vis[pos][tight][started][last1][last2][length]){

            return memo[pos][tight][started][last1][last2][length];
        }

        int limit;

        if(tight == 1){

            limit = s.charAt(pos) - '0';
        }
        else{

            limit = 9;
        }

        long totalCnt = 0;
        long totalSum = 0;

        for(int d = 0; d <= limit; d++){

            int ntight;

            if(tight == 1 && d == limit){

                ntight = 1;
            }
            else{

                ntight = 0;
            }

            if(started == 0 && d == 0){

                Pair next = dfs(
                    pos + 1,
                    ntight,
                    0,
                    10,
                    10,
                    0
                );

                totalCnt += next.cnt;
                totalSum += next.sum;
            }
            else{

                int add = 0;

                if(length >= 2){

                    if((last1 > last2 && last1 > d) ||
                       (last1 < last2 && last1 < d)){

                        add = 1;
                    }
                }

                Pair next = dfs(
                    pos + 1,
                    ntight,
                    1,
                    d,
                    last1,
                    length + 1
                );

                totalCnt += next.cnt;
                totalSum += next.sum + (long)add * next.cnt;
            }
        }

        vis[pos][tight][started][last1][last2][length] = true;

        return memo[pos][tight][started][last1][last2][length]
            = new Pair(totalCnt, totalSum);
    }
}