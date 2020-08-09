#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    // Parameters:
    //        numbers:     an array of integers
    //        length:      the length of array numbers
    //        duplication: (Output) the duplicated number in the array number
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    void swap(int* numbers, int m, int n) {
        int tmp = numbers[m];
        numbers[m] = numbers[n];
        numbers[n] = tmp;
    }

    bool duplicate(int numbers[], int length, int* duplication) {
        if (length <= 1) return false;
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] != numbers[numbers[i]]) {
                    swap(numbers, i, numbers[i]);
                }
                else {
                    *duplication = numbers[i];
                    return true;
                }
            }
        }

        return false;
    }

    int getDuplicaton(const int* numbers, int length)
    {
        if (length <= 1 || numbers == nullptr) return -1;
        int ll = 1;
        int rr = length - 1;
        while (ll <= rr) {
            int mid = ll + (rr - ll) / 2;
            int count = countRange(numbers, length, ll, mid);
            if (ll == rr) {
                if (count > 1)
                    return ll;
                else
                    break;
            }
            if (count > (mid - ll + 1))
                rr = mid - 1;
            else
                ll = mid + 1;
        }
        return -1;
    }

    int countRange(const int* numbers, int length, int ll, int rr)
    {
        if (numbers == nullptr) return 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= ll && numbers[i] <= rr)
                count++;
        }
        return count;
    }

};

int main()
{
    int numbers[] = { 1,2,3,4,5,6,7,8 };
    Solution A;
    int length = 8;
    int res = A.getDuplicaton(numbers, length);
    cout << res << endl;
}