# Problem
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

# Analyze
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        if(intervals.empty())return res;
        sort(intervals.begin(), intervals.end());
        res.push_back(intervals[0]);
        for(int i = 1; i < intervals.size(); i++){
            if(intervals[i][0] <= res.back()[1]){
                res.back()[1] = max(intervals[i][1],res.back()[1]);
            }
            else{
                res.push_back(intervals[i]);
            }
        }
        return res;
    }
};

复习排序算法？？
快排
void quicksort(struct Interval *intervals, int start, int end)
{
    int i, j;
    struct Interval temp;
    if (start > end)
    {
        return;
    }
    temp = intervals[start];
    i = start;
    j = end;
    while (i != j)
    {
        while (i < j && intervals[j].start >= temp.start)
        {
            j--;
        }
        while (i < j && intervals[i].start <= temp.start)
        {
            i++;
        }
        if (i < j)
        {
            struct Interval tmp = intervals[i];
            intervals[i] = intervals[j];
            intervals[j] = tmp;
        }
    }
    intervals[start] = intervals[i];
    intervals[i] = temp;
    quicksort(intervals, start, i - 1);
    quicksort(intervals, i + 1, end);
}

选择
找到数组中最小的元素，将它和数组的第一个元素交换位置。
然后在剩下元素中找最小元素，将它和数组的第二个元素交换位置。
void selectsort(struct Interval *intervals, int intervalsSize)
{
    int k;
    for (int i = 0; i < intervalsSize-1; i++)
    {
        k=i;
        for (int j = k + 1; j < intervalsSize; j++)
        {
            if (intervals[j].start < intervals[k].start)
            {
                k = j;
                
            }
        }
        if (i!=k)
        {
            struct Interval tmp = intervals[i];
            intervals[i] = intervals[k];
            intervals[k] = tmp;
        }
    }
}

插入
void insertsort(struct Interval *intervals, int intervalsSize)
{
    for (int i = 1; i < intervalsSize; i++)
    {
        for(int j=0; j<i; j++)
        {
            if (intervals[j].start > intervals[i].start)
            {
                struct Interval tmp = intervals[j];
                intervals[j] = intervals[i];
                intervals[i] = tmp;
            }
        }
    }
}

