package linkedlist;

/**
 *
 * @author Matt Getz
 */
public class LinkedList {

    private Link first;
    private Link last;
    public int length;

    public LinkedList() {
        first = null;
        length = 0;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void push(Friend data) {
        Link newLink = new Link(data);
        newLink.next = first;
        first = newLink;
        length++;
    }

    public Link pop() {
        if (length > 0) {
            Link temp = first;
            first = first.next;
            length--;
            return temp;
        }
        return null;
    }

    public Link peek() {
        return first;
    }

    public Link remove() {
        return null;
    }
    
    public Link find(String key) {
        Link current = first;
        while (!current.data.getName().equalsIgnoreCase(key)) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int index) {
        Link current = first;
        Link previous = first;

        int count = 0;
        if (!isEmpty()) {
            while (count != index) {
                if (current.next == null) {
                    return null;
                } else {
                    previous = current;
                    current = current.next;
                }
                count++;
            }
            if (current == first) {
                first = first.next;
            } else {
                previous.next = current.next;
            }
            length--;
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        Link current = first;
        while (current != null) {
            sb.append(current.toString()).append("\n");
            current = current.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(new Friend("Tom", 5));
        list.push(new Friend("Mary", 7));
        list.push(new Friend("Steve", 6));
        System.out.println(list);
        System.out.println("Length is " + list.length);

        System.out.println("Peek: " + list.peek());

        System.out.println("Match for Tom: " + list.find("Tom"));
        System.out.println("Match for Mary: " + list.find("Mary"));
        System.out.println("Match for Steve: " + list.find("Steve"));
        System.out.println("Match for Mark: " + list.find("Mark"));

        Link link = list.pop();
        System.out.println("Pop: " + link);
        System.out.println(list);
        System.out.println("Length is " + list.length);

        if (list.delete(0) != null) {
            System.out.println("Item deleted\n" + list);
        } else {
            System.out.println("Null value on delete");
        }

        System.out.println("Length is " + list.length);
    }
}
