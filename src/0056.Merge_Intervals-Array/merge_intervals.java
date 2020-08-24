class Solution {
    void exchange(int[][] intervals, int i, int j){
        for (int t = 0; t < 2; t++){
            int tmp = intervals[i][t];
            intervals[i][t] = intervals[j][t];
            intervals[j][t] = tmp;
        }
    }

    int partition(int[][] intervals, int low, int high){
        int i = low;
        int j = high+1;
        int tmp = low;
        while(true){
            while(intervals[++i][0] < intervals[tmp][0]){
                if (i == high) break;
            }
            while(intervals[--j][0] > intervals[tmp][0]){
                if (j == low) break;
            }
            if (i >= j) break;
            exchange(intervals, i, j);
        }
        exchange(intervals, tmp, j);
        return j;
    }

    void quicksort(int[][] intervals, int low, int high){
        if (low >= high) return ;
        int j = partition(intervals, low, high);
        quicksort(intervals, low, j-1);
        quicksort(intervals, j+1, high);
    }

    public int[][] merge(int[][] intervals) {
        quicksort(intervals, 0, intervals.length-1);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] tmp : intervals){
            if (idx == -1 || tmp[0] > res[idx][1]){
                res[++idx] = tmp;
            }
            else{
                res[idx][1] = Math.max(res[idx][1], tmp[1]);
            }
        }
        return Arrays.copyOf(res, idx+1);
    }
}