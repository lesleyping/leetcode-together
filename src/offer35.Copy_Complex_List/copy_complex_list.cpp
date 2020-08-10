/*
struct RandomListNode {
    int label;
    struct RandomListNode *next, *random;
    RandomListNode(int x) :
            label(x), next(NULL), random(NULL) {
    }
};
*/
class Solution1 {
public:
    RandomListNode* Clone(RandomListNode* pHead)
    {
        if (pHead == nullptr)
            return nullptr;
        RandomListNode* head = pHead;
        while (head != nullptr){
            RandomListNode* node = new RandomListNode(head->label);
            node->next = head->next;
            head->next = node;
            head = node->next;
        }
        head = pHead;
        while (head != nullptr){
            if (head->random){
                head->next->random = head->random->next;
            }
            head = head->next->next;
        }
        head = pHead;
        RandomListNode* newhead = pHead->next;
        RandomListNode* newNode = pHead->next;
        while (head != nullptr){
            head->next = head->next->next;
            if (newhead->next)
                newhead->next = newhead->next->next;
            head = head->next;
            newhead = newhead->next;
        }
        return newNode;
    }

};

/*
struct RandomListNode {
    int label;
    struct RandomListNode *next, *random;
    RandomListNode(int x) :
            label(x), next(NULL), random(NULL) {
    }
};
*/
#include <unordered_map>
class Solution2 {
public:
    RandomListNode* Clone(RandomListNode* pHead)
    {
        if (pHead == nullptr)
            return nullptr;
        unordered_map<RandomListNode*, RandomListNode*> hash;
        RandomListNode* tmp = pHead;
        while(tmp != nullptr){
            hash[tmp] = new RandomListNode(tmp->label);
            tmp = tmp->next;
        }
        tmp = pHead;
        while(tmp != nullptr){
            if (tmp->next)
                hash[tmp]->next = hash[tmp->next];
            if (tmp->random)
                hash[tmp]->random = hash[tmp->random];
            tmp = tmp->next;
        }
        return hash[pHead];
    }

};

/*
struct RandomListNode {
    int label;
    struct RandomListNode *next, *random;
    RandomListNode(int x) :
            label(x), next(NULL), random(NULL) {
    }
};
*/
#include <unordered_map>
class Solution3 {
public:
    RandomListNode* Clone(RandomListNode* pHead)
    {
        if (pHead == nullptr)
            return nullptr;
        unordered_map<RandomListNode*, RandomListNode*> hash;
        return dfs(pHead, hash);
    }
    RandomListNode* dfs(RandomListNode* node, unordered_map<RandomListNode*, RandomListNode*>& hash)
    {
        if (node == nullptr)
            return nullptr;
        if (hash.count(node))
            return hash[node];
        RandomListNode* newnode = new RandomListNode(node->label);
        hash[node] = newnode;
        hash[node]->next = dfs(node->next, hash);
        hash[node]->random = dfs(node->random, hash);
        return newnode;
    }
};

/*
struct RandomListNode {
    int label;
    struct RandomListNode *next, *random;
    RandomListNode(int x) :
            label(x), next(NULL), random(NULL) {
    }
};
*/
#include <unordered_map>
class Solution4 {
public:
    RandomListNode* Clone(RandomListNode* pHead)
    {
        if (pHead == nullptr)
            return nullptr;
        return bfs(pHead);
    }
    RandomListNode* bfs(RandomListNode* node)
    {
        if (node == nullptr)
            return nullptr;
        unordered_map<RandomListNode*, RandomListNode*> hash;
        hash[node] = new RandomListNode(node->label);
        queue<RandomListNode*> que;
        que.push(node);
        while(!que.empty()){
            int len = que.size();
            for(int i = 0; i < len; i++){
                RandomListNode* tmp = que.front();
                que.pop();
                if (tmp->next){
                    if (hash.count(tmp->next) == 0){
                        hash[tmp->next] = new RandomListNode(tmp->next->label);
                        que.push(tmp->next);
                    }
                    hash[tmp]->next = hash[tmp->next];
                }
                if (tmp->random){
                    if (hash.count(tmp->random) == 0){
                        hash[tmp->random] = new RandomListNode(tmp->random->label);
                        que.push(tmp->random);
                    }
                    hash[tmp]->random = hash[tmp->random];
                }
            }
        }
        return hash[node];
    }
};