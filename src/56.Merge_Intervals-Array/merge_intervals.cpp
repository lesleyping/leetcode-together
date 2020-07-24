#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    //归并算法
    void merge_merge(vector<vector<int>>& intervals, int lo, int mid, int hi, vector<vector<int>>& aux){
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++){
            aux[k] = intervals[k];
        } 
        for(int k = lo; k <= hi; k++){
            if(i > mid) intervals[k] = aux[j++];
            else if(j > hi) intervals[k] = aux[i++];
            else if(aux[i][0] < aux[j][0] || (aux[i][0] == aux[j][0] && (aux[i][1] < aux[j][1]))) intervals[k] = aux[i++];
            else {intervals[k] = aux[j++];}
        }
    }

    void merge_sort(vector<vector<int>>& intervals, int lo, int hi){
        vector<vector<int>> aux(intervals.size(), vector<int>(2,0));
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        merge_sort(intervals, lo, mid);
        merge_sort(intervals, mid+1, hi);
        merge_merge(intervals, lo, mid, hi, aux);
    }

    void exchange(vector<vector<int>>& intervals, int a, int b){
        vector<int> tmp = intervals[a];
        intervals[a] = intervals[b];
        intervals[b] = tmp;
    }

    bool less(vector<vector<int>>& intervals, int a, int b){
        if(intervals[a][0] < intervals[b][0] || \
            (intervals[a][0] == intervals[b][0] && intervals[a][1] < intervals[b][1])){
                return true;
        }
        return false;
    }

    int partition(vector<vector<int>>& intervals, int lo, int hi){
        int i = lo;
        int j = hi+1;
        int tmp = lo;
        while(true){
            while(less(intervals, ++i, tmp)){
                if(i == hi) break;
            }
            while(less(intervals, tmp, --j)){
                if(j == lo) break;
            }
            if(i >= j) break;
            exchange(intervals, i, j);
        } 
        exchange(intervals, lo, j);
        return j;
    }

    void quick_sort(vector<vector<int>>& intervals, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(intervals, lo, hi);
        quick_sort(intervals, lo, j-1);
        quick_sort(intervals, j+1, hi);
    }

    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if(intervals.size() <= 1) return intervals;
        /*
        //选择排序
        for(int i = 0; i < intervals.size()-1; i++){
            int m = i;
            for(int j = i+1; j < intervals.size(); j++){
                if(intervals[m][0] > intervals[j][0] || \
                   (intervals[m][0] == intervals[j][0] && intervals[m][1] > intervals[j][1])) m = j;
            }
            if(i != m){
                vector<int> tmp = intervals[m];
                intervals[m] = intervals[i];
                intervals[i] = tmp;
            }
        }
        */
        /*
        // 插入排序
        for(int i = 1; i < intervals.size(); i++){
            for(int j = i; j > 0; j--){
                if(intervals[j][0] < intervals[j-1][0] || \
                    (intervals[j][0] == intervals[j-1][0] && intervals[j][1] < intervals[j-1][1])){
                    vector<int> tmp = intervals[j];
                    intervals[j] = intervals[j-1];
                    intervals[j-1] = tmp;
                }
                else{
                    break;
                }
            }
        }
        */
        /*
        // 插入排序优化版
        for(int i = 1; i < intervals.size(); i++){
            vector<int> tmp = intervals[i];
            int j;
            for(j = i-1; j >= 0; j--){
                if(tmp[0] < intervals[j][0] || \
                    (tmp[0] == intervals[j][0] && tmp[1] < intervals[j][1])){
                    intervals[j+1] = intervals[j];
                }
                else
                {
                    break;
                }
                
            }
            intervals[j+1] = tmp;
        }
        */
        // 归并排序
        //merge_sort(intervals, 0, intervals.size()-1);
        quick_sort(intervals, 0, intervals.size()-1);
        vector<vector<int>> res;
        res.push_back(intervals[0]);
        for(int i = 1; i < intervals.size(); i++){
            if(res.back()[1] < intervals[i][0]){
                res.push_back(intervals[i]);
            }
            else{
                res.back()[1] = max(res.back()[1], intervals[i][1]);
            }
        }
        return res;
    }
};

int main(int argc, char const *argv[])
{
    Solution s;
    vector<vector<int>> intervals = {{1,3},{2,6},{8,10},{15,18},{5,9},{2,5},{9,10}};
    vector<vector<int>> res = s.merge(intervals);
    for (int i = 0; i < res.size(); i++){
        for(int j = 0; j < res[i].size(); j++){
            cout<<res[i][j] << endl;
        }
    }
    return 0;
}