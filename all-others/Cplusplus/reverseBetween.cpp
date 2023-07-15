/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
    
private:
    ListNode* reverse(ListNode* head, ListNode* tail, ListNode** newTail){
        if (head == tail)
            return head;
        
        ListNode *prev = NULL;
        ListNode* newHead = NULL;
        ListNode* curr = head;
        while(curr != tail)
        {
            prev = curr;
            curr = curr->next;
    
            prev->next = NULL;
            if(!newHead){
                newHead = prev;
                *newTail = newHead;
            }
            else{
                prev->next = newHead;
                newHead = prev;
            }        
        }
        
        tail->next = newHead;
        newHead = tail;
        
        return newHead;    
    }
    
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode* temp = head;
        ListNode* start;
        ListNode* end;
        ListNode* startPrev;
        ListNode* endNext;
        
       int count = 1;
        while(count<m && temp){
            startPrev = temp;
            temp = temp->next;
            count++;
        }
        start = temp;
        while(count<n && temp){
            temp = temp->next;
            count++;
        }
        end = temp;
        if(end != NULL)
            endNext = end->next;
        
        ListNode** newTail = &end;
        startPrev->next = reverse(start, end, newTail);
        (*newTail)->next = endNext;
        
        return head;
    }
};


/*

failed on this test case
Input:
[3,5]
1
2
Output:
[3]
Expected:
[5,3]

*/

/* some one's code, no good, has memo leak
  ListNode* new_head = new ListNode(0);
        new_head -> next = head;
        ListNode* pre = new_head;
        for (int i = 0; i < m - 1; i++)
            pre = pre -> next;
        ListNode* cur = pre -> next;
        for (int i = 0; i < n - m; i++) {
            ListNode* move = cur -> next; 
            cur -> next = move -> next;
            move -> next = pre -> next;
            pre -> next = move;
        }
        return new_head -> next;

		
*/


/* should borrow the idea from the following python code

class Solution:
    # @param head, a ListNode
    # @param m, an integer
    # @param n, an integer
    # @return a ListNode
    def reverseBetween(self, head, m, n):
        if m == n:
            return head

        dummyNode = ListNode(0)
        dummyNode.next = head
        pre = dummyNode

        for i in range(m - 1):
            pre = pre.next
        
        # reverse the [m, n] nodes
        reverse = None
        cur = pre.next
        for i in range(n - m + 1):
            next = cur.next
            cur.next = reverse
            reverse = cur
            cur = next

        pre.next.next = cur
        pre.next = reverse

        return dummyNode.next
		
		
*/