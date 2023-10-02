class Node{
         int key;
         int val;
         Node next;
         Node prev;
         int freq=1;
         Node(int k,int v){
             key=k;
             val=v;
         }
     }
     class DLL{
         Node head;
         Node tail;
         DLL(){
             head=new Node(-1,-1);
             tail=new Node(-1,-1);
             head.next=tail;
             tail.prev=head;
         }
         void addNode(Node newnode){
             Node next=head.next;
             head.next=newnode;
             newnode.prev=head;
             head.next=newnode;
            newnode.next=next;
            next.prev=newnode;
         }
         Node removenode(){
             Node node=tail.prev;
             node.prev.next=tail;
             tail.prev=node.prev;
             return node;
         }
         Node removeNode(Node delnode){
             Node prev=delnode.prev;
             Node next=delnode.next;
             prev.next=next;
             next.prev=prev;
             return delnode;
         }
         boolean isEmpty(){
             if(head.next==tail)return true;
             return false;
         }

     }
class LFUCache {
    /**
    capacity 
    current size , minfreq required to remove or replace new
    2 hashmap ---- 1. freq,DLLNode  2. Key, Node 
     */
     
    int capacity;
    int minfreq;
    Map<Integer,DLL>freqlist;
    Map<Integer,Node>lfucache;
    public LFUCache(int capacity) {
        this.capacity =capacity;
        this.minfreq=1;
        this.freqlist=new HashMap<>();
        this.lfucache=new HashMap<>();
    }
    
    public int get(int key) {
        if(lfucache.get(key)==null){
            return -1;
        }
        Node v=lfucache.get(key);
        freqlist.get(v.freq).removeNode(v);
        if(freqlist.get(v.freq).isEmpty()){
            if(minfreq==v.freq)
            minfreq=v.freq+1;
        }
        v.freq+=1;
        if(freqlist.get(v.freq)==null){
            DLL d=new DLL();
            d.addNode(v);
            freqlist.put(v.freq,d);
        }
        else{
            freqlist.get(v.freq).addNode(v);
        }
        return v.val;

    }
    
    public void put(int key, int value) {
        if(capacity==0)
        return ;
         if(lfucache.get(key)!=null){
        Node v=lfucache.get(key);
        freqlist.get(v.freq).removeNode(v);
        if(freqlist.get(v.freq).isEmpty()){
            if(minfreq==v.freq)
            minfreq=v.freq+1;
        }
        v.freq+=1;
        if(freqlist.get(v.freq)==null){
            DLL d=new DLL();
            d.addNode(v);
            freqlist.put(v.freq,d);
        }
        else{
            freqlist.get(v.freq).addNode(v);
        }
        v.val=value;
    }
    else{
        if(lfucache.size()==capacity){
            Node v=freqlist.get(minfreq).removenode();
            lfucache.remove(v.key);
        }
        Node newnode=new Node(key,value);
        lfucache.put(key,newnode);
        if(freqlist.get(1)!=null){
            freqlist.get(1).addNode(newnode);
        }
        else{
	     	DLL d=new DLL();
	     	d.addNode(newnode);
	     	freqlist.put(1,d);
	    }
        minfreq=1;
	      
    }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */