class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0 ;
        int count = 0 ;
    HashMap< Integer ,Integer> hm = new HashMap<>();

    for(int i = 0 ; i <nums.length ; i++){
        sum = sum + nums[i];

       if(sum == k ){
        count++;
       } 
       if(hm.get(sum - k )!= null ){
        count = count + hm.get(sum - k );
       }
       Integer prev = hm.get(sum);
       if(prev == null)
        hm.put(sum , 1);
        else
          hm.put(sum , prev + 1);
       
    }
return count;
    }
}