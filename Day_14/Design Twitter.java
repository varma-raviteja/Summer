class Twitter {
    int time;
    PriorityQueue<Pair< Integer,Pair<Integer,Integer> >> pq;
    HashMap<Integer,Set<Integer>> users;
    public Twitter() {
        pq=new PriorityQueue<>(
            (a,b) -> b.getKey()-a.getKey()
        );
        time=0;
        users=new HashMap<>();

    }
    
    public void postTweet(int userId, int tweetId) {
        time=time+1;
        pq.add(new Pair(time,new Pair(userId,tweetId)));
        if(!users.containsKey(userId))
        {
            users.put(userId,new HashSet<>());
        }
        Set<Integer> temp=users.get(userId);
        temp.add(userId);
        users.put(userId,temp);
        System.out.println(pq);
        System.out.println(users);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        int count=0;
        List<Integer> res=new ArrayList<>();
        Queue<Pair< Integer,Pair<Integer,Integer> >> q=new LinkedList<>();
        while(count<10)
        {
            if(pq.isEmpty())
            break;
            Pair< Integer,Pair<Integer,Integer> > heap=pq.poll();
            int time=heap.getKey();
            int uid=heap.getValue().getKey();
            int tid=heap.getValue().getValue();
            Set<Integer> connections=users.get(userId);

            if(connections.contains(uid))
            {
                res.add(tid);
                count++;
            }
            q.add(new Pair(time,new Pair(uid,tid)));

            
        }


        while(!q.isEmpty())
        {
            pq.add(q.poll());
        }




        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId))
        {
            users.put(followerId,new HashSet<>());
        }

        Set<Integer> temp=users.get(followerId);
        
        temp.add(followeeId);
        users.put(followerId,temp);
        System.out.println(users);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> temp=users.get(followerId);
        temp.remove(followeeId);
        users.put(followerId,temp);
        System.out.println(users);
    }
}

