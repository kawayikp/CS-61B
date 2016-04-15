package java61b.hw4.list;

public class LockDList extends DList{
	
	 public LockDList() {
		 //super class constructor called by default
	 }

	@Override
	protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
	    return new LockDListNode(item, prev, next);
	}
	
	public void lockNode(DListNode node) {
		((LockDListNode) node).isLocked = true;
	}
	
	@Override
	public void remove(DListNode node) {
		  if (((LockDListNode) node).isLocked == false) {
			  super.remove(node);
		  }
	}
  
}
