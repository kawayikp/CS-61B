package java61b.hw5;

import java61b.hw5.list.*;

/**
 *  A Set is a collection of Comparable list stored in sorted order.
 *  Duplicate list are not permitted in a Set.
 **/
public class Set {
    /* Fill in the data fields here. */
    private List list;          // store list of a set


    /**
     * Set ADT invariants:
     *  1)  The Set's list must be precisely the list of the List.
     *  2)  The List must always contain Comparable list, and those list 
     *      must always be sorted in ascending order.
     *  3)  No two list in the List may be equal according to compareTo().
     **/

    /**
     *  Constructs an empty Set. 
     *
     *  Performance:  runs in O(1) time.
     **/
    public Set() { 
        // Your solution here.
        list = new DList();
    }

    /**
     *  cardinality() returns the number of list in this Set.
     *
     *  Performance:  runs in O(1) time.
     **/
    public int cardinality() {
        return list.length();
    }

    /**
     *  insert() inserts a Comparable element into this Set.
     *
     *  Sets are maintained in sorted order.  The ordering is specified by the
     *  compareTo() method of the java.lang.Comparable interface.
     *
     *  Performance:  runs in O(this.cardinality()) time.
     **/
    public void insert(Comparable c) {
        // Your solution here.
        if(c == null) {
            return;
        }
        
        // there's no element in the list
        if(list.length() == 0) {
            list.insertFront(c);
            return;
        }
        
        ListNode walkerNode= list.front();
        try {
            while(walkerNode.isValidNode()) {
                int sign = c.compareTo(walkerNode.item());
                if(sign == 0){
                    return;
                } else if (sign < 0) {
                    walkerNode.insertBefore(c);
                    return;
                } else {
                    walkerNode=walkerNode.next();
                }
            }
            // this is the biggest element
            list.insertBack(c);
        } catch(InvalidNodeException e) {
            System.err.println(e);
        }
    }
    
    /**
     *  union() modifies this Set so that it contains all the list it
     *  started with, plus all the list of s.  The Set s is NOT modified.
     *  Make sure that duplicate list are not created.
     *
     *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
     *
     *  Your implementation should NOT copy list of s or "this", though it
     *  will copy _references_ to the list of s.  Your implementation will
     *  create new _nodes_ for the list of s that are added to "this", but
     *  you should reuse the nodes that are already part of "this".
     *
     *  DO NOT MODIFY THE SET s.
     *  DO NOT ATTEMPT TO COPY ELEMENTS; just copy _references_ to them.
     **/
    public void union(Set s) {
        ListNode thisNode = this.list.front();
        ListNode otherNode = s.list.front();
        Comparable c1, c2;
        int sign;
        
        try {
            while((thisNode.isValidNode()) && (otherNode.isValidNode())) {
                c1 = (Comparable)(thisNode.item());
                c2 = (Comparable)(otherNode.item());
                sign = c1.compareTo(c2);
                if(sign == 0) {
                    otherNode = otherNode.next();
                    thisNode = thisNode.next();
                } else if (sign < 0) {
                    thisNode = thisNode.next();
                } else { // this is the case we need to copy 's' element to 'this'
                    thisNode.insertBefore(otherNode.item());		// ??? shallow copy
                    otherNode = otherNode.next();					
                }
            }
 
            while(otherNode.isValidNode()) {
                this.list.insertBack(otherNode.item());
                otherNode = otherNode.next();
            }
        } catch(InvalidNodeException e) {
            System.err.println(e);
        }
    }

    /**
     *  intersect() modifies this Set so that it contains the intersection of
     *  its own list and the list of s.  The Set s is NOT modified.
     *
     *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
     *
     *  Do not construct any new ListNodes during the execution of intersect.
     *  Reuse the nodes of "this" that will be in the intersection.
     *
     *  DO NOT MODIFY THE SET s.
     *  DO NOT CONSTRUCT ANY NEW NODES.
     *  DO NOT ATTEMPT TO COPY ELEMENTS.
     **/
    public void intersect(Set s) {
        ListNode thisNode = this.list.front();
        ListNode otherNode = s.list.front();
        ListNode tmp;
        Comparable c1, c2;
        int sign;
        
        try{
            while((thisNode.isValidNode()) && otherNode.isValidNode()) {
                c1 = (Comparable)(thisNode.item());
                c2 = (Comparable)(otherNode.item());
                sign = c1.compareTo(c2);
                if(sign == 0) {
                    thisNode = thisNode.next();
                    otherNode=otherNode.next();
                } else if(sign < 0) {
                    tmp = thisNode;
                    thisNode = thisNode.next();
                    tmp.remove();
                } else { // this is 's' set, not to move any element
                    otherNode=otherNode.next();
                }
            }
            // in case we scanned over set 's' first
            // we need to remove the reset of elements in this 'set'
            while(thisNode.isValidNode()) {
                tmp = thisNode;
                thisNode = thisNode.next();
                tmp.remove();
            }
        } catch(InvalidNodeException e) {
            System.err.println(e);
        }
    }

    /**
     *  toString() returns a String representation of this Set.  The String must
     *  have the following format:
     *    {  } for an empty Set.  No spaces before "{" or after "}"; two spaces
     *            between them.
     *    {  1  2  3  } for a Set of three Integer list.  No spaces before
     *            "{" or after "}"; two spaces before and after each element.
     *            Elements are printed with their own toString method, whatever
     *            that may be.  The list must appear in sorted order, from
     *            lowest to highest according to the compareTo() method.
     *
     *  WARNING:  THE AUTOGRADER EXPECTS YOU TO PRINT SETS IN _EXACTLY_ THIS
     *            FORMAT, RIGHT UP TO THE TWO SPACES BETWEEN ELEMENTS.  ANY
     *            DEVIATIONS WILL LOSE POINTS.
     **/
    public String toString() {
        // Replace the following line with your solution.
        String s = "{  ";
        ListNode walkerNode= list.front();
        try {
            while(walkerNode.isValidNode()) {
                s += walkerNode.item() + "  ";
                walkerNode = walkerNode.next();
            }
        }
        catch(InvalidNodeException e) {
            System.err.println(e);
        }
        s += "}";
        return s;
    }

    public static void main(String[] argv) {
        Set s = new Set();
        s.insert(new Integer(3));
        s.insert(new Integer(4));
        s.insert(new Integer(3));
        System.out.println("Set s = " + s);

        Set s2 = new Set();
        s2.insert(new Integer(4));
        s2.insert(new Integer(5));
        s2.insert(new Integer(5));
        System.out.println("Set s2 = " + s2);

        Set s3 = new Set();
        s3.insert(new Integer(5));
        s3.insert(new Integer(3));
        s3.insert(new Integer(8));
        System.out.println("Set s3 = " + s3);

        s.union(s2);
        System.out.println("After s.union(s2), s = " + s);

        s.intersect(s3);
        System.out.println("After s.intersect(s3), s = " + s);

        System.out.println("s.cardinality() = " + s.cardinality());
      }
}
