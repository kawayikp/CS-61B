package java61b.hw5;

import java61b.hw5.list.*;

public class Test {
	  public static void main(String[] argv) {
		    System.out.println("Testing insert()");
		    Set s = new Set();
		    s.insert(new Integer(3));
		    s.insert(new Integer(4));
		    s.insert(new Integer(3));
		    System.out.println("Set s should be { 3 4 }: " + s);

		    Set s2 = new Set();
		    s2.insert(new Integer(4));
		    s2.insert(new Integer(5));
		    s2.insert(new Integer(5));
		    System.out.println("Set s2 should be { 4 5 }: " + s2);

		    Set s3 = new Set();
		    s3.insert(new Integer(5));
		    s3.insert(new Integer(3));
		    s3.insert(new Integer(8));
		    System.out.println("Set s3 should be { 3 5 8 }: " + s3);

		    System.out.println();
		    System.out.println("Tesing union()");
		    s.union(s2);
		    System.out.println("After s.union(s2), s should be { 3 4 5 }: " + s);
		    s2.union(s3);
		    System.out.println("After s2.union(s3), s2 should be { 3 4 5 8 }: " + s2);
		    Set s4 = new Set();
		    System.out.println("Empty set s4 = " + s4);
		    s.union(s4);
		    System.out.println("After s.union(s4), s should be { 3 4 5 }: " + s);
		    s4.union(s);
		    System.out.println("After s4.union(s), s4 should be { 3 4 5 }: " + s4);

		    System.out.println();
		    System.out.println("Tesing intersect()");
		    Set s5 = new Set();
		    Set s6 = new Set();
		    s6.insert(new Integer(1));
		    s5.intersect(s6);
		    System.out.println("{}.intersect({1}) should be { }: " + s5);
		    s6.intersect(s5);
		    System.out.println("{1}.intersect({}) should be { }: " + s6);
		    s6.insert(new Integer(1));
		    Set s7 = new Set();
		    s7.insert(new Integer(1));
		    s7.insert(new Integer(2));
		    s6.intersect(s7);
		    System.out.println("{1}.intersect({1 2}) should be { 1 }: " + s6);
		    s6.insert(new Integer(2));
		    s6.insert(new Integer(3));
		    s6.intersect(s7);
		    System.out.println("{1 2 3}.intersect({1 2}) should be { 1 2 }: " + s6);
		    s6.insert(new Integer(3));
		    s6.insert(new Integer(5));
		    s7.insert(new Integer(4));
		    s7.insert(new Integer(7));
		    s7.intersect(s6);
		    System.out.println("{1 2 4 7}.intersect({1 2 3 5}) should be { 1 2 }: " + s7);

		    System.out.println();
		    System.out.println("Tesing cardinality()");
		    System.out.println("s.cardinality() should be 3: " + s.cardinality());
		    System.out.println("s4.cardinality() should be 3: " + s4.cardinality());
		    System.out.println("s5.cardinality() should be 0: " + s5.cardinality());
		    System.out.println("s6.cardinality() should be 4: " + s6.cardinality());
		    System.out.println("s7.cardinality() should be 2: " + s7.cardinality());
		    
		  }
}
