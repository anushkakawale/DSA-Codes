# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        result = []
        self.inorder(root, result)
        return result
    def inorder(self, node, result):
        if node is None:
            return
        self.inorder(node.left,result)
        result.append(node.val)
        self.inorder(node.right,result)