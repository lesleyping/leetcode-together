
插入法

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        for(int i = 0; i < k; i++){
            nums.insert(nums.begin(), nums[n-1]);
            nums.pop_back();
        }
    }
    
};

循环交换：

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        int counts = 0;
        for(int start = 0; counts < nums.size(); start++){
            int current = start;
            int pre = nums[start];
            do{
                int next = (current + k) % nums.size();
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                current = next;
                counts++;
            }while(current != start);
        }
    }
};

反转法：

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    void reverse(vector<int>& nums, int ll, int rr){
        while(ll <= rr){
            int tmp = nums[rr];
            nums[rr] = nums[ll];
            nums[ll] = tmp;
            ll++;
            rr--;
        }
    }
};