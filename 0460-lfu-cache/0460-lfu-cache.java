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
/*
addNode--
we will add node right after head ... when frequency is upadated or new put
 */
         Node removenode(){
             Node node=tail.prev;
             node.prev.next=tail;
             tail.prev=node.prev;
             return node;
         }
/*
removenode
we will remove node tail.prev to delete it when there will be new put 
 */
         Node removeNode(Node delnode){
             Node prev=delnode.prev;
             Node next=delnode.next;
             prev.next=next;
             next.prev=prev;
             return delnode;
         }
/*
removenode(v)--
when freq is updated we ahve to update it in freqmap shift link to addition frequency DLL
 */
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
        if(lfucache.get(key)==null){    //if key-node doesnt present it map return -1
            return -1;
        }
        Node v=lfucache.get(key);          // Node v = node having key 
        freqlist.get(v.freq).removeNode(v); // from freqlist we will delete it having its freq as key
        if(freqlist.get(v.freq).isEmpty()){   // if previous frequency is null now then 
            if(minfreq==v.freq)                //if it was minfreq then it will updated
            minfreq=v.freq+1;
        }
        v.freq+=1;                              //now we will add it to new freq
        if(freqlist.get(v.freq)==null){         // if it is null we have to create new DLL
            DLL d=new DLL();         
            d.addNode(v);                   // newnode added  after head
            freqlist.put(v.freq,d);         // freqlist updated --- changed from one freq to other
        }
        else{
            freqlist.get(v.freq).addNode(v);    // if it is not null we simply add node 
        }
        return v.val;

    }

    public void put(int key, int value) {
        if(capacity==0)
        return ;
         if(lfucache.get(key)!=null){      // if it is  present in lfucache map   
        Node v=lfucache.get(key);           // v= node having key
        freqlist.get(v.freq).removeNode(v); // removing node from its place
        if(freqlist.get(v.freq).isEmpty()){ //updating minfreq
            if(minfreq==v.freq)
            minfreq=v.freq+1;
        }
        v.freq+=1;                             // freq is updated now 
        if(freqlist.get(v.freq)==null){         // adding node to its new place of new freq
            DLL d=new DLL();
            d.addNode(v);
            freqlist.put(v.freq,d);
        }
        else{
            freqlist.get(v.freq).addNode(v);
        }
        v.val=value;                        // new value updated
    }
    else{
        if(lfucache.size()==capacity){                  // if capacity is full
            Node v=freqlist.get(minfreq).removenode();  // we will remove lfu
            lfucache.remove(v.key);                     // also from map
        }
        Node newnode=new Node(key,value);               // new key node
        lfucache.put(key,newnode);                         //added in map
        if(freqlist.get(1)!=null){                      //its freq is 1 so we have to add it in freq 1
            freqlist.get(1).addNode(newnode);           // if no element with 1 ,then new DLL we have to make
        }
        else{
	     	DLL d=new DLL();
	     	d.addNode(newnode);
	     	freqlist.put(1,d);
	    }
        minfreq=1;              // new minfreq is 1
	      
    }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */