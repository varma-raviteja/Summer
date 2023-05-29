class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map=new HashMap<>();
        Node i=head;
        while(i!=null)
        {
            map.put(i,new Node(i.val));
            i=i.next;
        }
        i=head;
        while(i!=null)
        {
            Node x=map.get(i);
            x.next=map.get(i.next);
            x.random=map.get(i.random);
            i=i.next;
        }

        return map.get(head);
    }
}
