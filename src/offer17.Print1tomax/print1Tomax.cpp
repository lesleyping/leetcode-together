class Solution1 {
public:
    vector<int> printNumbers(int n) {
        int max = 1;
        while (n--){
            max *= 10;
        }
        vector<int> res;
        for (int i = 1; i < max; i++){
            res.push_back(i);
        }
        return res;
    }
};

class Solution2 {
public:
    vector<int> vec_tmp;
    vector<int> printNumbers(int n) 
    {
        string tmp(n, '0');
        while (!increse(tmp))
            savetmp(tmp);
        return vec_tmp;
    }

    bool increse(string &tmp)
    {
        bool end = false;
        int stackover = 0;
        int tmp_size = tmp.size();
        for (int i = tmp_size - 1; i >= 0; i--) {
            int diff = tmp[i] - '0' + stackover;
            if (i == tmp_size - 1)
                diff++;
            if (diff >= 10) {
                if (i == 0) {
                     end = true;
                }
                else {
                    stackover = 1;
                    tmp[i] = diff - 10 + '0';
                }
            }
            else {             
                tmp[i] = diff + '0';
                break;
            }
        }
        return end;
    }

    void savetmp(string tmp)
    {
        string t = tmp.substr(tmp.find_first_not_of("0"));
        vec_tmp.push_back(std::atoi(t.c_str()));
    }
};

class Solution3 {
public:
    vector<int> printNumbers(int n) {
        vector<int> res;
        string tmp(n, '0');
        for (int i = 0; i < 10; i++){
            tmp[0] = i + '0';
            printNumbersCore(res, n, tmp, 0);
        }
        return res;
    }
    void printNumbersCore(vector<int>& res, int n, string& tmp, int index){
        if (index == n - 1){
            save(res, tmp);
            return;
        }
        for (int i = 0; i < 10; i++){
            tmp[index + 1] = i + '0';
            printNumbersCore(res, n, tmp, index + 1);
        }
    }
    void save(vector<int>& res, string tmp){
        if (tmp.find_first_not_of("0") == string::npos){
            return;
        }
        string str = tmp.substr(tmp.find_first_not_of("0"));
        res.push_back(std::atoi(str.c_str()));
    }
};