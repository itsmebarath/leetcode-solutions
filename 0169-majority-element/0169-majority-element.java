class Solution {
    public int majorityElement(int[] nums) {
        int count = 0 ;
       int  candiate = 0 ;
         
         for (int i = 0 ; i <nums.length ; i++){
            if(count == 0){
                candiate = nums[i]; 
            }
            if(nums[i] == candiate){
                count++;
            }
            else{
                count--;
            }
         }
         return candiate;
    }
}