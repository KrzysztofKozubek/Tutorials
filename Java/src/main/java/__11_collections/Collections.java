package __11_collections;


/*
 * Collections is structure date to collect date
 *
 * java2 provided Dictionary, Vector, Stack, Properties
 *
 * Object -> Dictionary -> HashTable (Serializable, Cloneable, Map) -> Properties
 *
 * The most popular collections:
 *
 *                                   Collections I
 *
 *   List IO                          Set INO                              Queue I
 *   |                         |               |                        |            |
 *   ArrayList              HashSet        SortedSet IS         PriorityQueue ONN  BlockingQueue I
 *   LinkedList                |                |
 *   Vector TS           LinkedHashSet O   NavigableSet I
 *   |                                         |
 *   Stack                                 TreeSet ONN
 *
 *
 *                                   Map I
 *
 *               SortedMap IS       AbstractMap
 *                          |       |     |      |                |
 *                       SNN TreeMap   HashMap   HashTable TS NN  ConcurrentHashMap
 *                                        |
 *                                   LinkedHashMap O
 *
 *
 *   legend:
 *       I - interface
 *       O / NO - order / no order
 *       TS - threads safe
 *       S - sorted
 *       NN - not null
 * */

import java.util.*;

public class Collections {

    private void list() {
        List<Object> list = new ArrayList<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        LinkedList<Object> linkedList = new LinkedList<>();
        Vector<Object> vector = new Vector<>();
        Stack<Object> stack = new Stack<>();

        linkedList.getFirst();
        linkedList.getLast();
        linkedList.offerFirst(new Object()); // add on start list ele
        linkedList.offerLast(new Object()); // add on end list ele
        linkedList.peekFirst(); // Retrieves, but does not remove
        linkedList.peekLast(); // Retrieves, but does not remove
        linkedList.poll(); // Retrieves and removes the head
        linkedList.pop(); // Pops an element from the stack represented by this list
    }

    private void set() {
        HashSet<Object> hashSet = new HashSet<>();
        LinkedHashSet linkedHashSet = new LinkedHashSet();

        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.ceiling(new Object()); // Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
    }

    private void queue() {
        PriorityQueue<Object> priorityQueue = new PriorityQueue<>();
    }
}
