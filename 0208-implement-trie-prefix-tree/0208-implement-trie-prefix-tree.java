class Trie {
    private HashSet<String> set;

    public Trie() {
        set = new HashSet<>();
    }
    
    public void insert(String word) {
        set.add(word);
    }
    
    public boolean search(String word) {
        return set.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            String key = it.next();
            
            if(key.startsWith(prefix)){
                return true;
            }
        } 
        
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */