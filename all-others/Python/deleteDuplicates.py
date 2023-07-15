# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
	#accepted
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return
        fakeHead = ListNode(0)
        fakeHead.next = head
        
        prev = head
        curr = head.next
        while curr:
            while curr and curr.val == prev.val:
                curr = curr.next
            prev.next = curr
            if not curr:
                break
            prev = curr
            curr = curr.next
        return fakeHead.next
                