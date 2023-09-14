class Solution(object):
    def (self, l1, l2):
        # accepted
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 is None: return l2
        elif l2 is None: return l1
        val = l1.val + l2.val
        carry = 0 if val <= 9 else int(val/10)
        val = val % 10
        head = ListNode(val)
        l1, l2 = l1.next, l2.next
        temp = head
        while l1 is not None and l2 is not None:
            val = l1.val + l2.val + carry
            carry = 0 if val <= 9 else int(val/10)
            val = val % 10
            temp.next = ListNode(val)
            temp = temp.next
            l1, l2 = l1.next, l2.next
            
        while l1 is not None:
            val = l1.val + carry
            carry = 0 if val <= 9 else int(val/10)
            val = val % 10
            temp.next = ListNode(val)
            temp = temp.next
            l1 = l1.next
            
        while l2 is not None:
            val = l2.val + carry
            carry = 0 if val <= 9 else int(val/10)
            val = val % 10
            temp.next = ListNode(val)
            temp = temp.next
            l2 = l2.next
        
        if carry > 0:
            temp.next = ListNode(carry)
            temp = temp.next
            
        return head
