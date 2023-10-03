
#guess this one is more suitable for me
#easy to understand, and easy to apply at the right time
#and should be accepted
def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        dummy = ListNode(-1)
        dummy.next = head
        curr = dummy
        while curr:
            if curr.next.val == val:
                curr.next = curr.next.next
            else:
                curr = curr.next
        return dummy.next
#
#
#
# #this java version accepted, but the python 3 version is not
# #due to the complaint that node type has no val or something similar
#  class Solution {
#
#     public ListNode removeElements(ListNode head, int val) {
#         ListNode dummy = new ListNode(0);
#         dummy.next = head;
#         ListNode cur = dummy;
#
#         while(cur.next != null) {
#             if(cur.next.val == val) {
#                 cur.next = cur.next.next;
#             }
#             else
#                 cur = cur.next;
#         }
#         return dummy.next;
#     }
# }
