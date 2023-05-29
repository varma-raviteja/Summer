class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        

        ListNode temp=new ListNode(0);
        ListNode t=temp;
        while(list1!=null && list2!=null)
        {
            if(list1.val>=list2.val)
            {
                t.next= list2;
                list2=list2.next;
            }
            else
            {
                t.next=list1;
                list1=list1.next;
            }

            t=t.next;
        }
        
        if(list1!=null)
        {
            t.next=list1;
        }
        if(list2!=null)
        {
            t.next=list2;
        }
        return temp.next;


    }
}
