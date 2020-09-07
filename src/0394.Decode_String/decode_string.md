# Problem
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入

# Anylyze
## Solution1-辅助栈
建立两个栈，分别存放multi和res\
- 当遇到'['时：入栈当前的res和multi，并分别置空
- 当遇到']'时，出栈cur_multi,cur_res ; res = cur_res + cur_multi * res;
- 当遇到数字时，更新multi
- 当遇到字母时，更新res

## Solution2
- DFS
- 遇到[时：开始递归
- 遇到]时：返回当前的index和string
- 遇到数字：更新multi
- 遇到字母：更新string