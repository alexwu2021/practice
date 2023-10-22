from python3.leetcode.common_types import ListNode


class DeleteDuplicates2:

    def deleteDuplicates(self, head):
        fake = ListNode(-1)
        fake.next = head

        # prev := node before dups, curr := the last node of the duplication group
        curr, prev = head, fake
        while curr:
             # expecting a group of dups
            while curr.next and curr.val == curr.next.val:
                curr = curr.next
            if prev.next == curr:   # only 1 element
                prev = prev.next
                curr = curr.next
            else:   # skip a group of dups
                prev.next = curr.next
                curr = prev.next
        return fake.next