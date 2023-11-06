class MinStack {

    private static final int INITIAL_VOLUMN = 8;
    private int[] stack;
    private int vol;
    private int p;
    private int[] minStack;
    private int minVol;
    private int minP;
    private int minValue;

    public MinStack() {
        this.stack = new int[INITIAL_VOLUMN];
        this.minStack = new int[INITIAL_VOLUMN];
        this.vol = INITIAL_VOLUMN;
        this.minVol = INITIAL_VOLUMN;
        this.minValue = Integer.MAX_VALUE;
        this.p = 0;
        this.minP = 0;
    }
    
    public void push(int val) {
        if( this.vol - this.p <= 2) {
            this.vol *= 2;
            int[] newStack = new int[this.vol];
            for(int i = 0 ; i < this.p; i ++) {
                newStack[i] = this.stack[i];
            }
            this.stack = newStack;
        }
        this.stack[this.p++] = val;
        if(val <= this.minValue) {
            this.minValue = val;
            pushMin(val);
        }
        return;
    }
    
    public void pop() {
        if(this.stack[--this.p] == this.minValue) popMin();
    }
    
    public int top() {
        return this.stack[this.p-1];
    }
    
    public int getMin() {
        return this.minValue;
    }

    private void pushMin(int val) {
        if(this.minVol - this.minP <= 2) {
            this.minVol *= 2;
            int[] newMinStack = new int[this.minVol];
            for(int i = 0 ; i < this.minP; i++) {
                newMinStack[i] = this.minStack[i];
            }
            this.minStack = newMinStack;
        }
        this.minStack[this.minP++] = val;
    }

    private void popMin() {
        this.minP--;
        this.minValue = this.minP == 0 ? Integer.MAX_VALUE: this.minStack[this.minP-1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
