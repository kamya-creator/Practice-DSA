https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/1783662/Java-Solution-with-DRY-RUN
```
/*
prev      head
  0    --> 1 -> 2 -> 3 -> 3 -> 4 -> 4 ->5
dummy

head will keep track of removing the duplicates elements of Sorted LL
so when head.next != null and head.next.val == head.val 
move the head pointer to it's next until head.next.val != head.val
 
When head.next.val not equal to head.val then just mov prev and head pointer by one step


         prev  head
  0    --> 1 -> 2 -> 3 -> 3 -> 4 -> 4 ->5
dummy


              prev  head
  0    --> 1 -> 2 -> 3 -> 3 -> 4 -> 4 ->5
dummy

Now head.next.val == head.val so move head pointer till head.next.val != head.val


              prev      head
  0    --> 1 -> 2 -> 3 -> 3 -> 4 -> 4 ->5
dummy


Now head is pointing to last occurence of duplicate element so connect pre next to head next  and move head to it's next

1. prev.next = head.next

              prev      head
  0    --> 1 -> 2   3 -> 3 -> 4 -> 4 ->5
dummy           |_____________|


2. head = head.next
              prev          head
  0    --> 1 -> 2   3 -> 3 -> 4 -> 4 ->5
dummy           |_____________|


now head.val == head.next.val so move head pointer till head.next.val != head.val

              prev               head
  0    --> 1 -> 2   3 -> 3 -> 4 -> 4 ->5
dummy           |_____________|

Now head is pointing to last occurence of duplicate element so connect pre next to head next  and move head to it's next

1. prev.next = head.next

             prev               head
  0    --> 1 -> 2   3 -> 3 -> 4 -> 4 ->5
dummy           |______________________|


2. head = head.next

             prev                    head
  0    --> 1 -> 2   3 -> 3 -> 4 -> 4 ->5
dummy           |______________________|


Resultant LL  : 

     0 -> 1->2->5
    dummy    
    
    RETURN dummy.next
*/

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        
        while(head != null)
        {
            if(head.next != null && head.val == head.next.val)
            {
                while(head.next != null && head.val == head.next.val)
                {
                    head = head.next;
                }
                
                prev.next = head.next;
                head = head.next;
            }
            else
            {
                prev= prev.next;
                head = head.next;
            }
        }
        
        return dummy.next;
        
        
    }
}
