package linkedlist;

/**
 * Represents a single link object.
 * 
 * @author Matt Getz
 */
public class Link {
    public Friend data; // Can be replaced with any kind of object you want to keep track of (ex. employee info)
    public Link next; //Points to object in memory
    
    public Link(Friend data) {
        this.data = data;
        this.next = null;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
}
