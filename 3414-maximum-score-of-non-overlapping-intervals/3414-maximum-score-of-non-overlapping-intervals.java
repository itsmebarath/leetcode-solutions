import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

      
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

       
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[3], b[3]);
        });

        Result[][] dp = new Result[5][n + 1];

        for (int k = 0; k <= 4; k++) {
            for (int i = 0; i <= n; i++) {
                dp[k][i] = new Result(0, new ArrayList<>());
            }
        }

        for (int k = 1; k <= 4; k++) {

            for (int i = 1; i <= n; i++) {

           
                Result best = dp[k][i - 1];

              
                int current = i - 1;

                int prev = findPrevious(arr, current);

                Result previous = dp[k - 1][prev + 1];

                long newScore = previous.score + arr[current][2];

                List<Integer> newIndices = new ArrayList<>(previous.indices);
                newIndices.add(arr[current][3]);

                Collections.sort(newIndices);

                Result take = new Result(newScore, newIndices);

                if (isBetter(take, best)) {
                    best = take;
                }

                dp[k][i] = best;
            }
        }

        return dp[4][n].indices.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

  
    private int findPrevious(int[][] arr, int current) {

        int left = arr[current][0];

        int lo = 0;
        int hi = current - 1;
        int answer = -1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

          
            if (arr[mid][1] < left) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return answer;
    }


    private boolean isBetter(Result a, Result b) {

        if (a.score != b.score) {
            return a.score > b.score;
        }

      
        int size = Math.min(a.indices.size(), b.indices.size());

        for (int i = 0; i < size; i++) {

            if (!a.indices.get(i).equals(b.indices.get(i))) {
                return a.indices.get(i) < b.indices.get(i);
            }
        }

        return a.indices.size() < b.indices.size();
    }

    static class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }
}