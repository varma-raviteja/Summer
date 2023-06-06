class Solution {
    public boolean isIsomorphic(String s, String t) {
  if (s == null || t == null || s.length() != t.length())
    return false;
      
  Map<Character, Character> map1 = new HashMap<Character, Character>();
  Map<Character, Character> map2 = new HashMap<Character, Character>();
  
  int i = 0, j = 0;
  
  while (i < s.length()) {
    char c1 = s.charAt(i++);
    char c2 = t.charAt(j++);
    
    if (map1.containsKey(c1) && map1.get(c1) != c2) 
      return false;

    if (map2.containsKey(c2) && map2.get(c2) != c1)
      return false;
        
    if (!map1.containsKey(c1) && !map2.containsKey(c2)) {
      map1.put(c1, c2);
      map2.put(c2, c1);
    }
  }
  
  return true;
}
}
