 public String longestCommonPrefix(String[] strs) {  // O(S) O(1)  where S is the sum of all characters in all strings.
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++)
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }        
    return prefix;
}




public String longestCommonPrefix(String[] strs) {  // O(S) O(m⋅logn) In the worst case we have n equal strings with length m
    if (strs == null || strs.length == 0) return "";    
        return longestCommonPrefix(strs, 0 , strs.length - 1);
}

private String longestCommonPrefix(String[] strs, int l, int r) {
    if (l == r) {
        return strs[l];
    }
    else {
        int mid = (l + r)/2;
        String lcpLeft =   longestCommonPrefix(strs, l , mid);
        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
        return commonPrefix(lcpLeft, lcpRight);
   }
}

String commonPrefix(String left,String right) {
    int min = Math.min(left.length(), right.length());       
    for (int i = 0; i < min; i++) {
        if ( left.charAt(i) != right.charAt(i) )
            return left.substring(0, i);
    }
    return left.substring(0, min);
}


public String longestCommonPrefix(String[] strs) { // O(S⋅log⁡m) O(1)
    if (strs == null || strs.length == 0)
        return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs)
        minLen = Math.min(minLen, str.length());
    int low = 1;
    int high = minLen;
    while (low <= high) {
        int middle = (low + high) / 2;
        if (isCommonPrefix(strs, middle))
            low = middle + 1;
        else
            high = middle - 1;
    }
    return strs[0].substring(0, (low + high) / 2);
}

private boolean isCommonPrefix(String[] strs, int len){
    String str1 = strs[0].substring(0,len);
    for (int i = 1; i < strs.length; i++)
        if (!strs[i].startsWith(str1))
            return false;
    return true;
}





class Solution { // O(S) O(M)
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        
        Trie t = new Trie();
        for (String s : strs)
            t.insert(s);
        
        return t.search(strs[0], strs.length);
    }
}


class Trie{
    class TrieNode{
        boolean isEnd;
        int size;
        TrieNode[] next;
        
        public TrieNode() {
            isEnd = false;
            size = 0;
            next = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()){
            if(node.next[c-'a'] == null){
                node.next[c-'a'] = new TrieNode();
            }
            node.next[c-'a'].size++;
            node = node.next[c-'a'];
        }
        node.isEnd = true;
    }
    
    public String search(String s, int N){
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(node.next[c-'a'] != null && node.next[c-'a'].size == N){
                node = node.next[c-'a'];
            }else {
                return s.substring(0, i);
            }
        }
        return s;
    }
}

