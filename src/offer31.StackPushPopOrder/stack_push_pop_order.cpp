class Solution {
public:
    bool IsPopOrder(vector<int> pushV,vector<int> popV) {
        if(pushV.size() == 0) return false;
        stack<int> sta;
        int i = 0;
        for (auto num : pushV){
            sta.push(num);
            while (!sta.empty() && sta.top() == popV[i]){
                sta.pop();
                i++;
            }
        }
        return sta.empty();
    }
};