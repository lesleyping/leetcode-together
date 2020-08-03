class Solution {
public:
	void replaceSpace(char *str,int length) {
        if(str == nullptr || length <=0) return;
        int count = 0;
        for(int i = 0; i < length; i++){
            if (str[i] == ' '){
                count++;
            }
        }
        int newlen = length + 2*count;
        int ll = length - 1;
        int rr = newlen - 1;
        while(ll < rr && ll >= 0 && rr >= 0){
            if(str[ll] == ' '){
                str[rr--] = '0';
                str[rr--] = '2';
                str[rr--] = '%';
            }
            else{
                str[rr--] = str[ll];
            }
            ll--;
        }
	}
};