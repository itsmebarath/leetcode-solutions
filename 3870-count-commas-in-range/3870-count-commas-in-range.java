class Solution {
    public int countCommas(int n) {
        int count = 0;
        int threshold = 1000;

        while (threshold <= n) {
            count += n - threshold + 1;

            if (threshold > n / 1000) {
                break;
            }

            threshold *= 1000;
        }

        return count;
    }
}