class Solution {
    public int maxSubarraySumCircular(int[] arr) {

        int total = 0;

        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        int minEndingHere = arr[0];
        int minSoFar = arr[0];

        total = arr[0];

        for (int i = 1; i < arr.length; i++) {

           
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);

            
            minEndingHere = Math.min(arr[i], minEndingHere + arr[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);

            total += arr[i];
        }

        
        if (maxSoFar < 0) {
            return maxSoFar;
        }

     
        int circularMax = total - minSoFar;

        return Math.max(maxSoFar, circularMax);
    }
}