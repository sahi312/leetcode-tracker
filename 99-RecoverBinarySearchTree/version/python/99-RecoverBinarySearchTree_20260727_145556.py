# Last updated: 7/27/2026, 2:55:56 PM
1class Solution(object):
2    def buildTree(self, inorder, postorder):
3        """
4        :type inorder: List[int]
5        :type postorder: List[int]
6        :rtype: TreeNode
7        """
8        # Base case
9        if not inorder:
10            return None
11        
12        # The last element of postorder list is the root
13        root_val = postorder.pop()
14        root = TreeNode(root_val)
15        
16        # Find the position of the root in the inorder list
17        inorder_index = inorder.index(root_val)
18        
19        # Recursively build the left and right subtrees
20        root.right = self.buildTree(inorder[inorder_index+1:], postorder)
21        root.left = self.buildTree(inorder[:inorder_index], postorder)
22        
23        return root