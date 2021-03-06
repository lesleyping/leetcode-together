# Problem
每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

如果没有小朋友，请返回-1
# Anylyze
## Solution1
- 环形链表
## Solution2
- 数学解法：约瑟夫环问题

**问题1：**假设我们已经知道11个人时，胜利者的下标位置为6。那下一轮10个人时，胜利者的下标位置为多少？

**答：**其实吧，第一轮删掉编号为3的人后，之后的人都往前面移动了3位，胜利这也往前移动了3位，所以他的下标位置由6变成3。

**问题2：**假设我们已经知道10个人时，胜利者的下标位置为3。那下一轮11个人时，胜利者的下标位置为多少？

**答：**这可以看错是上一个问题的逆过程，大家都往后移动3位，所以f ( 11 , 3 ) = f ( 10 , 3 ) + 3 。不过有可能数组会越界，所以最后模上当前人数的个数，f ( 11 , 3 ) = （ f ( 10 , 3 ) + 3 ） % 11 

**问题3：**现在改为人数改为N，报到M时，把那个人杀掉，那么数组是怎么移动的？

**答：**每杀掉一个人，下一个人成为头，相当于把数组向前移动M位。若已知N-1个人时，胜利者的下标位置位f ( N − 1 , M )则N个人的时候，就是往后移动M为，(因为有可能数组越界，超过的部分会被接到头上，所以还要模N)，既f ( N , M ) = ( f ( N − 1 , M ) + M ) % n

**注：**理解这个递推式的核心在于关注胜利者的下标位置是怎么变的。每杀掉一个人，其实就是把这个数组向前移动了M位。然后逆过来，就可以得到这个递推式。

