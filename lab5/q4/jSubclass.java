public class jSubclass extends jSuperclass {
    public void print() {
        System.out.println("in subclass");
    }
    
    public static void method1() {
    	System.out.println("In subclass");
    }
    
    public static void main(String[] argv) {
        jSuperclass sup = new jSubclass();
        ((jSubclass)sup).print();
        jSubclass sub = new jSubclass();
        sub.method1();
        sup = sub;
        sup.method1();
    }
}