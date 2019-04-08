# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
from random import randint
import sys
class Solution:

    def __init__(self, head):
        """
        @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node.
        :type head: ListNode
        """
        self.head = head
   
    #accepted
    def getRandom_others(self):
        result, node, index = self.head, self.head.next, 1
        while node:
            if random.randint(0, index) is 0:
                result = node
            node = node.next
            index += 1
        return result.val

    def getRandom(self):
        """
        Returns a random node's value.
        :rtype: int
        """
        result = self.head
        temp = self.head.next
        count = 1
        while temp:
            if randint(0, count) == 0:
                result = temp
            temp = temp.next
            count += 1
        return result.val

# Your Solution object will be instantiated and called as such:
# obj = Solution(head)
# param_1 = obj.getRandom()