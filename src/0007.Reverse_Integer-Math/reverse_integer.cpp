#include <iostream>
using namespace std;

class Solution{
public:
	int reverse(int x){
		int max_x = 0x7fffffff;
		int min_x = 0x80000000;
		int result = 0;
		while(x){

			int remainder = x % 10;
			x = x / 10;
			if((remainder> 7 && result == max_x / 10) || result > max_x /10) return 0;
			if((remainder<-8 && result == min_x / 10) || result < min_x /10) return 0;
			result = result * 10 + remainder;
		}
		return result;
	}
};

int main()
{
	Solution s ;
	int test = 123456789123456789123456;
	int ans = s.reverse(test);
	cout << ans << endl;
	return 0;
}
