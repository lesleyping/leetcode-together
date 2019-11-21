# Problem
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:
```
Input: 3
Output: "III"
```
Example 2:
```
Input: 4
Output: "IV"
```
Example 3:
```
Input: 9
Output: "IX"
```
Example 4:
```
Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
```
Example 5:
```
Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```

# Analyze
## Solution
看到一个有点厉害的解法
学习一下

```
char * intToRoman(int num){
    char * ret = NULL;
    if (num <= 0 || num > 3999) return ret;
    ret = (char *) malloc (sizeof(char) * 16);
    if (ret == NULL) {
        printf("申请内存出错");
        exit(0);
    }
    ret[15] = 0; // memset(ret, 0, 16);
    
    char Rome[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    char i = 14, j = 0, m = 0;
    
    while(num) {
        m = num % 10;
        num /= 10;
        while (1) {
            if (m == 9) {ret[i--] = Rome[j+2]; m = 1;}
            else if (m == 8) {ret[i--] = Rome[j]; m--;}
            else if (m == 7) {ret[i--] = Rome[j]; m--;}
            else if (m == 6) {ret[i--] = Rome[j]; m--;}
            else if (m == 5) {ret[i--] = Rome[j+1]; break;}
            else if (m == 4) {ret[i--] = Rome[j+1]; m=1;}
            else if (m == 3) {ret[i--] = Rome[j]; m--;}
            else if (m == 2) {ret[i--] = Rome[j]; m--;}
            else if (m == 1) {ret[i--] = Rome[j]; break;}
            else break;
        }
        j += 2;
    }
    return (ret + i + 1);
}

```