package java61b.hw4.list;

public class LockDListNode extends DListNode {
	protected boolean isLocked;
	LockDListNode(Object o, DListNode p, DListNode n) {
		super(o, p, n);
		isLocked = false;
	}
}
