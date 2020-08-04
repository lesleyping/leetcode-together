#include<iostream>
#include<vector>

using namespace std;

vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval){
    vector<vector<int>> res;
    if(intervals.size() == 0) return {newInterval};
    int i = 0;
    while(i < intervals.size() && newInterval[0] > intervals[i][1]){
        res.push_back(intervals[i]);
        i++;
    }
    while(i < intervals.size() && newInterval[1] >= intervals[i][0]){
        newInterval[0] = min(newInterval[0], intervals[i][0]);
        newInterval[1] = max(newInterval[1], intervals[i][1]);
        i++;
    }
    res.push_back(newInterval);
    while(i < intervals.size()){
        res.push_back(intervals[i]);
        i++;
    }
    return res;
}

int main()
{
    vector<vector<int>> intervals = {{1,3},{6,9}};
    vector<int> newInterval = {2,5};
    vector<vector<int>> res = insert(intervals, newInterval);
    for (int i = 0; i < res.size(); i++){
        for(int j = 0; j < res[i].size(); j++){
            cout<<res[i][j] << endl;
        }
    }
    return 0;
}