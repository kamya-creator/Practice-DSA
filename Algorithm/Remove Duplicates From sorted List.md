https://leetcode.com/problems/remove-duplicates-from-sorted-list/discuss/1759668/java-solution-with-dry-run
```
/*
 curr
  1 --------> 2---------> 3 ----------> 3 ------->null
  
  curr.val = 1 , curr.next.val =2   1!=2 so move curr to it's next 



            curr
  1 --------> 2---------> 3 ----------> 3 ------->null

curr.val = 2 , curr.next.val =3   2!=3 so move curr to it's next 


                        curr
  1 --------> 2---------> 3     3 ------->null
                          |________________|
  curr.val = 3 , curr.next.val =3   3==3 so move curr.next to it's next's next
  As we found the duplicate element hence breaking the link of duplicate elements


Now curr.next is pointing to null it means , we have removed all duplicate elements till curr and now we can return head of list

Final List

head
  1----------->2---------->3------>null

*/
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
        
        ListNode curr = head;
        
        while(curr.next != null)
        {
            if(curr.val == curr.next.val)
            {
                curr.next = curr.next.next;
            }
            else
                curr = curr.next;
        }
        return head;
    }
}
