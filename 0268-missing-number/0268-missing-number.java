class Solution {
    public int missingNumber(int[] nums) {
int n = nums.length;
       int sumUpton = n*(n+1)/2;
       int arrayn = 0;
        for(int i = 0 ; i <nums.length; i++){
            
            arrayn += nums[i];
            

            

        }
        return sumUpton - arrayn ;
       
    }

}