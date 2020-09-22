# Problem
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
# Anylyze
## Solution1
- 两个堆解决，偶数时目标加入小根堆，奇数是目标加入大根堆
- 先用java集合PriorityQueue来设置一个小顶堆和大顶堆
主要的思想是：因为要求的是中位数，那么这两个堆，大顶堆用来存较小的数，从大到小排列；
小顶堆存较大的数，从小到大的顺序排序*，显然中位数就是大顶堆的根节点与小顶堆的根节点和的平均数。\
⭐保证：小顶堆中的元素都大于等于大顶堆中的元素，所以每次塞值，并不是直接塞进去，而是从另一个堆中poll出一个最大（最小）的塞值\
⭐当数目为偶数的时候，将这个值插入大顶堆中，再将大顶堆中根节点（即最大值）插入到小顶堆中；\
⭐当数目为奇数的时候，将这个值插入小顶堆中，再讲小顶堆中根节点（即最小值）插入到大顶堆中；\
⭐取中位数的时候，如果当前个数为偶数，显然是取小顶堆和大顶堆根结点的平均值；如果当前个数为奇数，显然是取小顶堆的根节点
## Solution2
- 二叉平衡树\
参考\
struct myTreeNode
{
	int val;
	int count;//以此节点为根的树高
	struct myTreeNode* left;
	struct myTreeNode* right;
	myTreeNode(int v) :
		val(v), 
		count(1), left(NULL), right(NULL) {}

};

myTreeNode *root = NULL;

class Solution
{
public:

	/*计算以节点为根的树的高度
	*/
	int totalCount(myTreeNode* node)
	{
		if (node == NULL)
			return 0;
		else
			return node->count;
	}

	//左左
	void rotateLL(myTreeNode* &t)
	{
		myTreeNode* k = t->left;
		myTreeNode* tm = NULL;
		while (k->right != NULL)
		{
			k->count--;
			tm = k;
			k = k->right;
			
		}
		if (k != t->left)
		{
			k->left = t->left;
			tm->right = NULL;
		}
		t->left = NULL;
		k->right = t;

		t->count = totalCount(t->left) + totalCount(t->right) + 1;
		k->count = totalCount(k->left) + t->count + 1;

		t = k;
	}

	//右右
	void rotateRR(myTreeNode* &t)
	{
		myTreeNode* k = t->right;
		myTreeNode* tm = NULL;
		while (k->left != NULL) {
			k->count--;
			tm = k;
			k = k->left;
			
		}
		if (k != t->right)
		{
			k->right = t->right;
			tm->left = NULL;
		}
			
		t->right = NULL;
		k->left = t;

		t->count = totalCount(t->left) + 1;
		k->count = totalCount(k->right)+ t->count + 1;
		t = k;
	}

	//左右
	void rotateLR(myTreeNode* &t)
	{
		rotateRR(t->left);
		rotateLL(t);
	}

	//右左
	void rotateRL(myTreeNode* &t)
	{
		rotateLL(t->right);
		rotateRR(t);
	}

	//插入
	void insert(myTreeNode* &root, int x)
	{
		if (root == NULL)
		{
			root = new myTreeNode(x);
			return;
		}
		
		if (root->val >= x)
		{
			insert(root->left, x);
			root->count = totalCount(root->left)+ totalCount(root->right) + 1;
			if (2 == totalCount(root->left) - totalCount(root->right))
			{
				if (x < root->left->val)
				{
					rotateLL(root);
				}
				else
				{
					rotateLR(root);
				}
			}
		}
		else
		{
			insert(root->right, x);
			root->count = totalCount(root->left)+ totalCount(root->right) + 1;
			if (2 == totalCount(root->right) - totalCount(root->left))
			{
				if (x > root->right->val)
				{
					rotateRR(root);
				}
				else {
					rotateRL(root);
				}
			}
		}

	}

	void deleteTree(myTreeNode* root)
	{
		if (root == NULL)return;
		deleteTree(root->left);
		deleteTree(root->right);
		delete root;
		root = NULL;
	}
	
	void Insert(int num)
	{
		insert(root, num);
	}

	double GetMedian()
	{
		int lc = totalCount(root->left), rc = totalCount(root->right);
		if ( lc == rc)
			return root->val;
		else
		{
			bool isLeft = lc > rc ;
			myTreeNode* tmp ;
			if (isLeft)
			{
				tmp = root->left;
				while (tmp->right != NULL)
				{
					tmp = tmp->right;
				}
			}
			else {
				tmp = root->right;
				while (tmp->left != NULL)
				{
					tmp = tmp->left;
				}
			}
			return (double)(root->val + tmp->val) / 2.0;
		}
	}

};