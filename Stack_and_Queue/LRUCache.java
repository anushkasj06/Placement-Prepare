import java.util.*;

public class LRUCache {
    class DLL {
        int key;
        int val;
        DLL prev;
        DLL next;

        public DLL(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private Map<Integer, DLL> posMp;
    private int maxCap;
    private DLL firstElement, lastElement;

    public LRUCache(int capacity) {
        posMp = new HashMap<>();
        maxCap = capacity;
        firstElement = null;
        lastElement = null;
    }

        private void moveForward(DLL node) {
        if (firstElement == node) {
            return;
        } else {
            DLL prev = node.prev;
            DLL next = node.next;
            if (next != null) {
                prev.next = next;
                next.prev = prev;
            } else {
                prev.next = null;
                lastElement = prev;
            }
            // change current node's pointing...
            node.prev = null;
            node.next = firstElement;
            firstElement.prev = node;
            firstElement = node;
        }
    }

    
    public int get(int key) {
        if (posMp.containsKey(key)) {
            moveForward(posMp.get(key));
            return posMp.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
    if (posMp.containsKey(key)) {
            DLL node = posMp.get(key);
            node.val = value;
            posMp.put(key, node);
            moveForward(posMp.get(key));
        } else {
            if (posMp.size() >= maxCap) {
                if (firstElement == lastElement) {
                    posMp.remove(firstElement.key);
                    firstElement = null;
                    lastElement = null;
                } else {
                    posMp.remove(lastElement.key);
                    DLL prev = lastElement.prev;
                    prev.next = null;
                    lastElement.prev = null;
                    lastElement = prev;
                }
            }
            DLL dll = new DLL(key, value);
            if (firstElement == null && firstElement == lastElement) {
                firstElement = dll;
                lastElement = dll;
            } else {
                dll.next = firstElement;
                firstElement.prev = dll;
                firstElement = dll;
            }
            posMp.put(key, dll);
        }
    }
}
