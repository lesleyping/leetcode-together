class Solution1 {
public:
     int  NumberOf1(int n) {
         int count = 0;
         unsigned int flag = 1;
         while(flag){
             if(n & flag){
                 count++;
             }
             flag = flag << 1;
         }
         return count;
     }
};
class Solution2 {
public:
     int  NumberOf1(int n) {
         int count = 0;
         while(n){
             int nn = n - 1;
             n = n & nn;
             count++;
         }
         
         return count;
     }
};