package Medium;

/**
 *
 */
public class MyHashMap {
    Object[] store;
    /** Initialize your data structure here. */
    public MyHashMap() {
        store=new Object[1000001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        store[key]=value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this mp contains no mapping for the key */
    public int get(int key) {
        if(store[key]!=null){
            return (Integer)store[key];}
        else return -1;
    }

    /** Removes the mapping of the specified value key if this mp contains a mapping for the key */
    public void remove(int key) {
        if(store[key]!=null){
            store[key]=-1;
        }
    }
}
