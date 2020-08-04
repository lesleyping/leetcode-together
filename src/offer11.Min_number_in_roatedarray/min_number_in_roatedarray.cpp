class Solution {
public:
    int minNumberInRotateArray(vector<int> rotateArray) {
        int ll = 0;
        int rr = rotateArray.size()-1;
        int mid = ll;   //！！！如果数组没有进行旋转
        while(rotateArray[ll] >= rotateArray[rr]){
            if((rr - ll) == 1){
                mid = rr;
                break;
            }
            mid = ll + (rr - ll) / 2;
            if(rotateArray[mid] < rotateArray[ll]){
                rr = mid;
            }
            else{
                ll = mid;
            }
        }
        return rotateArray[rr];
    }
};