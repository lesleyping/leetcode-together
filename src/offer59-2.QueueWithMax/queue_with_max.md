# Problem
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

# Anylyze
## Solution
ArrayList是顺序结构，所以定位很快，但插入，删除数据慢。\
LinkedList 是链表结构，定位慢，但插入，删除数据快。

ArrayList实现了List接口，常见方法有：\
add(); contains(); get(); indexOf():定位对象所处的位置; \
remove(); size(); toArray(); toString();//转换为字符串

LinkedList也实现了List接口外，可以实现上述ArrayList中的常用方法，此外：

1.LinkedList还实现了双向链表结构Deque，可以很方便的在头尾插入删除数据。\
LinkedList<class> link = new LinkedList<>();\
常用方法：addFirst(); addLast(); getFirst(); getLast(); removeFirst(); removeLast();

2.LinkedList除了实现了List和Deque外，还实现了Queue接口(队列),Queue是先进先出队列 FIFO。\
Queue<class> queue = new LinkedList<>();\
常用方法：poll()取出第一个元素; peek()查看第一个元素; offer()在最后添加元素,可用add()替换;


- 最大：输出最大栈的第一个元素
- push：删除最大栈中比自己小的元素
- pop：注意删除队列中最大元素的情况


