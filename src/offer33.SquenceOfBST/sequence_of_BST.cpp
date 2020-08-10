class Solution1 {
public:
    bool VerifySquenceOfBST(vector<int> sequence) {
        if (sequence.size() == 0) return false;
        return VerifySquenceOfBSTCore(sequence, 0, sequence.size()-1);
    }
    
    bool VerifySquenceOfBSTCore(vector<int>& sequence, int begin, int end){
        if (begin > end)
            return false;
        int i = 0;
        for (i = begin; i < end; i++){
            if (sequence[i] > sequence[end])
                break;
        }
        for (int j = i; j < end; j++){
            if (sequence[j] < sequence[end])
                return false;
        }
        bool left = true;
        if (i > begin+1)
            left = VerifySquenceOfBSTCore(sequence, begin, i-1) ;
        bool right = true;
        if (i < end-1)
            right = VerifySquenceOfBSTCore(sequence, i, end-1);
        return left && right;
    }
};

class Solution2 {
public:
    bool VerifySquenceOfBST(vector<int> sequence) {
        if (sequence.size() == 0) return false;
        int len = sequence.size();
        int i = 0;
        while (len--){
            while (sequence[i++] < sequence[len]);
            while (sequence[i++] > sequence[len]);
            if (i < len)
                return false;
            i = 0;
        }
        return true;
    }
};