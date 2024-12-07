from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def is_subtree_thisroot(self, root: Optional[TreeNode], sub: Optional[TreeNode]) -> bool:
        if sub is None:
            return root is None

        if root is None:
            return False

        if root.val == sub.val:
            if self.is_subtree_thisroot(root.left, sub.left) and self.is_subtree_thisroot(root.right, sub.right):
                return True

        return False

    def isSubtree(self, root: Optional[TreeNode], sub: Optional[TreeNode]) -> bool:
        if self.is_subtree_thisroot(root, sub):
            return True

        if root.left is not None and self.isSubtree(root.left, sub):
            return True
        if root.right is not None and self.isSubtree(root.right, sub):
            return True
        return False






root = TreeNode(
    3,
    TreeNode(
        4,
        TreeNode(1),
        TreeNode(
            2,
            None,
            TreeNode(0),
        )
    ),
    TreeNode(5))

sub = TreeNode(
    3,
    TreeNode(4),
    TreeNode(5),
)

s = Solution()
print(s.isSubtree(root, sub))
