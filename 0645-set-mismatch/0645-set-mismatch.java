class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int dupilicate = -1 ;
        int missing = -1 ;

        for(int num : nums ){
            if(set.contains(num)){
               dupilicate= num;
            }
            else{
                set.add(num);
            }
            
        }

        for(int i =1 ; i <= nums .length; i++){
            if(!set.contains(i)){
            missing =i;
            break;
            }
        }

        return new int []{dupilicate ,missing};
    }
}