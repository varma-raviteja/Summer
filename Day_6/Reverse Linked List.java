class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode first=head;
        ListNode second=first;
        ListNode last=null;

        while(first!=null)
        {
            second=first.next;
            first.next=last;
            last=first;
            first=second;
        }
        return last;
    }
}
