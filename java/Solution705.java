class MyHashSet {

    class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static final float FACTOR_THRESHOLD = 0.8f;
    private static final int FACTOR_SCALE = 2;

    private int count;
    private int size;
    // the threshold of scale
    private int threshold;
    // data
    private Node[] set;


    public MyHashSet() {
        this.count = 0;
        this.size = 8;
        this.threshold = (int) (this.size * FACTOR_THRESHOLD);
        this.set = new Node[8];
    }
    
    public void add(int key) {
        if( this.contains(key) ) return;
        this.count ++;
        scale();
        int address = key % this.size;
        if( this.set[address] == null) {
            this.set[address] = new Node(key);
            return;
        }
        Node cur = this.set[address];
        while(cur.next != null) cur = cur.next;
        cur.next = new Node(key);
    }
    
    public void remove(int key) {
        int address = key % this.size;
        if(this.set[address] == null) return;
        Node pre = this.set[address];
        if ( pre.val == key) this.set[address] = pre.next;
        while ( pre.next != null && pre.next.val != key) pre = pre.next;
        if (pre.next == null) return;
        if (pre.next.next ==null) {
            pre.next = null;
            return;
        }
        pre.next = pre.next.next;
    }
    
    public boolean contains(int key) {
        int address = key % this.size;
        if(this.set[address] == null) return false;
        Node cur = this.set[address];
        while( cur != null && cur.val != key) cur = cur.next;
        if (cur == null) return false;
        return true; 
    }

    public void scale() {
        if( this.count < this.threshold) return;
        this.size = this.size * FACTOR_SCALE;
        this.threshold = (int)(this.size * FACTOR_THRESHOLD);
        Node[] newSet = new Node[this.size];
        // bianli
        int address;
        for( Node node : this.set) {
            Node p = node;
            while( p != null) {
                address = p.val % this.size;
                if (newSet[address] == null){
                    newSet[address] = new Node(p.val);
                    p = p.next;
                    continue;
                }
                Node cur = newSet[address];
                while(cur.next!= null) cur = cur.next;
                cur.next = new Node(p.val);
                p = p.next;
            }
        }
        this.set = newSet;
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
