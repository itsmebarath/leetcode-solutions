class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int [] > res = new ArrayList<>();

        int curr = 0 ;

        while (curr < intervals.length &&  intervals[curr][1] <newInterval[0] ){
            res.add(intervals[curr++]);
        }

        while( curr <  intervals.length &&  intervals[curr][0] <= newInterval[1]){
            newInterval [0]= Math.min(newInterval[0] , intervals[curr][0]);
            newInterval [1]= Math.max(newInterval[1] , intervals[curr][1]);
            curr++;

        }
        res.add(newInterval);

        while(curr < intervals.length){
            res.add(intervals[curr++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}