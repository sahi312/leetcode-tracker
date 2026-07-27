// Last updated: 7/27/2026, 2:58:32 PM
1/**
2 * Definition for singly-linked list.
3 * struct ListNode {
4 *     int val;
5 *     ListNode *next;
6 *     ListNode() : val(0), next(nullptr) {}
7 *     ListNode(int x) : val(x), next(nullptr) {}
8 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
9 * };
10 *
11 * Definition for a binary tree node.
12 * struct TreeNode {
13 *     int val;
14 *     TreeNode *left;
15 *     TreeNode *right;
16 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
17 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
18 *     TreeNode(int x, TreeNode *left, TreeNode *right)
19 *         : val(x), left(left), right(right) {}
20 * };
21 */
22
23
24class Solution {
25public:
26    TreeNode* sortedListToBST(ListNode* head) {
27        if(!head) return nullptr;
28        if(!head->next) return new TreeNode(head->val);
29        ListNode *slow = head;
30        ListNode *fast = head;
31        ListNode *prev = head;
32
33        while(fast && fast->next){
34            prev = slow;
35            slow = slow->next;
36            fast = fast->next->next;
37        }
38        prev->next = nullptr;
39        TreeNode *root = new TreeNode(slow->val);
40        root->left = sortedListToBST(head);
41        root->right = sortedListToBST(slow->next);
42
43        return root;
44    }
45};