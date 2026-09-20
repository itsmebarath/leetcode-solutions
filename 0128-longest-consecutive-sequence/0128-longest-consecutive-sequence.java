import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        
        for (int n : nums) {
            set.add(n);
        }

        int max = 0;

       
        for (int num : set) {

           
            if (set.contains(num - 1)) {
                continue;
            }

            int currLength = 0;

            
            while (set.contains(num)) {
                currLength++;
                num++;
            }

            max = Math.max(max, currLength);
        }

        return max;
    }
}