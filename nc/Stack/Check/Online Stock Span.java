class StockSpanner {
   Stack<Pair<Integer,Integer>> s;
   int i=0;
    public StockSpanner() {
        s=new Stack<>();
    }
    
    public int next(int price) {
        i++;
         
        if(!s.isEmpty() && s.peek().getKey()>price)
        {
            s.push(new Pair(price,i));
            return 1;
        }

        while(!s.isEmpty() && s.peek().getKey()<=price)
        {
            s.pop();
        }
        if(s.isEmpty())
        {
            s.push(new Pair(price,i));
            return i;
        }else
        {
            Pair<Integer,Integer> p=s.pop();
            s.push(p);
            s.push(new Pair(price,i));
            return i-p.getValue();

        }


       
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
