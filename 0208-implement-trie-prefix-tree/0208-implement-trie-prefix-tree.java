class Trie {
    class TrieNode {
        public HashMap<Character, TrieNode> childNodes;
        public boolean isLast;
        public TrieNode(){
            this.childNodes = new HashMap<>();
            this.isLast = false;
        }
    }

    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = this.root;
        
        for(int i = 0; i < word.length(); i++){
            node = node.childNodes.computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        
        node.isLast = true;
    }
    
    public boolean search(String word) {
        TrieNode node = this.root;
        char c;
        
        for(int i = 0; i < word.length(); i++){
            c = word.charAt(i);
            
            if(!node.childNodes.containsKey(c)){
                return false;
            }
            
            node = node.childNodes.get(c);
        }
        
        return node.isLast;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        char c;
        
        for(int i = 0; i < prefix.length(); i++){
            c = prefix.charAt(i);
            
            if(!node.childNodes.containsKey(c)){
                return false;
            }
            
            node = node.childNodes.get(c);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */