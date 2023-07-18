class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}

class LRUCache {
    private Map<Integer, Node> m;
    private Node head;
    private Node tail;
    private int size;

    public LRUCache(int capacity) {
        size = capacity;
        m = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node p) {
        Node pre = p.prev;
        Node nex = p.next;
        pre.next = nex;
        nex.prev = pre;
    }

    private void addNode(Node newnode) {
        Node temp = head.next;
        head.next = newnode;
        newnode.prev = head;
        newnode.next = temp;
        temp.prev = newnode;
    }

    public int get(int key) {
        if (!m.containsKey(key))
            return -1;

        Node p = m.get(key);
        deleteNode(p);
        addNode(p);
        m.put(key, head.next);
        return head.next.val;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node c = m.get(key);
            deleteNode(c);
            c.val = value;
            addNode(c);
            m.put(key, head.next);
        } else {
            if (m.size() == size) {
                Node prev = tail.prev;
                deleteNode(prev);
                Node l = new Node(key, value);
                addNode(l);
                m.remove(prev.key);
                m.put(key, head.next);
            } else {
                Node l = new Node(key, value);
                addNode(l);
                m.put(key, head.next);
            }
        }
    }
}
