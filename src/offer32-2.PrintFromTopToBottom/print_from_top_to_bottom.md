## Problem
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
## Anylyze
每一层用queue.size()大小控制输出，即可确保同时输出的在同一层结构中。