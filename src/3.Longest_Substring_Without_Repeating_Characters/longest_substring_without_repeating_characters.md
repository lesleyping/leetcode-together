# Problem
Given a string, find the length of the longest substring without repeating characters.
## Solution one
遍历整个string，寻找最长的字符串并记录长度，用3个for循环。
## Solution two
滑动窗口思路
![1](https://github.com/npujcong/leetcode-together/blob/master/src/3.Longest_Substring_Without_Repeating_Characters/imgs/1.jpg)

原始字符串s如上图所示，从左侧开始遍历s，以i来标记窗口左侧，j来标记窗口右侧，初始时，i=0，j=1，此时窗口大小为2
然后从j开始判断j所在的字符与[i,j-1]窗口内有无重复字符，若无，则j右移，过程如下图；
![2](https://github.com/npujcong/leetcode-together/blob/master/src/3.Longest_Substring_Without_Repeating_Characters/imgs/2.jpg)

如下图，j移动到d的位置

![3](https://github.com/npujcong/leetcode-together/blob/master/src/3.Longest_Substring_Without_Repeating_Characters/imgs/3.jpg)

当j移动到d后面的a所在位置时，对应字符a在窗口中已经存在，此时，窗口大小为5，将窗口左侧移动到窗口内已存在字符位置的下一位，此时生成第二个窗口，如下图

![4](https://github.com/npujcong/leetcode-together/blob/master/src/3.Longest_Substring_Without_Repeating_Characters/imgs/4.jpg)

重复之前的操作，不断移动窗口左端与右端，得到最长无重复字符的窗口大小。

![5](https://github.com/npujcong/leetcode-together/blob/master/src/3.Longest_Substring_Without_Repeating_Characters/imgs/5.jpg)