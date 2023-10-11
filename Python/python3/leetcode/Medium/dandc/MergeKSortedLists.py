from typing import List, Optional

from python3.leetcode.common_types import ListNode
import unittest

class MergeKSortedLists:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        def merge2Lists(l1, l2):
            head = point = ListNode(0)
            while l1 and l2:
                if l1.val <= l2.val:
                    point.next = l1
                    l1 = l1.next
                else:
                    point.next = l2
                    l2 = l1
                    l1 = point.next.next
                point = point.next

            if not l1:
                point.next = l2
            else:
                point.next = l1
            return head.next

        if not lists or len(lists) == 0:
            return None
        k = len(lists)

        # this is a typical bottom up merging strategy
        # we first merge objects at a stepwidth of nlargest
        # then at the next run merge with step width of nlargest * nlargest
        # with the potentially trailing odd-indexed object picked up a later run, but not necessarily immediately after the current nlargest run

        # step width, initially at 1, doubled on every turn, and ended at n
        interval = 1
        while interval < k:
            # every pair for each turn, with lists[0] participating in the start of every turn
            # [0, 1] -> [0], [2, 3] -> [2],  [4]
            # then [0, 2] ->[0], [4] -> [4]
            # then finally [0, 4]

            # if there is an odd number of ListNode lists, then the last list must be at index of k-1
            # while k-2 has been a multiple of intervals,
            # so that list will be picked up in the run where interval == k-2
            # that is, merging [0, k-1] into [0]

            for i in range(0, k - interval, interval * 2):
                lists[i] = merge2Lists(lists[i], lists[i + interval])
            interval *= 2

        return lists[0] # if len(lists) % 2 == 0 else merge2Lists(lists[0], lists[len(lists) -1])

class TestMergeKSortedLists(unittest.TestCase):
    sol = MergeKSortedLists()
    def test1(self):
        l1 = ListNode(1)
        l1.next = ListNode(4)
        l1.next.next = ListNode(5)

        l2 = ListNode(1)
        l2.next = ListNode(3)
        l2.next.next = ListNode(4)

        l3 = ListNode(2)
        l3.next = ListNode(6)

        l4 = ListNode(1)
        l4.next = ListNode(9)

        l5 = ListNode(5)
        l5.next = ListNode(99)

        lists = [l1, l2, l3, l4, l5]

        actual = self.sol.mergeKLists(lists)
        self.assertTrue(actual.val == 1)

        while actual.next:
            actual = actual.next

        self.assertTrue(actual.val == 99)



if __name__ == "_main_":
    unittest.main()
