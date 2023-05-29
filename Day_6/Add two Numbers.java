class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head=l1;
        ListNode prev=l1;
        while(l1!=null && l2!=null)
        {
            int sum;
            sum=l1.val+l2.val+carry;
            if(sum>=10)
                carry=1;
            else carry=0;

            l1.val=sum%10;
            prev=l1;
            l1=l1.next;
            l2=l2.next;
            
        }

        if(l2!=null)
        {
            prev.next=l2;
            l1=prev.next;
        }
        if(l1==null && carry==1)
        {
            ListNode temp=new ListNode(1);
                prev.next=temp;
        }

        while(l1!=null)
        {
            int sum;
            sum=l1.val+carry;
            if(sum>=10)
                carry=1;
            else carry=0;

            l1.val=sum%10;
            if(l1.next==null && carry==1)
            {
                ListNode temp=new ListNode(0);
                l1.next=temp;
            }
            l1=l1.next;
        }

        return head;
    }
}
